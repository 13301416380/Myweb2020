package com.njcebbank.merchants.bo;

import lombok.Data;

/**
 * @author：不许人间见白头 Time：2020/12/3 16:58
 */
@Data
public class UserRole {
    private int userid;//用户ID 非用户账户 查询条件
    private int roleid;//角色ID
    private int userstate;//用户角色状态
    private String rolename;//用户角色名称

}
