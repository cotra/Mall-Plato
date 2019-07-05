package com.linya.admin.ums.admin.dao;

import com.linya.admin.po.UmsAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    @Insert("insert into ums_admin(username,password,nick_name,note,create_time) values(#{admin.username},#{admin.password},#{admin.nickName},#{admin.note},#{admin.createTime})")
    @Options(useGeneratedKeys=true, keyProperty="admin.id")
    public int add(@Param("admin")UmsAdmin admin);
}
