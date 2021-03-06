package biz.coupon.consume.controller;

import biz.consume.frame.controller.BaseController;
import biz.coupon.api.constants.DpcnmmResponseConstant;
import biz.coupon.api.constants.DpcnmmResponseHashMap;
import biz.coupon.api.model.DfieldCheck;
import biz.coupon.api.service.DfieldCheckService;
import biz.coupon.api.vo.BaseParameterModel;
import biz.coupon.api.vo.LogParameterModel;
import faner.dplatformSpringjdbc.api.frame.util.tools.json.JsonCoreUtil;
import faner.dplatformSpringjdbc.api.frame.util.tools.object.ListCoreUtil;
import faner.dplatformSpringjdbc.api.frame.util.tools.object.MyBeanCoreUtils;
import faner.dplatformSpringjdbc.api.frame.util.tools.object.ObjectCoreUtil;
import faner.dplatformSpringjdbc.api.frame.util.tools.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @version V2.0
 * @Company:faner
 * @author: lijianjun
 */
@Controller
@Scope("prototype")
@RequestMapping("/dfieldCheck")
public class DfieldCheckController extends BaseController {

    @Autowired(required = false)
    private DfieldCheckService dfieldCheckService;

    /**
     * 测试框架
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }
    @ResponseBody
    @GetMapping("/test")
    public Object test() {
        Map<String, Object> map = new LinkedHashMap();
        map.put("name", "zhangsan");
        map.put("age", 17);

        Map<String, Object> map1 = new LinkedHashMap();
        map1.put("name", "lisi");
        map1.put("age", 18);

        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add(map1);

        return list;
    }

    /**
     * 新增
     *
     * @param dfieldCheck 新增对象
     * @method: saveDfieldCheck
     * @Description: 新增
     * @author : lijianjun
     */
    @RequestMapping(value = "/saveDfieldCheck", method = RequestMethod.POST)
    public void saveDfieldCheck(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck) {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        dfieldCheck.setId(null);
        dfieldCheck.setDelFlg("0");
        dfieldCheck.setInsUser(baseModel.getCurLoginName());
        dfieldCheck.setInsTime(new Date());
        dfieldCheck.setUpdUser(baseModel.getCurLoginName());
        dfieldCheck.setUpdTime(new Date());
        int id = dfieldCheckService.save(dfieldCheck);
        if (id > 0) {
            dfieldCheck.setId(Long.valueOf(id));
            map.setData(dfieldCheck);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 删除
     *
     * @param ids 删除key
     * @method: delDfieldCheckByIds
     * @Description: 删除
     * @author : lijianjun
     */
    @RequestMapping(value = "/delDfieldCheckByIds", method = RequestMethod.POST)
    public void delDfieldCheckByIds(BaseParameterModel baseModel, LogParameterModel logModel, String ids) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        String[] idsArr = ids.split(",");
        boolean boo = dfieldCheckService.batchDelete(idsArr);
        if (!boo) {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 更新
     *
     * @param dfieldCheck 更新对象
     * @method: updDfieldCheck
     * @Description: 更新
     * @author : lijianjun
     */
    @RequestMapping(value = "/updDfieldCheck", method = RequestMethod.POST)
    public void updDfieldCheck(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        DfieldCheck dfieldCheckObj = dfieldCheckService.get(Long.valueOf(dfieldCheck.getId()));
        MyBeanCoreUtils.copyNotNullProperties(dfieldCheckObj, dfieldCheck);
        dfieldCheckObj.setUpdUser(baseModel.getCurLoginName());
        dfieldCheckObj.setUpdTime(new Date());
        int num = dfieldCheckService.update(dfieldCheckObj);
        if (num > 0) {
            map.setData(dfieldCheck);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 根据ID查询
     *
     * @param  id
     * @method: getDfieldCheckById
     * @Description: 根据ID查询
     * @author : lijianjun
     */
    @RequestMapping(value = "/getDfieldCheckById", method = RequestMethod.POST)
    public void getDfieldCheckById(BaseParameterModel baseModel, LogParameterModel logModel, Long id) {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        DfieldCheck dfieldCheck = dfieldCheckService.get(Long.valueOf(id));
        if (ObjectCoreUtil.isNotNull(dfieldCheck)) {
            map.setData(dfieldCheck);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 查询全部
     *
     * @method: findAllDfieldCheck
     * @Description: 查询全部
     * @author : lijianjun
     */
    @RequestMapping(value = "/findAllDfieldCheck", method = RequestMethod.POST)
    public void findAllDfieldCheck(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        List<DfieldCheck> dfieldCheckList = dfieldCheckService.findByObj(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck));
        if (ListCoreUtil.isNotEmpty(dfieldCheckList)) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("dataList", dfieldCheckList);
            map.setData(dataMap);
            Map<String, Object> countMap = dfieldCheckService.count(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck));
            map.setCount(countMap != null && countMap.get("count") != null ? Integer.valueOf(countMap.get("count").toString()) : 0);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 查询全部
     *
     * @method: findAllListMapDfieldCheck
     * @Description: 查询全部
     * @author : lijianjun
     */
    @RequestMapping(value = "/findAllListMapDfieldCheck", method = RequestMethod.POST)
    public void findAllListMapDfieldCheck(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        List<Map<String, Object>> dfieldCheckList = dfieldCheckService.findListMapByObj(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck));
        if (ListCoreUtil.isNotEmpty(dfieldCheckList)) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("dataList", dfieldCheckList);
            map.setData(dataMap);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 查询全部
     *
     * @method: findAllDfieldCheckByPage
     * @Description: 查询全部
     * @author : lijianjun
     */
    @RequestMapping(value = "/findAllDfieldCheckByPage", method = RequestMethod.POST)
    public void findAllDfieldCheckByPage(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck, PageBean page) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        List<DfieldCheck> dfieldCheckList = dfieldCheckService.findByPageObj(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck), page);
        if (ListCoreUtil.isNotEmpty(dfieldCheckList)) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("dataList", dfieldCheckList);
            map.setData(dataMap);
            Map<String, Object> countMap = dfieldCheckService.count(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck));
            map.setCount(countMap != null && countMap.get("count") != null ? Integer.valueOf(countMap.get("count").toString()) : 0);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }

    /**
     * 查询全部
     *
     * @method: findAllListMapDfieldCheckByPage
     * @Description: 查询全部
     * @author : lijianjun
     */
    @RequestMapping(value = "/findAllListMapDfieldCheckByPage", method = RequestMethod.POST)
    public void findAllListMapDfieldCheckByPage(BaseParameterModel baseModel, LogParameterModel logModel, DfieldCheck dfieldCheck, PageBean page) throws Exception {
        DpcnmmResponseHashMap map = new DpcnmmResponseHashMap();
        List<Map<String, Object>> dfieldCheckList = dfieldCheckService.findListMapByPageObj(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck), page);
        if (ListCoreUtil.isNotEmpty(dfieldCheckList)) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("dataList", dfieldCheckList);
            map.setData(dataMap);
            Map<String, Object> countMap = dfieldCheckService.count(JsonCoreUtil.toHashMapRemoveNull(dfieldCheck));
            map.setCount(countMap != null && countMap.get("count") != null ? Integer.valueOf(countMap.get("count").toString()) : 0);
        } else {
            map.setCode(DpcnmmResponseConstant.CODE_NULL);
            map.setMsg(DpcnmmResponseConstant.MSG_NULL);
        }
        JsonCoreUtil.outPutJson(this.getResponse(), JsonCoreUtil.toJSONString(map));
    }
}
