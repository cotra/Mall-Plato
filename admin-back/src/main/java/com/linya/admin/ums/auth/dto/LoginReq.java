package com.linya.admin.ums.auth.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class LoginReq implements Serializable {
    @NotBlank(message = "账户名称不能为空")
    private String username;
    @NotBlank(message = "账户密码不能为空")
    private String key;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", key=").append(key);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
