package com.xzjy.shiro;

import com.xzjy.mapper.UserMapper;
import com.xzjy.pojo.Users;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper mapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UserToken userToken = (UserToken) token;
        Users user = mapper.login(userToken.getUsername());
        if (user==null){
            return null;
        }
        if(!userToken.getUsername().equals(user.getUId())){
            return null;
        }
        //密码认证shiro帮忙做
        return new SimpleAuthenticationInfo("",user.getUPassword(),"");
    }
}
