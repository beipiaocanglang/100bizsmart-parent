package biz.coupon.core.dao.impl;

import biz.coupon.api.dao.DpcUserTabDao;
import biz.coupon.api.model.DpcUserTab;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class DpcUserTabDaoImpl extends GenericNamedDaoImpl<DpcUserTab, Long> implements DpcUserTabDao {

    public DpcUserTabDaoImpl() {
        super(DpcUserTab.class);
    }
}
