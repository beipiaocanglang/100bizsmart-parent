package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.ApiUserDao;
import biz.wfj.smallprogram.api.model.UserVo;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

public class ApiUserDaoImpl extends GenericNamedDaoImpl<UserVo, Long> implements ApiUserDao {
    public ApiUserDaoImpl(){
        super(UserVo.class);
    }
}
