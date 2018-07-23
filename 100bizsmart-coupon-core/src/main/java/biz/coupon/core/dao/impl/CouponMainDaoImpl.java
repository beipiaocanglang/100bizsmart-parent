package biz.coupon.core.dao.impl;

import biz.coupon.api.dao.CouponMainDao;
import biz.coupon.api.model.CouponMainData;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

import java.util.List;
import java.util.Map;

public class CouponMainDaoImpl extends GenericNamedDaoImpl<CouponMainData, Long> implements CouponMainDao {

    public CouponMainDaoImpl(){
        super(CouponMainData.class);
    }

    @Override
    public int saveCouponMainData(CouponMainData couponMainData) {
        return 0;
    }

    @Override
    public int updateCouponMainData(CouponMainData couponMainData) {
        return 0;
    }

    @Override
    public CouponMainData getCouponMainDataById(Long id) {
        return null;
    }

    @Override
    public CouponMainData getCouponMainDataByCode(String code) {
        return null;
    }

    @Override
    public List<CouponMainData> getCouponMainDataListByCouponMainData(CouponMainData couponMainData) {
        return null;
    }

    @Override
    public List<CouponMainData> getCouponMainDataListByParam(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<CouponMainData> getCouponMainDataListAll() {
        return null;
    }

    @Override
    public int countCouponMainData(CouponMainData couponMainData) {
        return 0;
    }

    @Override
    public int deleteCouponMainDataById(int id) {
        return 0;
    }
}
