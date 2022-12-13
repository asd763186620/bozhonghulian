package org.example.bzhl.drug.service.impl;

import org.example.bzhl.drug.service.DrugInfoService;
import org.example.bzhl.model.DrugInfo;
import org.example.bzhl.vo.DrugInfoVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @Classname DrugInfoServiceImplTest
 * @Date 2022/12/12 19:08
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@SpringBootTest
class DrugInfoServiceImplTest {

    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 新增药品接口测试
     */
    @Test
    public void testInsert(){
        DrugInfoVo drugInfoVo = new DrugInfoVo();
        drugInfoVo.setDrugName("六叶地黄丸");
        drugInfoVo.setDrugPrice(new BigDecimal("43.56"));
        drugInfoVo.setBusiness("老百姓大药房");
        drugInfoVo.setDrugType("中成药");
        drugInfoService.insert(drugInfoVo);
    }

    /**
     * 删除药品接口测试
     */
    @Test
    public void testDelete(){
        drugInfoService.delete("SY100107","六叶地黄丸","怡心大药房");
    }
    
    @Test
    public void testUpdate(){
        DrugInfo drugInfo = new DrugInfo();
        drugInfo.setId(100108L);
        drugInfo.setDrugId("SY100108");
        drugInfo.setDrugName("六叶地黄丸");
        drugInfo.setUpdateTime(new Date());
        drugInfoService.updateById(drugInfo);
    }
}