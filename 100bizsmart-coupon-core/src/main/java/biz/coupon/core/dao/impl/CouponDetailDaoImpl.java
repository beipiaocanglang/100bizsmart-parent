package biz.coupon.core.dao.impl;

import biz.coupon.api.dao.CouponDetailDao;
import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.bo.MidCountBO;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

import java.util.List;
import java.util.Map;

public class CouponDetailDaoImpl extends GenericNamedDaoImpl<CouponDetailData, Long> implements CouponDetailDao {
    public CouponDetailDaoImpl() {
        super(CouponDetailData.class);
    }

    @Override
    public int saveCouponDetail(CouponDetailData couponDetailData) {
        return 0;
    }

    @Override
    public int updateCouponDetail(CouponDetailData couponDetailData) {
        return 0;
    }

    @Override
    public CouponDetailData getCouponDetailDataById(Long id) {
        return null;
    }

    @Override
    public CouponDetailData getCouponDetailDataByCode(String code) {
        return null;
    }

    @Override
    public CouponDetailData getCouponDetailDataByUidCode(String uid, String code) {
        return null;
    }

    @Override
    public List<CouponDetailData> getCouponDetailDataListByCouponDetailData(CouponDetailData couponDetailData) {
        return null;
    }

    @Override
    public List<CouponDetailData> getCouponDetailDataListByParam(Map<String, Object> param) {
        return null;
    }

    @Override
    public int countCouponDetailData(CouponDetailData couponDetailData) {
        return 0;
    }

    @Override
    public List<MidCountBO> getCountDetailDataByUidGroupByMid(String uid) {
        return null;
    }

    @Override
    public List<MidCountBO> getCountDetailDataGroupByMid() {
        return null;
    }

    @Override
    public int deleteCouponDetailDataById(int id) {
        return 0;
    }

    @Override
    public int updateByMid(Long mid, Integer status) {
        return 0;
    }
}
