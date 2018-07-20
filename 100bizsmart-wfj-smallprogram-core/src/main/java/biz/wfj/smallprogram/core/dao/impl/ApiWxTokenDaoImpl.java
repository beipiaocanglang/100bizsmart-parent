package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.ApiWxTokenDao;
import biz.wfj.smallprogram.api.model.WxTokenEntity;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class ApiWxTokenDaoImpl extends GenericNamedDaoImpl<WxTokenEntity, Long> implements ApiWxTokenDao {
    public ApiWxTokenDaoImpl() {
        super(WxTokenEntity.class);
    }

}
