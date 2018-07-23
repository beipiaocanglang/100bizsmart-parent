package biz.coupon.api.service;

import biz.coupon.api.model.DpcUserTab;
import faner.dplatformSpringjdbc.api.frame.service.GenericNamedService;

import java.util.List;
import java.util.Map;

public interface DpcUserTabService extends GenericNamedService<DpcUserTab, Long> {
    List<DpcUserTab> findByObj(Map<String, Object> paramsMap);
}
