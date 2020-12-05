package com.njcebbank.merchants.service.impl;

import com.njcebbank.merchants.bo.ModuleRole;
import com.njcebbank.merchants.bo.UserRole;
import com.njcebbank.merchants.bo.Userinfos;
import com.njcebbank.merchants.dao.UserLoginDao;
import com.njcebbank.merchants.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author：不许人间见白头 Time：2020/12/3 14:27
 */
@Slf4j
@Service
public class LoginSericeImpl implements LoginService {

    @Autowired
    private UserLoginDao userLoginDao;

    //用户登录
    @Override
    public Map<String, Object> logging(String userid, String password) {
        List<Userinfos> userinfoslist = userLoginDao.userLogging(userid, password);
        if (userinfoslist.size() > 0) {
            Userinfos userinfos = userinfoslist.get(0);
            int id = userinfos.getId();
            //模块权限过滤
            Set<String> merchanttypeSet = new HashSet<String>();
            //获取多个角色
            List<UserRole> useriRolesList = userLoginDao.userRole(id);
            useriRolesList.stream().forEach(UserRole->{
                //每个角色可以能多个权限
                List<ModuleRole> moduleRolesList = userLoginDao.moduleRole(UserRole.getRoleid());
                moduleRolesList.stream().forEach(ModuleRole->{
                    //获取单个角色对应的模块权限
                    String merchanttype = ModuleRole.getMerchanttype();
                    merchanttypeSet.add(merchanttype);

                });
            });

            Map<String, Object> userMap = new HashMap<String, Object>();
            userMap.put("userinfos", userinfos);
            userMap.put("useriRoles", useriRolesList);
            userMap.put("moduleRoles", merchanttypeSet);
            return userMap;
        } else {
            return null;
        }

    }
}
