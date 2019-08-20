package com.sss.online.dao;

import com.sss.online.pojo.ShiroPermissions;
import com.sss.online.pojo.ShiroRole;
import com.sss.online.pojo.ShiroRolePermissions;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author
 * @create 2019-06-25-10:52
 */
@Repository
public interface MainMenuMapper {

    @Select("select * from shiro_permissions")
    List<ShiroPermissions> selectAll();













    //根据用户名返回用户拥有的角色集合。
    @Select("select role_id from shiro_role where name=#{name}")
    List<Integer> selectByName(String name);
    //根据role_id，查询出拥有的资源主键集合。此处查出资源主键是为了方便去重。
    List<Integer> selectByRoleId(List<Integer> roleIdS);
    //根据资源主键id，查询所有的一级菜单
    List<ShiroPermissions> selectRootByPermissionsId(Set<Integer> menuId);
    List<ShiroPermissions> selectByPermissionsId(Set<Integer> menuId);
}
