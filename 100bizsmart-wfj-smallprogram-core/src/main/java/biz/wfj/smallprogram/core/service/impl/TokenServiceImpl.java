package biz.wfj.smallprogram.core.service.impl;

import biz.wfj.smallprogram.api.dao.ApiTokenDao;
import biz.wfj.smallprogram.api.dao.ApiWxTokenDao;
import biz.wfj.smallprogram.api.model.DfieldCheck;
import biz.wfj.smallprogram.api.model.TokenEntity;
import biz.wfj.smallprogram.api.model.WxTokenEntity;
import biz.wfj.smallprogram.api.service.TokenService;
import biz.wfj.smallprogram.api.util.CharUtil;
import faner.dplatformSpringjdbc.api.frame.command.db.springJDBC.xml.OverallSituationStatic;
import faner.dplatformSpringjdbc.api.frame.util.tools.velocity.VelocityCoreUtils;
import faner.dplatformSpringjdbc.core.frame.service.impl.GenericNamedServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TokenServiceImpl extends GenericNamedServiceImpl<TokenEntity, Long> implements TokenService {
    private ApiTokenDao apiTokenDao;
    private ApiWxTokenDao loginTokenDao;
    public TokenServiceImpl(ApiTokenDao dao, ApiWxTokenDao dao1) {
        super(dao);
        this.apiTokenDao = dao;
        this.loginTokenDao = dao1;
    }

    private final static int EXPIRE = 3600;

    public Map<String, Object> createLoginToken(String openId , String unionId , String sessionKey) {
        //生成一个token
        String token = CharUtil.getRandomString(32);
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        WxTokenEntity tokenEntity = queryByOpenId(openId);
        if (tokenEntity == null) {
            tokenEntity = new WxTokenEntity();
            tokenEntity.setOpenId(openId);
            tokenEntity.setUnionId(unionId);
            tokenEntity.setSessionKey(sessionKey);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            saveLogin(tokenEntity);
        } else {
            tokenEntity.setSessionKey(sessionKey);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            updateLogin(tokenEntity);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

    public WxTokenEntity queryByOpenId(String openId) {
        Map<String, Object> paramsMap = new LinkedHashMap<>();
        paramsMap.put("openId",openId);
        Map<String, String> sqlMap = OverallSituationStatic.getTableAllSql(WxTokenEntity.class.getSimpleName());
        WxTokenEntity findByObj = (WxTokenEntity)loginTokenDao.findOneByMap(VelocityCoreUtils.render(sqlMap.get("findByObj"), paramsMap), paramsMap);
        return findByObj;
        //return loginTokenDao.queryByOpenId(openId);
    }
    public void saveLogin(WxTokenEntity token) {
        loginTokenDao.save(token);
    }
    public void updateLogin(WxTokenEntity token) {
        loginTokenDao.update(token);
    }
}
