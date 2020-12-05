package com.njcebbank.merchants.bo;

import lombok.Data;

/**
 * @author：不许人间见白头 Time：2020/12/3 17:02
 */
@Data
public class ModuleRole {
    private int roleid;//角色ID  查询条件
    private int merchanttypeid;//模块ID
    private String merchanttype;//模块类型
    private int merchantstate;//模块启用状态

}
