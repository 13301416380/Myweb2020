package com.njcebbank.merchants.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author：不许人间见白头 Time：2020/12/2 17:56
 * 特约商户主表
 */
@Data
public class MerchantBo {

    private int id;
    private String merchanttype;
    private String title;
    private String address;
    private Double lng;
    private Double lat;
    private String userid;
    private String phonenumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //前台传数据到后台
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 后台传数据到前台
    private Date adddate;
    private int isstate;





}
