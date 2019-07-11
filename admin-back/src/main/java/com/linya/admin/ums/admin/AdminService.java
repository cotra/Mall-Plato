package com.linya.admin.ums.admin;

import cn.hutool.core.date.DateUtil;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.po.UmsAdmin;
import com.linya.admin.ums.admin.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public Cstp<Long> add(UmsAdmin admin) {
        admin.setCreateTime(DateUtil.date());
        int result = adminDao.add(admin);

        // 返回
        Long id = admin.getId();
        if(id != null) {
            return Result.ok(id);
        } else {
            return Result.fail();
        }
    }
}
