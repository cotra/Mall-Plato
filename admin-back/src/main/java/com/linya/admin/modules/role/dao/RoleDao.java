package com.linya.admin.modules.role.dao;

import com.linya.admin.po.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> getList();

    @Select("select * from ums_role where name = #{name}")
    Role find(String name);
}
