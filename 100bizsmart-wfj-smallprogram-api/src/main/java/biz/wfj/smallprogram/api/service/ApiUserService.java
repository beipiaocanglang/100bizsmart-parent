package biz.wfj.smallprogram.api.service;

import biz.wfj.smallprogram.api.model.UserVo;
import faner.dplatformSpringjdbc.api.frame.service.GenericNamedService;

import java.util.Map;

public interface ApiUserService extends GenericNamedService<UserVo, Long> {
    UserVo queryByOpenId(Map<String, Object> paramsMap);

    Map get_user_info(String mobile);

}
