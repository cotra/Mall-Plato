package com.linya.admin.modules.role;

import com.linya.admin.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    List<Role> getList();
}
