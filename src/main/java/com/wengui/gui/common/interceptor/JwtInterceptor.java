package com.wengui.gui.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wengui.gui.common.Constants;
import com.wengui.gui.entity.User;
import com.wengui.gui.exception.ServiceException;
import com.wengui.gui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
//        如果不是映射方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
//        执行认证
        if(StrUtil.isBlank(token)){
            throw new ServiceException(Constants.CODE_401,"无token,请重新登录");
        }
//        获取 token 中的 userid
        String userid;
        try {
            userid = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(Constants.CODE_401,"token验证失败,请重新登录");
        }

//        根据userid查询数据库
        User user = userService.getById(userid);
        if(user == null){
            throw new ServiceException(Constants.CODE_401,"用户不存在,请重新登录");
        }

//        用户密码加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);      //验证 token
        }catch (JWTVerificationException e){
            throw new ServiceException(Constants.CODE_401,"token验证失败,请重新登录");
        }
        return true;
    }
}
