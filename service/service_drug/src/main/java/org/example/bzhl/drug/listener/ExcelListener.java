package org.example.bzhl.drug.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.example.bzhl.drug.mapper.DrugInfoMapper;
import org.example.bzhl.model.DrugInfo;
import org.example.bzhl.vo.DrugInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ExcelListener extends AnalysisEventListener<DrugInfoVo> {


    @Resource
    DrugInfoMapper drugInfoMapper;

    @Override
    public void invoke(DrugInfoVo drugInfoVo, AnalysisContext analysisContext) {
        DrugInfo drugInfo = new DrugInfo();
        BeanUtils.copyProperties(drugInfoVo,drugInfo);
        drugInfoMapper.insert(drugInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成");
    }
}
