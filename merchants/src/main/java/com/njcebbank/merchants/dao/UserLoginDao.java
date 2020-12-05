package com.njcebbank.merchants.dao;

import com.njcebbank.merchants.bo.ModuleRole;
import com.njcebbank.merchants.bo.UserRole;
import com.njcebbank.merchants.bo.Userinfos;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：不许人间见白头 Time：2020/12/3 10:42
 */
@Repository
public interface UserLoginDao {
    public List<Userinfos> userLogging(String userid, String password);

    public List<UserRole> userRole(int userid);

    public List<ModuleRole> moduleRole(int  roleid);

}
