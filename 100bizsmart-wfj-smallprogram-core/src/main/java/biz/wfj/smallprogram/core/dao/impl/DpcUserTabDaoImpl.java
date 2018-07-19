package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.DpcUserTabDao;
import biz.wfj.smallprogram.api.model.DpcUserTab;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class DpcUserTabDaoImpl extends GenericNamedDaoImpl<DpcUserTab, Long> implements DpcUserTabDao {

    public DpcUserTabDaoImpl() {
        super(DpcUserTab.class);
    }
}
