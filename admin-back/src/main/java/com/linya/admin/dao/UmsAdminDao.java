package com.linya.admin.dao;

import com.linya.admin.po.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UmsAdminDao {
    @Select("SELECT id,username,password,status FROM ums_admin WHERE username=#{username}")
    List<UmsAdmin> getListByName(@Param("username") String name);

    @Select("SELECT id,username,login_time,status FROM ums_admin WHERE id=#{id}")
    List<UmsAdmin> getListById(@Param("id") Long id);
}
