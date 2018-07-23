package biz.coupon.consume.controller;

import biz.coupon.api.model.CouponMainData;
import biz.coupon.api.service.DetailCouponService;
import biz.coupon.api.service.MainCouponService;
import biz.coupon.api.util.CouponDetailDataStatus;
import biz.coupon.api.util.MainDataStatus;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by dev on 2018/4/17.
 */
@Service("expireJobTask")
public class ExpireJobTask {

    @Resource
    private DetailCouponService detailCouponService;

    @Resource
    private MainCouponService mainCouponService;

    public void doJob(){
        //获得当前时间
        Date currentDate = new Date();
        //失效活动集合
        List<Long> failActivitList = Lists.newArrayList();
        //时间格式化
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            CouponMainData param = new CouponMainData();
            param.setState(MainDataStatus.NORMAL.getValue());
            List<CouponMainData> couponMainDataList = mainCouponService.getCouponMainDataListByCouponMainData(param);
            if(CollectionUtils.isNotEmpty(couponMainDataList)){
                ListIterator<CouponMainData> couponMainDataListIterator = couponMainDataList.listIterator();
                while(couponMainDataListIterator.hasNext()){
                    CouponMainData next = couponMainDataListIterator.next();
                    String endDateStr = next.getEndDate();

                    Date endDate = formatter.parse(endDateStr);
                    //如果 当前时间大于 endDate 则过期
                    if(currentDate.after(endDate)){
                        failActivitList.add(next.getId());
                    }

                }
           }
           //如果有过期的
           if(CollectionUtils.isNotEmpty(failActivitList)){
               for (Long mainId : failActivitList) {
                   if(mainId!=null){
                       CouponMainData couponMainData = new CouponMainData();
                       couponMainData.setId(mainId);
                       couponMainData.setState(MainDataStatus.STOP.getValue());
                       mainCouponService.updateCouponMainData(couponMainData);
                       detailCouponService.updateByMid(mainId, CouponDetailDataStatus.STATUS_205.getCode());
                   }
               }

           }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
