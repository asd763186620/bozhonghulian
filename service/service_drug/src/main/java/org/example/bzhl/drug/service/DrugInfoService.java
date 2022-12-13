package org.example.bzhl.drug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bzhl.model.DrugInfo;
import org.example.bzhl.vo.DrugInfoVo;
import org.springframework.web.multipart.MultipartFile;

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

    void importDictData(MultipartFile file);
}
