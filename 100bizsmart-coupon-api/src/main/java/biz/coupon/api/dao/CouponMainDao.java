package biz.coupon.api.dao;

import biz.coupon.api.model.CouponMainData;
import faner.dplatformSpringjdbc.api.frame.dao.GenericNamedDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("couponMainDataMapper")
public interface CouponMainDao extends GenericNamedDao<CouponMainData, Long> {

    /**
     * 保存活动
     * @param couponMainData
     * @return
     */
    int saveCouponMainData(CouponMainData couponMainData);

    /**
     * 更新活动
     * @param couponMainData
     * @return
     */
    int updateCouponMainData(CouponMainData couponMainData);

    /**
     * 按ID查询活动详情
     * @param id
     * @return
     */
    CouponMainData getCouponMainDataById(Long id);

    /**
     * 根据活动 code查询活动信息
     * @param code
     * @return
     */
    CouponMainData getCouponMainDataByCode(String code);

    /**
     * 按CouponMainData为条件查询活动列表
     * @param couponMainData
     * @return
     */
    List<CouponMainData> getCouponMainDataListByCouponMainData(CouponMainData couponMainData);

    /**
     * 按Map为查询条件
     * @param param
     * @return
     */
    List<CouponMainData> getCouponMainDataListByParam(Map<String, Object> param);

    /**
     * 查询所有活动
     * @return
     */
    List<CouponMainData> getCouponMainDataListAll();
    /**
     * 聚合查询CouponMainData
     * @param couponMainData
     * @return
     */
    int countCouponMainData(CouponMainData couponMainData);

    /**
     * 删除CouponDetailData
     * @param id
     * @return
     */
    int deleteCouponMainDataById(int id);

}