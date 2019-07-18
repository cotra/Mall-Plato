package com.linya.admin.ums.auth.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface AuthDao {

    @Update("UPDATE ums_admin SET login_time=#{time} WHERE id=#{id}")
    int updateLoginTime(@Param("id") Long id, @Param("time") Date time);
}
