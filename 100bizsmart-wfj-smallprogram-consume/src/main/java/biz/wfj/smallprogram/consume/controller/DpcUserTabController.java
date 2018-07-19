package biz.wfj.smallprogram.consume.controller;

import biz.wfj.smallprogram.api.model.DpcUserTab;
import biz.wfj.smallprogram.api.service.DpcUserTabService;
import faner.dplatformSpringjdbc.api.frame.util.tools.json.JsonCoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dpcUserTab/")
public class DpcUserTabController {
    @Autowired(required = false)
    private DpcUserTabService dpcUserTabService;

    @ResponseBody
    @GetMapping("/test")
    public Object test(){
        DpcUserTab dpcUserTab = new DpcUserTab();
        dpcUserTab.setId(90L);

        List<DpcUserTab> dpcUserTabs = dpcUserTabService.findByObj(JsonCoreUtil.toHashMapRemoveNull(dpcUserTab));
        return dpcUserTabs;
    }
}
