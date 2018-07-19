package biz.wfj.smallprogram.core.service.impl;

import biz.wfj.smallprogram.api.dao.DpcUserTabDao;
import biz.wfj.smallprogram.api.model.DpcUserTab;
import biz.wfj.smallprogram.api.service.DpcUserTabService;
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
