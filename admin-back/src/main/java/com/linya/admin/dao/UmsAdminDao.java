package com.linya.admin.dao;

import com.linya.admin.dto.UmsAdminAuth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UmsAdminDao {
    @Select("select id,username,password,status from ums_admin where username=#{username}")
    List<UmsAdminAuth> getList(@Param("username") String name);
}
