package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.ApiUserLevelDao;
import biz.wfj.smallprogram.api.model.UserLevelVo;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class ApiUserLevelDaoImpl extends GenericNamedDaoImpl<UserLevelVo, Long> implements ApiUserLevelDao {
    public ApiUserLevelDaoImpl(){
        super(UserLevelVo.class);
    }
}
