package biz.wfj.smallprogram.core.dao.impl;

import biz.wfj.smallprogram.api.dao.DfieldCheckDao;
import biz.wfj.smallprogram.api.model.DfieldCheck;
import faner.dplatformSpringjdbc.core.frame.dao.impl.GenericNamedDaoImpl;

/**
*
* @author: lijianjun
* @version V2.0
*/
@SuppressWarnings("serial")
public class DfieldCheckDaoImpl extends GenericNamedDaoImpl<DfieldCheck, Long> implements DfieldCheckDao {

	public DfieldCheckDaoImpl() {
		super(DfieldCheck.class);
	}

}

