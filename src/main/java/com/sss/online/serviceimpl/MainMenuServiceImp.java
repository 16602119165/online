package com.sss.online.serviceimpl;

import com.sss.online.dao.EmployeeMapper;
import com.sss.online.dao.MainMenuMapper;
import com.sss.online.pojo.ShiroPermissions;
import com.sss.online.pojo.ShiroRolePermissions;
import com.sss.online.pojo.UITree;
import com.sss.online.service.MainMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author
 * @create 2019-06-25-13:36
 */
@Service
public class MainMenuServiceImp implements MainMenuService {

    @Autowired
    MainMenuMapper mainMenuMapper;

    public List<UITree> getUITree(){
        List<ShiroPermissions> shiroPermissionSList =  mainMenuMapper.selectAll();

        //设置父id为0的rootTree
        //递归的调用，查询父id为0的UITree，
        UITree rootTree = new UITree();
        rootTree.setId(0);
        recursive(rootTree,shiroPermissionSList);
        List<UITree> UITreeList = rootTree.getChildren();
        return UITreeList;
    }
    public UITree recursive(UITree subTree,List<ShiroPermissions> allList){
        //用来存每次递归的父集合
        List<ShiroPermissions> tempList = new ArrayList<>();
        //子菜单集合
        List<UITree> subTreeList = new ArrayList<>();
        //遍历去除pid为0的跟目录
        for(ShiroPermissions shiroPermissions : allList){
            //第一次遍历，先取出父id为0的根菜单
            if(shiroPermissions.getpId() == subTree.getId()){
                //templist
                tempList.add(shiroPermissions);
            }
        }
        //将遍历的父结果集移出所有的集合
        allList.removeAll(tempList);
        //遍历父结果集
        for(ShiroPermissions shiroPermissions : tempList){
            UITree uiTree = new UITree();
            uiTree.setId(shiroPermissions.getId());
            uiTree.setText(shiroPermissions.getMenuName());
            uiTree.setMenuUrl(shiroPermissions.getMenuUrl());
            //递归调用
            recursive(uiTree,allList);
            subTreeList.add(uiTree);
        }
        subTree.setChildren(subTreeList);
        return subTree;
    }












    /*public List<UITree> getUITree(String name){
        //根据用户名查询到用户角色id的集合。
        List<Integer> roleIdS = mainMenuMapper.selectByName(name);
        //根据角色id集合查询拥有的资源主键集合。
        List<Integer> permissionsId = mainMenuMapper.selectByRoleId(roleIdS);
        //将查询出来的资源主键集合转为了set，去除重复的资源主键。万一有重复的。
        Set<Integer> menuId = new HashSet<>(permissionsId);
        //根据拥有的资源主键集合，查询出所有p_id为0的一级菜单。
        List<ShiroPermissions> rootPermissions = mainMenuMapper.selectRootByPermissionsId(menuId);
        UITree root = new UITree();
        return null;
    }*/
}
