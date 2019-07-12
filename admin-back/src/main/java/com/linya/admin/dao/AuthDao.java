package com.linya.admin.dao;

import com.linya.admin.po.UmsPermission;
import com.linya.admin.po.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthDao {

    @Select("SELECT r.name FROM ums_admin_role_relation ar INNER JOIN ums_role r ON ar.role_id = r.id WHERE ar.admin_id=#{id}")
    List<UmsRole> getRoleList(@Param("id") Long id);

    @Select("SELECT p.id,p.name,p.value FROM ums_admin a INNER JOIN ums_admin_role_relation ar ON a.id=ar.admin_id INNER JOIN ums_role r ON ar.role_id=r.id INNER JOIN ums_role_permission_relation rp ON r.id=rp.role_id INNER JOIN ums_permission p ON rp.permission_id=p.id WHERE a.id=#{id} GROUP BY p.id;")
    List<UmsPermission> getPermissionList(@Param("id") Long id);
}
