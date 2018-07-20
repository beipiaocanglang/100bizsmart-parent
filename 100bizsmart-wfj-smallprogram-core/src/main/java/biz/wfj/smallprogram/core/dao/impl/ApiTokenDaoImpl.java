package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.ApiTokenDao;
import biz.wfj.smallprogram.api.model.TokenEntity;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class ApiTokenDaoImpl extends GenericNamedDaoImpl<TokenEntity, Long> implements ApiTokenDao {
    public ApiTokenDaoImpl(){
        super(TokenEntity.class);
    }
}
