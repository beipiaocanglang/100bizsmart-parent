package biz.coupon.api.service;

import biz.coupon.api.model.CouponMainData;
import faner.dplatformSpringjdbc.api.frame.service.GenericNamedService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dev on 2018/4/9.
 */
public interface MainCouponService extends GenericNamedService<CouponMainData, Long>{

    /**
     * 保存活动
     * @param couponMainData
     * @return
     */
    int saveCouponMainData(@NotNull CouponMainData couponMainData);

    /**
     * 更新活动
     * @param couponMainData
     * @return
     */
    int updateCouponMainData(@NotNull CouponMainData couponMainData);

    /**
     * 根据ID查询活动
     * @param id
     * @return
     */
    CouponMainData getById(@NotNull Long id);

    /**
     * 根据活动code查询活动信息
     * @param code
     * @return
     */
    CouponMainData getByCode(@NotNull String code);

    /**
     * 查询CouponMainData列表
     * @param couponMainData
     * @return
     */
    List<CouponMainData> getCouponMainDataListByCouponMainData(@NotNull CouponMainData couponMainData);

    /**
     * 查询所有活动
     * @return
     */
    List<CouponMainData> getCouponMainDataListAll();
    /**
     * 聚合查询
     * @param couponMainData
     * @return
     */
    int countByCouponMainData(@NotNull CouponMainData couponMainData);

}
