package org.example.bzhl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Classname DrugInfoVo
 * @Date 2022/12/12 18:55
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugInfoVo {
    private String drugId;
    private String drugName;
    private BigDecimal drugPrice;
    private String business;
    private String drugType;
}
