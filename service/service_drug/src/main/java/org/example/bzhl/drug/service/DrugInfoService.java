package org.example.bzhl.drug.service;

import org.example.bzhl.model.DrugInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bzhl.vo.DrugInfoVo;

import java.util.List;

/**
* @author LiJia
* @description 针对表【drug_info】的数据库操作Service
* @createDate 2022-12-12 16:22:21
*/
public interface DrugInfoService extends IService<DrugInfo> {

    void insert(DrugInfoVo drugInfoVo);

    void delete(String drugId, String drugName, String business);

    List<DrugInfo> select();

    List<DrugInfo> selectByBus(String business);

    boolean updateByBus(DrugInfoVo drugInfoVo);
}
