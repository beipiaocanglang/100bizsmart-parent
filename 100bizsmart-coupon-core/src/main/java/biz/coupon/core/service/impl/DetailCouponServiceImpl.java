package biz.coupon.core.service.impl;

import biz.coupon.api.dao.CouponDetailDao;
import biz.coupon.api.dao.DfieldCheckDao;
import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.bo.MidCountBO;
import biz.coupon.api.service.DetailCouponService;
import faner.dplatformSpringjdbc.core.frame.service.impl.GenericNamedServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dev on 2018/4/10.
 */
public class DetailCouponServiceImpl extends GenericNamedServiceImpl<CouponDetailData, Long> implements DetailCouponService {

    private CouponDetailDao couponDetailDao;
    public DetailCouponServiceImpl(CouponDetailDao dao) {
        super(dao);
        this.couponDetailDao = dao;
    }

    public int saveCouponDetailData(@NotNull CouponDetailData couponDetailData) {
        couponDetailData.setCreatedTime(new Date());
        couponDetailData.setModifiedTime(new Date());
        return couponDetailDao.saveCouponDetail(couponDetailData);
    }

    @Transactional(noRollbackFor=Exception.class,isolation= Isolation.SERIALIZABLE)
    public int updateCouponDetailData(@NotNull CouponDetailData couponDetailData) {
        couponDetailData.setModifiedTime(new Date());
        return couponDetailDao.updateCouponDetail(couponDetailData);
    }

    public CouponDetailData getById(@NotNull Long id) {
        return couponDetailDao.getCouponDetailDataById(id);
    }

    public CouponDetailData getByCode(@NotNull String code) {
        return couponDetailDao.getCouponDetailDataByCode(code);
    }

    public CouponDetailData getCouponDetailDataByUidCode(String uid, String code) {
        return couponDetailDao.getCouponDetailDataByUidCode(uid,code);
    }

    public List<CouponDetailData> getCouponDetailDataListByCouponDetailData(@NotNull CouponDetailData couponDetailData) {
        return couponDetailDao.getCouponDetailDataListByCouponDetailData(couponDetailData);
    }

    public int countByCouponDetailData(@NotNull CouponDetailData couponDetailData) {
        return couponDetailDao.countCouponDetailData(couponDetailData);
    }

    public List<MidCountBO> getCountDetailDataByUidGroupByMid(@NotNull String uid) {
        return couponDetailDao.getCountDetailDataByUidGroupByMid(uid);
    }

    public List<MidCountBO> getCountDetailDataGroupByMid() {
        return couponDetailDao.getCountDetailDataGroupByMid();
    }

    public int updateByMid(Long mid, Integer status) {
        return couponDetailDao.updateByMid(mid,status);
    }
}
