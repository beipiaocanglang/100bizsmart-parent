package biz.wfj.smallprogram.api.service;

import biz.wfj.smallprogram.api.model.TokenEntity;
import faner.dplatformSpringjdbc.api.frame.service.GenericNamedService;

import java.util.Map;

public interface TokenService extends GenericNamedService<TokenEntity, Long> {
    Map createLoginToken(String openId, String unionid, String session_key);
    //DOTO 自己定义接口
}
