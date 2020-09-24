package com.xzjy.shiro;

import com.xzjy.mapper.InformationMapper;
import com.xzjy.pojo.Information;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private InformationMapper mapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UserToken adminToken = (UserToken) token;
        Information admin = mapper.login(adminToken.getUsername());
        if (admin==null){
            return null;
        }
        if(!adminToken.getUsername().equals(admin.getBackId())){
            return null;
        }
        //密码认证shiro帮忙做
        return new SimpleAuthenticationInfo("",admin.getBackPwd(),"");
    }
}