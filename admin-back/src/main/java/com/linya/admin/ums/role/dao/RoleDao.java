package com.linya.admin.ums.role.dao;

import com.linya.admin.po.UmsRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from ums_role")
    List<UmsRole> getList();

    @Select("select * from ums_role where name = #{name}")
    UmsRole find(String name);
}
