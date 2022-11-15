package com.wufuqiang.es.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wufuqiang
 * @date 2022/2/5 7:20 PM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String title;
    private String category;
    private String images;
    private Double price;
}
