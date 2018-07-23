package biz.coupon.core.service.impl;

import biz.coupon.api.dao.DpcUserTabDao;
import biz.coupon.api.model.DpcUserTab;
import biz.coupon.api.service.DpcUserTabService;
import faner.dplatformSpringjdbc.api.frame.command.db.springJDBC.xml.OverallSituationStatic;
import faner.dplatformSpringjdbc.api.frame.util.tools.velocity.VelocityCoreUtils;
import faner.dplatformSpringjdbc.core.frame.service.impl.GenericNamedServiceImpl;

import java.util.List;
import java.util.Map;

public class DpcUserTabServiceImpl extends GenericNamedServiceImpl<DpcUserTab, Long> implements DpcUserTabService {
    private DpcUserTabDao dao;
    public DpcUserTabServiceImpl(DpcUserTabDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<DpcUserTab> findByObj(Map<String, Object> paramsMap) {
        Map<String, String> sqlMap = OverallSituationStatic.getTableAllSql(DpcUserTab.class.getSimpleName());
        List<DpcUserTab> findByObj = this.dao.findForList(VelocityCoreUtils.render(sqlMap.get("findByObj"), paramsMap), paramsMap);
        return findByObj;
    }
}
