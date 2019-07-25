package com.linya.admin.ums.auth.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginRes implements Serializable {
    private String username;

    private String avatar;

    private String mobile;

    private String email;

    private String nickname;

    private Date loginTime;

    private String token;
}
