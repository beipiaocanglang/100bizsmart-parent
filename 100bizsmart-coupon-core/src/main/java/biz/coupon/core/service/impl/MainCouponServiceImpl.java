package biz.coupon.core.service.impl;

import biz.coupon.api.dao.CouponMainDao;
import biz.coupon.api.model.CouponMainData;
import biz.coupon.api.service.MainCouponService;
import faner.dplatformSpringjdbc.core.frame.service.impl.GenericNamedServiceImpl;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 主活动服务
 */
public class MainCouponServiceImpl extends GenericNamedServiceImpl<CouponMainData, Long> implements MainCouponService {

    private CouponMainDao couponMainDao;
    public MainCouponServiceImpl(CouponMainDao dao) {
        super(dao);
        this.couponMainDao = dao;
    }

    public int saveCouponMainData(@NotNull CouponMainData couponMainData) {
        couponMainData.setCreatedTime(new Date());
        couponMainData.setModifiedTime(new Date());
        return couponMainDao.saveCouponMainData(couponMainData);
    }

    public int updateCouponMainData(@NotNull CouponMainData couponMainData) {
        couponMainData.setModifiedTime(new Date());
        return couponMainDao.updateCouponMainData(couponMainData);
    }

    public CouponMainData getById(@NotNull Long id) {
        CouponMainData couponMainData = couponMainDao.getCouponMainDataById(id);
        return couponMainData;
    }

    public CouponMainData getByCode(@NotNull String code) {
        CouponMainData couponMainData = couponMainDao.getCouponMainDataByCode(code);
        return couponMainData;
    }

    public List<CouponMainData> getCouponMainDataListByCouponMainData(@NotNull CouponMainData couponMainData) {
        return couponMainDao.getCouponMainDataListByCouponMainData(couponMainData);
    }

    public List<CouponMainData> getCouponMainDataListAll() {
        return couponMainDao.getCouponMainDataListAll();
    }

    public int countByCouponMainData(@NotNull CouponMainData couponMainData) {
        return couponMainDao.countCouponMainData(couponMainData);
    }
}
