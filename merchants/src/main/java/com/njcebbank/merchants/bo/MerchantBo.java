package com.njcebbank.merchants.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author：不许人间见白头 Time：2020/12/2 17:56
 * 特约商户主表
 */
@Data
public class MerchantBo {

    private int id;
    private String merchanttype;
    private String addressname;
    private Double lng;
    private Double lat;
    private String username;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adddate;
    private int isstate;
    private int roleid;


}
