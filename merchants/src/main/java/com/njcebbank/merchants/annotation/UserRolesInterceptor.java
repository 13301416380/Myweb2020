package com.njcebbank.merchants.annotation;

import com.njcebbank.merchants.bo.UserRole;
import com.njcebbank.merchants.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/4 10:04
 */
@Service
public class UserRolesInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            UserRoles roleCheck = method.getAnnotation(UserRoles.class);
            if (roleCheck != null) {
                String[] roles = roleCheck.roles();//获取方法中设置的权限信息
               //session中存储了该用户的权限信息

                String userid = request.getParameterMap().get("userid")[0]==null?null:request.getParameterMap().get("userid")[0];
                String password = request.getParameterMap().get("password")[0]==null?null:request.getParameterMap().get("password")[0];
                Map<String, Object> logging = loginService.logging(userid,password);
                if (logging != null) {
                    //获取权限
                    List<UserRole> userRoles = (List<UserRole>) logging.get("useriRoles");
                    //遍历权限查看是否有访问权限
                    for (UserRole user  : userRoles) {
                        String roleid = String.valueOf(user.getRoleid());
                        for (String role : roles) {
                            if (role.equals(roleid)) {//判断用户是否有权限访问
                                return true;
                            }
                        }
                    }

                }

                return false;

            }
            return true;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
