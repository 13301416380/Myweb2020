package com.njcebbank.merchants.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author：不许人间见白头 Time：2020/12/3 10:13
 * 用户类
 */
@Data
public class Userinfos {
    private int id;
    private String userid;
    private String password;
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //前台传数据到后台
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 后台传数据到前台
    private Date birthday;
    private int userstate;
}
