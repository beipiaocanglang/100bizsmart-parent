package biz.coupon.consume.controller;

import biz.consume.frame.util.JsonUtil;
import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.CouponMainData;
import biz.coupon.api.model.bo.*;
import biz.coupon.api.service.DetailCouponService;
import biz.coupon.api.service.MainCouponService;
import biz.coupon.api.util.CouponDetailDataStatus;
import biz.coupon.api.util.CouponTypeEnum;
import biz.coupon.api.util.MainDataStatus;
import biz.coupon.api.util.ResultDataBuilder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dev on 2018/4/10.
 */
@Controller
@RequestMapping(value = "api/ccoup")
public class CouponController {

    @Resource
    private DetailCouponService detailCouponGetService;

    @Resource
    private MainCouponService mainCouponGetService;

    //时间格式化
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

    /**
     * 接口1
     * 调用接口查询单张券 CouponDetailData
     *
     * @return
     */
    @PostMapping(value = "coupscanTest")
    @ResponseBody
    public ResultData coupscan(@RequestBody CoupScanParam coupScanParam) {
        CoupScanRO coupScanRO = new CoupScanRO();
        //校验参数
        if (coupScanParam == null || StringUtils.isEmpty(coupScanParam.getCouponNo())) {
            return ResultDataBuilder.buildErrorResultData("参数异常");
        }
        try {
            //根据券code查询券信息
            CouponDetailData couponDetailData = detailCouponGetService.getByCode(coupScanParam.getCouponNo());

            if (couponDetailData == null) {
                return ResultDataBuilder.buildErrorResultData("未查询到此优惠券", 202);
            }
            //***券ID ，券码，状态 ,状态说明
            coupScanRO.setCouponNo(couponDetailData.getCode());
            coupScanRO.setCode(couponDetailData.getState());
            coupScanRO.setMessage(couponDetailData.getState() == null ? null : CouponDetailDataStatus.getCouponDetailDataStatusDescByCode(couponDetailData.getState()));
            //该券所属用户
            String uid = couponDetailData.getUid();
            //该券所属活动code
            Long mid = couponDetailData.getMid();
            //查询出该用户已经领取了该活动的券集合
            CouponDetailData couponDetailDataParam = new CouponDetailData();
            couponDetailDataParam.setState(CouponDetailDataStatus.STATUS_200.getCode());
            couponDetailDataParam.setMid(mid);
            couponDetailDataParam.setUid(uid);
            List<CouponDetailData> couponDetailDataList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
            if (CollectionUtils.isNotEmpty(couponDetailDataList)) {
                Set<String> codes = Sets.newHashSet();
                for (CouponDetailData detailData : couponDetailDataList) {
                    codes.add(detailData.getCode());
                }
                //*** 集合
                coupScanRO.setAvailableCoupons(codes);
                coupScanRO.setAvailableNum(couponDetailDataList.size());
            } else {
                coupScanRO.setAvailableNum(0);
                Set<String> codes = Sets.newHashSet();
                coupScanRO.setAvailableCoupons(codes);
            }

            //根据活动code查询活动信息
            CouponMainData couponMainData = mainCouponGetService.getById(couponDetailData.getMid());
            if (couponMainData != null) {
                //***名称 活动编码
                coupScanRO.setCouponName(couponMainData.getName());
                coupScanRO.setPromotionCode(couponMainData.getPromotionCode());
                //***开始结束时间
                coupScanRO.setBegDate(couponMainData.getBeginDate());
                coupScanRO.setEndDate(couponMainData.getEndDate());
                //***本金。。。
                coupScanRO.setCapital(couponMainData.getCapital());
                coupScanRO.setExemption(couponMainData.getExemption());
                coupScanRO.setFaceValue(couponMainData.getFaceValue());
                coupScanRO.setThreshold(couponMainData.getThreshold());
                //***类型。。。
                coupScanRO.setCouponType(couponMainData.getType());
                coupScanRO.setCouponTypeDesc(CouponTypeEnum.getCouponTypeEnumByCode(couponMainData.getType()).getDesc());
                //***说明
                coupScanRO.setGuide(couponMainData.getGuide());
                //***门店ID
                coupScanRO.setShopCode(couponMainData.getStoreId());
            }
            coupScanRO.setMessage("ok");
            return ResultDataBuilder.buildSuccessResultData(coupScanRO, Boolean.TRUE, 200, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDataBuilder.buildErrorResultData("查询异常");
        }
    }

    /**
     * 接口1.1
     * 调用接口查询单张券 CouponDetailData
     *
     * @return
     */
    @PostMapping(value = "coupscan")
    @ResponseBody
    public ResultData coupscanByStoreId(@RequestBody CoupScanStoreParam coupScanStoreParam) {
        logger.info("进入coupscanByStoreId -- 调用接口查询单张券方法");
        logger.info("入参："+ JsonUtil.toJson(coupScanStoreParam));

        CoupScanRO coupScanRO = new CoupScanRO();
        //校验参数
        if (coupScanStoreParam == null || StringUtils.isEmpty(coupScanStoreParam.getCouponNo())) {
            logger.info("参数不正确："+ JsonUtil.toJson(coupScanStoreParam));
            return ResultDataBuilder.buildErrorResultData("参数不正确");
        }

        try {
            //根据券code查询券信息
            CouponDetailData couponDetailData = detailCouponGetService.getByCode(coupScanStoreParam.getCouponNo());
            logger.info("couponDetailData："+ JsonUtil.toJson(couponDetailData));

            if (couponDetailData == null) {
                logger.info("couponDetailData==null");
                return ResultDataBuilder.buildErrorResultData("未查询到此优惠券", 202);
            }

            //***券ID ，券码，状态 ,状态说明
            coupScanRO.setCouponNo(couponDetailData.getCode());
            coupScanRO.setCode(couponDetailData.getState());
            coupScanRO.setMessage(couponDetailData.getState() == null ? null : CouponDetailDataStatus.getCouponDetailDataStatusDescByCode(couponDetailData.getState()));

            //该券所属用户
            String uid = couponDetailData.getUid();
            //该券所属活动code
            Long mid = couponDetailData.getMid();
            //查询出该用户已经领取了该活动的券集合200
            CouponDetailData couponDetailDataParam = new CouponDetailData();
            couponDetailDataParam.setState(CouponDetailDataStatus.STATUS_200.getCode());
            couponDetailDataParam.setMid(mid);
            couponDetailDataParam.setUid(uid);

            List<CouponDetailData> couponDetailDataList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
            logger.info("查询出该用户已经领取了该活动的券集合200");
            logger.info("couponDetailDataList："+ JsonUtil.toJson(couponDetailDataList));

            if (CollectionUtils.isNotEmpty(couponDetailDataList)) {
                Set<String> codes = Sets.newHashSet();
                for (CouponDetailData detailData : couponDetailDataList) {
                    codes.add(detailData.getCode());
                }
                //*** 集合
                coupScanRO.setAvailableCoupons(codes);
                coupScanRO.setAvailableNum(couponDetailDataList.size());
            } else {
                coupScanRO.setAvailableNum(0);
                Set<String> codes = Sets.newHashSet();
                coupScanRO.setAvailableCoupons(codes);
            }

            //根据活动code查询活动信息
            logger.info("根据活动code查询活动信息 参数:"+JsonUtil.toJson(couponDetailData));
            CouponMainData couponMainData = mainCouponGetService.getById(couponDetailData.getMid());
            logger.info("根据活动code查询活动信息 结果:"+JsonUtil.toJson(couponMainData));

            if (couponMainData != null) {
                //校验是否是门店
                if (StringUtils.isNotEmpty((coupScanStoreParam.getShopCode()))) {
                    if (!(couponMainData.getStoreId().equals(coupScanStoreParam.getShopCode()))) {
                        return ResultDataBuilder.buildErrorResultData("该门店不可用");
                    }
                }

                //***名称 活动编码
                coupScanRO.setCouponName(couponMainData.getName());
                coupScanRO.setPromotionCode(couponMainData.getPromotionCode());
                //***开始结束时间
                coupScanRO.setBegDate(couponMainData.getBeginDate());
                coupScanRO.setEndDate(couponMainData.getEndDate());
                //***本金。。。
                coupScanRO.setCapital(couponMainData.getCapital());
                coupScanRO.setExemption(couponMainData.getExemption());
                coupScanRO.setFaceValue(couponMainData.getFaceValue());
                coupScanRO.setThreshold(couponMainData.getThreshold());
                //***类型。。。
                coupScanRO.setCouponType(couponMainData.getType());
                coupScanRO.setCouponTypeDesc(CouponTypeEnum.getCouponTypeEnumByCode(couponMainData.getType()).getDesc());
                //***说明
                coupScanRO.setGuide(couponMainData.getGuide());
                //***门店ID
                coupScanRO.setShopCode(couponMainData.getStoreId());
            }
            coupScanRO.setMessage("ok");
            logger.info("coupScanRO 结果:"+JsonUtil.toJson(coupScanRO));
            return ResultDataBuilder.buildSuccessResultData(coupScanRO, Boolean.TRUE, 200, "成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultDataBuilder.buildErrorResultData("查询异常");
        }
    }

    //转换时间格式
    private String converteDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            String dateString = formatter.format(date);
            return dateString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 接口2
     * 调用接口核销券
     *
     * @return
     */
    @PostMapping(value = "coupuse")
    @ResponseBody
    public ResultData coupuse(@RequestBody CoupuseParam coupuseParam) {
        logger.info("调用接口核销券 coupuse 入参:"+JsonUtil.toJson(coupuseParam));
        List<Long> successIdList = Lists.newArrayList();
        List<String> successList = Lists.newArrayList();
        List<String> failList = Lists.newArrayList();

        try {
            if (coupuseParam != null && StringUtils.isNotEmpty(coupuseParam.getCouponNo())) {
                logger.info("根据code查询detail  入参:"+JsonUtil.toJson(coupuseParam.getCouponNo()));
                CouponDetailData couponDetailData = detailCouponGetService.getByCode(coupuseParam.getCouponNo());
                logger.info("根据code查询detail  结果:"+JsonUtil.toJson(couponDetailData));

                if (!(200 == couponDetailData.getState())) {
                    return ResultDataBuilder.buildErrorResultData("当前券状态不可核销", 2000);
                }

                logger.info("根据mid查询main  入参:"+JsonUtil.toJson(couponDetailData.getMid()));
                CouponMainData couponMainData = mainCouponGetService.getById(couponDetailData.getMid());
                logger.info("根据mid查询main  结果:"+JsonUtil.toJson(couponMainData));

                //判断门店是否合理
                if (couponMainData != null) {
                    if (!(couponMainData.getStoreId().equals(coupuseParam.getShopCode()))) {
                        return ResultDataBuilder.buildErrorResultData("核销门店异常", 2001);
                    }
                } else {
                    return ResultDataBuilder.buildErrorResultData("不存在活动", 2002);
                }

                //获取mid uid
                CouponDetailData couponDetailDataParam = new CouponDetailData();
                couponDetailDataParam.setMid(couponDetailData.getMid());
                couponDetailDataParam.setUid(couponDetailData.getUid());
                couponDetailDataParam.setState(CouponDetailDataStatus.STATUS_200.getCode());

                logger.info("根据couponDetailDataParam查询couponDetailDataList  入参:"+JsonUtil.toJson(couponDetailDataParam));
                List<CouponDetailData> couponDetailDataList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
                logger.info("根据couponDetailDataParam查询couponDetailDataList  结果:"+JsonUtil.toJson(couponDetailDataList));

                if (CollectionUtils.isNotEmpty(couponDetailDataList) && couponDetailDataList.size() >= (coupuseParam.getCouponNum())) {
                    /**
                     * 当前码
                     */
                    try {
                        couponDetailData.setState(CouponDetailDataStatus.STATUS_206.getCode());
                        couponDetailData.setPayOn(converteDate(new Date()));
                        couponDetailData.setSalesNo(coupuseParam.getSalesNo());
                        couponDetailData.setShopCode(coupuseParam.getShopCode());

                        detailCouponGetService.updateCouponDetailData(couponDetailData);

                        successIdList.add(couponDetailData.getId());
                        successList.add(couponDetailData.getCode());
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                        failList.add(couponDetailData.getCode());
                    }

                    //现金券判断 只有现金券才可以多张核销
                    if(CouponTypeEnum.DJ.getCode().equals(couponMainData.getType())){
                        ListIterator<CouponDetailData> couponDetailDataListIterator = couponDetailDataList.listIterator();

                        while (couponDetailDataListIterator.hasNext()) {
                            CouponDetailData couponDetailData1 = couponDetailDataListIterator.next();
                            if (couponDetailData1.getCode().equals(couponDetailData.getCode())) {
                                couponDetailDataListIterator.remove();
                            }
                        }

                        for (int i = 0; i < coupuseParam.getCouponNum() - 1; i++) {

                            CouponDetailData detailData = couponDetailDataList.get(i);
                            if (detailData.getCode().equals(couponDetailData.getCode())) {
                                continue;
                            }

                            detailData.setState(CouponDetailDataStatus.STATUS_206.getCode());
                            detailData.setPayOn(converteDate(new Date()));
                            detailData.setSalesNo(coupuseParam.getSalesNo());
                            detailData.setShopCode(coupuseParam.getShopCode());

                            try {
                                detailCouponGetService.updateCouponDetailData(detailData);
                                successList.add(detailData.getCode());
                                successIdList.add(detailData.getId());
                            } catch (Exception e) {
                                logger.error(e.getMessage());
                                failList.add(detailData.getCode() + "核销失败");
                                break;
                            }
                        }
                    }

                } else {
                    return ResultDataBuilder.buildSuccessResultData(failList, Boolean.FALSE, 2003, "可用优惠券(" + couponDetailDataList.size() + ")不足以满足核销需求(" + coupuseParam.getCouponNum() + ")");
                }
            }

            if (failList.size() > 0) {
                rollBackUpdate(successIdList);//回滚
                return ResultDataBuilder.buildSuccessResultData(failList, Boolean.FALSE, 2000, "核销失败");
            } else if (successList.size() > 0) {
                return ResultDataBuilder.buildSuccessResultData(successList, Boolean.TRUE, 200, "核销成功");
            } else {
                return ResultDataBuilder.buildSuccessResultData(failList, Boolean.FALSE, 2000, "未核销任务优惠券");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultDataBuilder.buildErrorResultData("核销异常");
        }
    }

    private void rollBackUpdate(List<Long> successIdList){
        try {
            if(CollectionUtils.isNotEmpty(successIdList)){
                ListIterator<Long> longListIterator = successIdList.listIterator();
                while (longListIterator.hasNext()){
                    Long next = longListIterator.next();
                    CouponDetailData detailData = new CouponDetailData();
                    detailData.setId(next);
                    detailData.setState(CouponDetailDataStatus.STATUS_200.getCode());
                    detailCouponGetService.updateCouponDetailData(detailData);
                }
            }
        } catch (Exception e) {
            //这都抛异常，再议
            logger.error(e.getMessage());
        }
    }

    /**
     * 接口3
     * 查询可领优惠券列表
     *
     * @return
     */
    @PostMapping(value = "couponlist")
    @ResponseBody
    public ResultData couponlist(@RequestBody GetCouponVO getCouponVO) {
        logger.info("查询所有活动--查询可领优惠券列表--couponlist");

        List<CouponListRO> couponListROList = Lists.newArrayList();
        try {
            couponListROList = Lists.newArrayList();
            // 只查询状态是正常的活动
            CouponMainData mainDataParam = new CouponMainData();
            mainDataParam.setState(MainDataStatus.NORMAL.getValue());

            List<CouponMainData> couponMainDataList = mainCouponGetService.getCouponMainDataListByCouponMainData(mainDataParam);
            logger.info("查询可领优惠券列表："+JsonUtil.toJson(couponMainDataList));

            //获取该用户领取的券数量按mid分组
            List<MidCountBO> countUidGroupByMid = detailCouponGetService.getCountDetailDataByUidGroupByMid(getCouponVO.getUid());

            Map<Long,Integer> countUidGroupByMidMap = Maps.newHashMap();
            if(CollectionUtils.isNotEmpty(countUidGroupByMid)){
                ListIterator<MidCountBO> midCountBOListIterator = countUidGroupByMid.listIterator();
                while(midCountBOListIterator.hasNext()){
                    MidCountBO next = midCountBOListIterator.next();
                    countUidGroupByMidMap.put(next.getMid(),next.getCount());
                }
            }

            //获取活动总领取数量，按mid分组
            List<MidCountBO> countGroupByMid = detailCouponGetService.getCountDetailDataGroupByMid();

            Map<Long,Integer> countGroupByMidMap = Maps.newHashMap();
            if(CollectionUtils.isNotEmpty(countGroupByMid)){
                ListIterator<MidCountBO> midCountBOListIterator = countGroupByMid.listIterator();
                while(midCountBOListIterator.hasNext()){
                    MidCountBO next = midCountBOListIterator.next();
                    countGroupByMidMap.put(next.getMid(),next.getCount());
                }
            }

            //遍历mainList 把达到个人和总领取数量的活动筛除掉
            if(CollectionUtils.isNotEmpty(couponMainDataList)){
                ListIterator<CouponMainData> couponMainDataListIterator = couponMainDataList.listIterator();
                while(couponMainDataListIterator.hasNext()){
                    CouponMainData couponMainData = couponMainDataListIterator.next();
                    Integer allCount = couponMainData.getCountMax();
                    Integer userCountMax = couponMainData.getUserCountMax();
                    Long id = couponMainData.getId();
                    //先判断总的
                    if(countGroupByMidMap.get(id)!=null && countGroupByMidMap.get(id)>=allCount){
                        couponMainDataListIterator.remove();
                        continue;
                    }
                    //再判断个人的
                    if(countUidGroupByMidMap.get(id)!=null && countUidGroupByMidMap.get(id)>=userCountMax){
                        couponMainDataListIterator.remove();
                        continue;
                    }
                }
            }

            if (CollectionUtils.isNotEmpty(couponMainDataList)) {
                for (CouponMainData mainData : couponMainDataList) {
                    CouponListRO couponListRO = new CouponListRO();
                    couponListRO.setBegin(mainData.getBeginDate());
                    couponListRO.setEnd(mainData.getEndDate());
                    couponListRO.setDesc(mainData.getGuide());
                    couponListRO.setName(mainData.getName());
                    couponListRO.setCouponId(mainData.getId() + "");
                    couponListROList.add(couponListRO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
           logger.error(e.getMessage());
        }

        logger.info("结果："+JsonUtil.toJson(couponListROList));

        if (CollectionUtils.isNotEmpty(couponListROList)) {
            return ResultDataBuilder.buildSuccessResultData(couponListROList, Boolean.TRUE, 200, "成功");
        } else {
            return ResultDataBuilder.buildSuccessResultData(null, Boolean.FALSE, 500, "暂无数据");
        }
    }


    /**
     * 接口3.1
     * 查询所有可领优惠券列表
     * @return
     * author : sunpanhu
     * createTime : 2018/5/14 上午11:26
     */
    @GetMapping(value = "findAllCouponlist")
    @ResponseBody
    public ResultData findAllCouponlist(Integer page, Integer rows) {
        logger.info("查询所有活动--查询优惠券列表--方法参数: page="+page + ",rows="+rows);

        try {
            //查询前设置分页信息
            PageHelper.startPage(page, rows);
            logger.info("查询couponMainDataListAll 无参数：");
            List<CouponMainData> couponMainDataListAll = mainCouponGetService.getCouponMainDataListAll();
            logger.info("查询couponMainDataListAll 结果："+JsonUtil.toJson(couponMainDataListAll));

            if (couponMainDataListAll == null) {
                couponMainDataListAll = new ArrayList<CouponMainData>();
            }

            for (CouponMainData couponMainData : couponMainDataListAll) {
                couponMainData.setStateDesc(MainDataStatus.getByValue(couponMainData.getState()).getDesc());
                couponMainData.setTypeDesc(CouponTypeEnum.getCouponTypeEnumByCode(couponMainData.getType()).getDesc());
            }

            //创建PageInfo对象
            PageInfo<CouponMainData> couponPageInfo = new PageInfo<CouponMainData>(couponMainDataListAll);
            logger.info("查询couponMainDataListAll 分页后的结果："+JsonUtil.toJson(couponPageInfo));

            return ResultDataBuilder.buildSuccessResultData(couponPageInfo, Boolean.TRUE, 200, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResultDataBuilder.buildSuccessResultData(null, Boolean.FALSE, 500, "暂无数据");
        }
    }


    /**
     * 接口4
     * 领取优惠卷
     * 生成优惠卷detail
     *
     * @return
     */
    @PostMapping(value = "getcoupon")
    @ResponseBody
    public ResultData getcoupon(@RequestBody GetCouponVO getCouponVO) {
        logger.info("领取优惠卷 -- 生成优惠卷detail -- getcoupon");

        if (StringUtils.isEmpty(getCouponVO.getUid())) {
            return ResultDataBuilder.buildErrorResultData("uid不能为空");
        }

        //查询活动可领总数和个人可领总数
        logger.info("查询活动可领总数和个人可领总数 参数："+JsonUtil.toJson(getCouponVO.getCouponId()));
        CouponMainData couponMainData = mainCouponGetService.getById(Long.parseLong(getCouponVO.getCouponId()));
        logger.info("查询活动可领总数和个人可领总数 结果："+JsonUtil.toJson(couponMainData));

        //查询该活动已领取总数
        CouponDetailData couponDetailDataParam = new CouponDetailData();
        couponDetailDataParam.setMid(Long.parseLong(getCouponVO.getCouponId()));

        logger.info("查询该活动已领取总数 参数："+JsonUtil.toJson(couponDetailDataParam));
        List<CouponDetailData> couponDetailDataAllList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
        logger.info("查询该活动已领取总数 结果："+JsonUtil.toJson(couponDetailDataAllList));

        if (CollectionUtils.isNotEmpty(couponDetailDataAllList) && couponDetailDataAllList.size() >= couponMainData.getCountMax()) {
            return ResultDataBuilder.buildErrorResultData("已超过领取额度");
        }

        //查询该活动当前用户领取数量
        couponDetailDataParam.setUid(getCouponVO.getUid());
        logger.info("查询该活动当前用户领取数量 参数："+JsonUtil.toJson(couponDetailDataParam));
        List<CouponDetailData> couponDetailDataUserList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
        logger.info("查询该活动当前用户领取数量 结果："+JsonUtil.toJson(couponDetailDataUserList));

        if (CollectionUtils.isNotEmpty(couponDetailDataUserList) && couponDetailDataUserList.size() >= couponMainData.getUserCountMax()) {
            return ResultDataBuilder.buildErrorResultData("您已经领取了" + couponDetailDataUserList.size() + "张已超过个人领取额度，不可继续领取");
        }

        //生成用户券
        String code = createDetailCode();
        CouponDetailData createCouponDetailData = new CouponDetailData();
        createCouponDetailData.setUid(getCouponVO.getUid());
        createCouponDetailData.setRefPromotionCode(getCouponVO.getCouponId());
        createCouponDetailData.setMid(couponMainData.getId());
        createCouponDetailData.setCode(code);
        createCouponDetailData.setState(CouponDetailDataStatus.STATUS_200.getCode());

        logger.info("生成用户券 参数："+JsonUtil.toJson(createCouponDetailData));
        detailCouponGetService.saveCouponDetailData(createCouponDetailData);
        logger.info("生成用户券 结果："+JsonUtil.toJson(createCouponDetailData));

        if (createCouponDetailData.getId() != null) {
            return ResultDataBuilder.buildSuccessResultData(null, Boolean.TRUE, 200, "成功");
        } else {
            return ResultDataBuilder.buildErrorResultData("生成券失败");
        }
    }

    //生成券码
    private String createDetailCode() {
        String preStr = "WZ";
        String code = preStr + getFixLenthString(16);
        return code;
    }

    private static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(2, strLength + 1);
    }

    /**
     * 接口5
     * 查询已领优惠券
     *
     * @return
     */
    @PostMapping(value = "getmycouponlist")
    @ResponseBody
    public ResultData getmycouponlist(@RequestBody GetCouponVO getCouponVO) {
        logger.info("查询已领优惠券 getmycouponlist 参数："+JsonUtil.toJson(getCouponVO));
        List<CouponListRO> couponListROList = Lists.newArrayList();

        CouponDetailData couponDetailDataParam = new CouponDetailData();
        couponDetailDataParam.setUid(getCouponVO.getUid());
        couponDetailDataParam.setState(CouponDetailDataStatus.STATUS_200.getCode());

        logger.info("查询couponDetailDataList 参数："+JsonUtil.toJson(couponDetailDataParam));
        List<CouponDetailData> couponDetailDataList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
        logger.info("查询couponDetailDataList 结果："+JsonUtil.toJson(couponDetailDataList));
        logger.info("查询couponMainDataListAll 无参数：");
        List<CouponMainData> couponMainDataListAll = mainCouponGetService.getCouponMainDataListAll();
        logger.info("查询couponMainDataListAll 结果："+JsonUtil.toJson(couponMainDataListAll));

        Map<Long, CouponMainData> couponMainDataMap = Maps.newHashMap();

        if (CollectionUtils.isNotEmpty(couponMainDataListAll)) {
            for (CouponMainData couponMainData : couponMainDataListAll) {
                couponMainDataMap.put(couponMainData.getId(), couponMainData);
            }
        }
        logger.info("couponMainDataMap 结果："+JsonUtil.toJson(couponMainDataMap));

        if (CollectionUtils.isNotEmpty(couponDetailDataList)) {
            for (CouponDetailData couponDetailData : couponDetailDataList) {
                if (couponMainDataMap.get(couponDetailData.getMid()) != null) {
                    CouponMainData mainData = couponMainDataMap.get(couponDetailData.getMid());
                    CouponListRO couponListRO = new CouponListRO();
                    couponListRO.setBegin(mainData.getBeginDate());
                    couponListRO.setEnd(mainData.getEndDate());
                    couponListRO.setDesc(mainData.getGuide());
                    couponListRO.setName(mainData.getName());
                    couponListRO.setCouponCode(couponDetailData.getCode());
                    couponListRO.setCouponId(couponDetailData.getId() + "");
                    couponListRO.setCouponStatus(couponDetailData.getState());
                    couponListROList.add(couponListRO);
                }
            }
        }
        logger.info("couponListROList 结果："+JsonUtil.toJson(couponListROList));

        if (CollectionUtils.isNotEmpty(couponListROList)) {
            return ResultDataBuilder.buildSuccessResultData(couponListROList, Boolean.TRUE, 200, "成功");
        } else {
            return ResultDataBuilder.buildErrorResultData("未查询到优惠卷记录");
        }
    }

    /**
     * 接口6
     * 使用券
     *
     * @return
     */
    @PostMapping(value = "showmycoupon")
    @ResponseBody
    public ResultData showmycoupon(@RequestBody ShowMyCouponParam showMyCouponParam) {
        logger.info("使用券 showmycoupon 参数"+JsonUtil.toJson(showMyCouponParam));

        CoupScanRO coupScanRO = new CoupScanRO();
        //校验参数
        if (showMyCouponParam == null || StringUtils.isEmpty(showMyCouponParam.getCouponCodeId()) || StringUtils.isEmpty(showMyCouponParam.getUid())) {
            return ResultDataBuilder.buildErrorResultData("参数不正确");
        }

        try {
            //根据券Id查询券信息
            logger.info("根据券Id查询券信息 参数"+JsonUtil.toJson(showMyCouponParam.getCouponCodeId()));
            CouponDetailData couponDetailDataShow = detailCouponGetService.getById(Long.parseLong(showMyCouponParam.getCouponCodeId()));
            logger.info("根据券Id查询券信息 结果"+JsonUtil.toJson(couponDetailDataShow));

            if (couponDetailDataShow == null) {
                return ResultDataBuilder.buildErrorResultData("未查询出券数据");
            }

            //***券ID ，券码，状态 ,状态说明
            coupScanRO.setCouponNo(couponDetailDataShow.getCode());
            coupScanRO.setCode(couponDetailDataShow.getState());
            coupScanRO.setMessage(couponDetailDataShow.getState() == null ? null : CouponDetailDataStatus.getCouponDetailDataStatusDescByCode(couponDetailDataShow.getState()));
            //该券所属用户
            String uid = couponDetailDataShow.getUid();
            //该券所属活动code
            Long mid = couponDetailDataShow.getMid();
            //查询出该用户已经领取了该活动的券集合
            CouponDetailData couponDetailDataParam = new CouponDetailData();
            couponDetailDataParam.setState(CouponDetailDataStatus.STATUS_200.getCode());
            couponDetailDataParam.setMid(mid);
            couponDetailDataParam.setUid(uid);

            logger.info("根据券Id查询券信息 参数"+JsonUtil.toJson(couponDetailDataParam));
            List<CouponDetailData> couponDetailDataList = detailCouponGetService.getCouponDetailDataListByCouponDetailData(couponDetailDataParam);
            logger.info("根据券Id查询券信息 结果"+JsonUtil.toJson(couponDetailDataList));

            if (CollectionUtils.isNotEmpty(couponDetailDataList)) {
                Set<String> codes = Sets.newHashSet();
                for (CouponDetailData detailData : couponDetailDataList) {
                    codes.add(detailData.getCode());
                }
                //*** 集合
                coupScanRO.setAvailableCoupons(codes);
                coupScanRO.setAvailableNum(couponDetailDataList.size());
            } else {
                coupScanRO.setAvailableNum(0);
                Set<String> codes = Sets.newHashSet();
                coupScanRO.setAvailableCoupons(codes);
            }

            //根据活动code查询活动信息
            logger.info("根据券Id查询券信息 参数"+JsonUtil.toJson(couponDetailDataShow.getMid()));
            CouponMainData couponMainData = mainCouponGetService.getById(couponDetailDataShow.getMid());
            logger.info("根据券Id查询券信息 结果"+JsonUtil.toJson(couponMainData));

            if (couponMainData != null) {
                //***名称 活动编码
                coupScanRO.setCouponName(couponMainData.getName());
                coupScanRO.setPromotionCode(couponMainData.getPromotionCode());
                //***开始结束时间
                coupScanRO.setBegDate(couponMainData.getBeginDate());
                coupScanRO.setEndDate(couponMainData.getEndDate());
                //***本金。。。
                coupScanRO.setCapital(couponMainData.getCapital());
                coupScanRO.setExemption(couponMainData.getExemption());
                coupScanRO.setFaceValue(couponMainData.getFaceValue());
                coupScanRO.setThreshold(couponMainData.getThreshold());
                //***类型。。。
                coupScanRO.setCouponType(couponMainData.getType());
                coupScanRO.setCouponTypeDesc(CouponTypeEnum.getCouponTypeEnumByCode(couponMainData.getType()).getDesc());
                //***说明
                coupScanRO.setGuide(couponMainData.getGuide());

            }
            logger.info("结果"+JsonUtil.toJson(coupScanRO));

            return ResultDataBuilder.buildSuccessResultData(coupScanRO, Boolean.TRUE, 200, "成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultDataBuilder.buildErrorResultData("查询异常");
        }
    }

    /**
     * 追加接口
     * 冲正
     * @param getCouponVO
     * @return
     */
    @PostMapping(value = "reversal")
    @ResponseBody
    public ResultData reversal(@RequestBody GetCouponVO getCouponVO){
        try {
            if(getCouponVO==null || StringUtils.isEmpty(getCouponVO.getCouponId()) || StringUtils.isEmpty(getCouponVO.getUid())){
                return ResultDataBuilder.buildErrorResultData("参数不正确");
            }
            Long id = Long.parseLong(getCouponVO.getCouponId());
            //当前的券状态变为已冲正
            CouponDetailData reversalData = detailCouponGetService.getById(id);

            if(reversalData!=null){
                reversalData.setState(CouponDetailDataStatus.STATUS_300.getCode());
                int i = detailCouponGetService.updateCouponDetailData(reversalData);
                if(i<=0){
                    return ResultDataBuilder.buildErrorResultData("更新冲正状态失败");
                }
            }else{
                return ResultDataBuilder.buildErrorResultData("查无数据");
            }

            //生成用户券
            String code = createDetailCode();
            CouponDetailData createCouponDetailData = new CouponDetailData();
            createCouponDetailData.setUid(getCouponVO.getUid());
            createCouponDetailData.setRefPromotionCode(getCouponVO.getCouponId());
            createCouponDetailData.setMid(reversalData.getMid());
            createCouponDetailData.setCode(code);
            createCouponDetailData.setState(CouponDetailDataStatus.STATUS_200.getCode());

            logger.info("生成用户券 参数："+JsonUtil.toJson(createCouponDetailData));
            detailCouponGetService.saveCouponDetailData(createCouponDetailData);
            logger.info("生成用户券 结果："+JsonUtil.toJson(createCouponDetailData));

            if (createCouponDetailData.getId() != null) {
                return ResultDataBuilder.buildSuccessResultData(null, Boolean.TRUE, 200, "成功");
            } else {
                return ResultDataBuilder.buildErrorResultData("生成券失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultDataBuilder.buildErrorResultData("操作异常");
        }
    }
}
