package biz.coupon.api.dao;

import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.bo.MidCountBO;
import faner.dplatformSpringjdbc.api.frame.dao.GenericNamedDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 优惠卷详细Dao
 */
public interface CouponDetailDao extends GenericNamedDao<CouponDetailData, Long> {

    /**
     * 保存优惠卷
     * @param couponDetailData
     * @return
     */
    int saveCouponDetail(CouponDetailData couponDetailData);

    /**
     * 更新优惠卷信息
     * @param couponDetailData
     * @return
     */
    int updateCouponDetail(CouponDetailData couponDetailData);

    /**
     * 按ID查询优惠卷详情
     * @param id
     * @return
     */
    CouponDetailData getCouponDetailDataById(Long id);

    /**
     * 根据优惠卷code查询
     * @param code
     * @return
     */
    CouponDetailData getCouponDetailDataByCode(String code);

    /**
     * 根据uid和code查询出唯一券
     * @param uid
     * @param code
     * @return
     */
    CouponDetailData getCouponDetailDataByUidCode(String uid, String code);

    /**
     * 按CouponDetailData为条件查询列表
     * @param couponDetailData
     * @return
     */
    List<CouponDetailData> getCouponDetailDataListByCouponDetailData(CouponDetailData couponDetailData);

    /**
     * 按Map为查询条件
     * @param param
     * @return
     */
    List<CouponDetailData> getCouponDetailDataListByParam(Map<String, Object> param);


    /**
     * 聚合查询CouponDetailData
     * @param couponDetailData
     * @return
     */
    int countCouponDetailData(CouponDetailData couponDetailData);

    /**
     * 聚合查询uid按mid分组
     * @param uid
     * @return
     */
    List<MidCountBO> getCountDetailDataByUidGroupByMid(String uid);

    /**
     * 聚合查询按mid分组
     * @return
     */
    List<MidCountBO> getCountDetailDataGroupByMid();
    /**
     * 删除CouponDetailData
     * @param id
     * @return
     */
    int deleteCouponDetailDataById(int id);

    /**
     * 根据mid修改
     * @param mid
     * @return
     */
    int updateByMid(Long mid, Integer status);
}