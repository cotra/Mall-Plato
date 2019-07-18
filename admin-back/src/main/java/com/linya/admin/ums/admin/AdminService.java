package com.linya.admin.ums.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.linya.admin.bo.AuthBo;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.po.UmsAdmin;
import com.linya.admin.ums.admin.dao.AdminDao;
import com.linya.admin.ums.admin.dto.AddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao dao;

    @Autowired
    AuthBo authBo;

    public Cstp<Long> add(AddReq req) {
        // 合并属性
        UmsAdmin admin = new UmsAdmin();
        BeanUtil.copyProperties(req, admin);
        // 业务逻辑
        admin.setPassword(authBo.encode(admin.getPassword()));
        admin.setCreateTime(DateUtil.date());
        // dao调用
        dao.add(admin);
        // result返回
        Long id = admin.getId();
        if(id == null) {
            return Result.fail();
        }
        return Result.ok(id);
    }
}
