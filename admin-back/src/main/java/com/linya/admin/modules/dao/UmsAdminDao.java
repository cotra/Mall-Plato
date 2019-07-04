package com.linya.admin.modules.dao;

import com.linya.admin.po.UmsRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UmsAdminDao {
    @Select("select * from ums_role")
    List<UmsRole> getList();
}
