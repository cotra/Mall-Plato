package com.linya.admin.ums.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginReq implements Serializable {
    @NotBlank(message = "账户名称不能为空")
    private String username;
    @NotBlank(message = "账户密码不能为空")
    private String key;
}
