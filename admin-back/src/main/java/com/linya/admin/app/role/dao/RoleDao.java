package com.linya.admin.app.role.dao;

import com.linya.admin.po.UmsRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    @Select("select * from ums_role")
    List<UmsRole> getList();

    @Select("select * from ums_role where name = #{name}")
    UmsRole find(String name);
}
