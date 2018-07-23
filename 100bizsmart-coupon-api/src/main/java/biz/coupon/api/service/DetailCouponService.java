package biz.coupon.api.service;

import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.DpcUserTab;
import biz.coupon.api.model.bo.MidCountBO;
import faner.dplatformSpringjdbc.api.frame.service.GenericNamedService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dev on 2018/4/9.
 */
public interface DetailCouponService extends GenericNamedService<CouponDetailData, Long> {

    /**
     * 保存卷
     * @param couponDetailData
     * @return
     */
    int saveCouponDetailData(@NotNull CouponDetailData couponDetailData);

    /**
     * 更新卷
     * @param couponDetailData
     * @return
     */
    int updateCouponDetailData(@NotNull CouponDetailData couponDetailData);

    /**
     * 根据ID查询卷
     * @param id
     * @return
     */
    CouponDetailData getById(@NotNull Long id);

    /**
     * 根据卷code查询卷信息
     * @param code
     * @return
     */
    CouponDetailData getByCode(@NotNull String code);

    /**
     * 根据uid和code查询出唯一券
     * @param uid
     * @param code
     * @return
     */
    CouponDetailData getCouponDetailDataByUidCode(String uid, String code);
    /**
     * 查询CouponDetailData列表
     * @param couponDetailData
     * @return
     */
    List<CouponDetailData> getCouponDetailDataListByCouponDetailData(@NotNull CouponDetailData couponDetailData);

    /**
     * 聚合查询
     * @param couponDetailData
     * @return
     */
    int countByCouponDetailData(@NotNull CouponDetailData couponDetailData);

    /**
     * 聚合查询Uid按mid分组
     * @param uid
     * @return
     */
    List<MidCountBO> getCountDetailDataByUidGroupByMid(@NotNull String uid);

    /**
     * 聚合查询按mid分组
     * @return
     */
    List<MidCountBO> getCountDetailDataGroupByMid();

    /**
     * 根据mid批量修改
     */

    int updateByMid(Long mid, Integer status);
}
