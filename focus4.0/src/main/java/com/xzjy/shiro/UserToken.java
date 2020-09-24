package com.xzjy.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义token,用于确定登陆者类型
 * <p>Title: UserToken</p>  
 * <p>Description: </p>  
 * @author Adam 
 * @date 2018年8月14日
 */
public class UserToken extends UsernamePasswordToken {
	private String loginType;

    public UserToken() {}

    public UserToken(final String username, final String password,
                     final String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
