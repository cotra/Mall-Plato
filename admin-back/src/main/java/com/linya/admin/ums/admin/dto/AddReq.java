package com.linya.admin.ums.admin.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AddReq implements Serializable {
    @NotBlank(message = "账户名称不能为空")
    private String username;
    @NotBlank(message = "账户密码不能为空")
    private String password;
    @NotBlank(message = "账户昵称不能为空")
    private String nickname;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
