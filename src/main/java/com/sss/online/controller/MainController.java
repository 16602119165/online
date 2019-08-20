package com.sss.online.controller;

import com.sss.online.basic.Result;
import com.sss.online.pojo.UITree;
import com.sss.online.service.MainMenuService;
import com.sss.online.serviceimpl.MainMenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @create 2019-06-25-10:48
 */
@RestController
public class MainController {
    @Autowired
    MainMenuServiceImp mainMenuServiceImp;

    @RequestMapping("/menuTree")
    public Result getMainMenu(){
        Result result = new Result();
        List<UITree> uiTree = mainMenuServiceImp.getUITree();
        result.setData(uiTree);
        result.setStatus(0);
        return result;
    }
}
