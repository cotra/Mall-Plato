package com.linya.admin.ums.auth.dao;

import com.linya.admin.po.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface AuthDao {

    @Update("UPDATE ums_admin SET login_time=#{time} WHERE id=#{id}")
    int updateLoginTime(@Param("id") Long id, @Param("time") Date time);

    @Select("SELECT id,password,status FROM ums_admin WHERE username=#{username}")
    List<UmsAdmin> getListByName(@Param("username") String name);
}
