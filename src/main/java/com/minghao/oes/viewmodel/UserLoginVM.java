package com.minghao.oes.viewmodel;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录信息视图对象
 **/
public class UserLoginVM {

    @NotBlank
    private String userName;

    @NotBlank
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
