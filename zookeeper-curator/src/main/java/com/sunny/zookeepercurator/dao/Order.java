package com.sunny.zookeepercurator.dao;


import lombok.*;

/**
 * @author：不许人间见白头 Time：2020/11/23 8:55
 */
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

    private int id;
    private int pid ;
    private  String userId;
}
