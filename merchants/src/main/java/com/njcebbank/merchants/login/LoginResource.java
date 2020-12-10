package com.njcebbank.merchants.login;

import com.njcebbank.merchants.annotation.UserRoles;
import com.njcebbank.merchants.service.LoginService;
import com.njcebbank.merchants.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/2 9:08
 */

@RestController
public class LoginResource {
    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/logging", method = RequestMethod.GET)
    public Map<String, Object> logging(HttpServletRequest request, @RequestParam(value = "userid", required = true) String userid, @RequestParam(value = "password", required = true) String password) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> loggingMap = loginService.logging(userid, password);
        if (loggingMap != null) {
            String token = JWTUtil.sign(userid, password);
            if (token != null) {
                result.put("status", "success");
                result.put("token", token);
                result.put("message", "登录成功");
            }
            result.put("data", loggingMap);

        } else {
            result.put("status", "error");
            result.put("message", "登录失败");
        }
        System.out.println(result);
        return result;
    }
}
