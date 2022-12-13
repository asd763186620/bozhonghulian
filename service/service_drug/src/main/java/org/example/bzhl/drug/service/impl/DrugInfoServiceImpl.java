package org.example.bzhl.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bzhl.drug.mapper.DrugInfoMapper;
import org.example.bzhl.drug.service.DrugInfoService;
import org.example.bzhl.model.DrugInfo;
import org.example.bzhl.vo.DrugInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
* @author LiJia
* @description 针对表【drug_info】的数据库操作Service实现
* @createDate 2022-12-12 16:22:21
*/
@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo>
    implements DrugInfoService {

    /**
     * 新增药品
     * @param drugInfoVo
     */
    @Transactional
    @Override
    public void insert(DrugInfoVo drugInfoVo) {
        DrugInfo drugInfo = new DrugInfo();
        drugInfo.setDrugId(drugInfoVo.getDrugId());
        drugInfo.setDrugName(drugInfoVo.getDrugName());
        drugInfo.setDrugPrice(drugInfoVo.getDrugPrice());
        drugInfo.setBusiness(drugInfoVo.getBusiness());
        drugInfo.setDrugType(drugInfoVo.getDrugType());
        this.save(drugInfo);
        DrugInfo drugInfoById = this.getById(drugInfo.getId());
        drugInfo.setDrugId("SY" + drugInfoById.getId());
        this.updateById(drugInfo);
    }

    /**
     * 删除药品
     * @param drugId
     * @param drugName
     * @param business
     */
    @Override
    public void delete(String drugId, String drugName, String business) {
        DrugInfo drugInfo = new DrugInfo();
        drugInfo.setDrugId(drugId);
        drugInfo.setDrugName(drugName);
        drugInfo.setBusiness(business);
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(drugInfo);
        this.remove(queryWrapper);
    }

    /**
     * 查询所有药品信息
     * @return
     */
    @Override
    public List<DrugInfo> select() {
        return this.list();
    }

    /**
     * 商家查询各自的药品信息
     * @param business
     * @return
     */
    @Override
    public List<DrugInfo> selectByBus(String business) {
        QueryWrapper<DrugInfo> drugInfoQueryWrapper = new QueryWrapper<>();
        drugInfoQueryWrapper.eq("business",business);
        return this.list(drugInfoQueryWrapper);
    }

    /**
     * 商家修改各自的药品信息
     * @param drugInfoVo
     * @return
     */
    @Override
    public boolean updateByBus(DrugInfoVo drugInfoVo) {
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("drug_id",drugInfoVo.getDrugId());
        queryWrapper.eq("drug_name",drugInfoVo.getDrugName());
        queryWrapper.eq("business",drugInfoVo.getBusiness());
        DrugInfo drugInfo = this.getOne(queryWrapper);
        drugInfo.setDrugName(drugInfoVo.getDrugName());
        drugInfo.setDrugPrice(drugInfoVo.getDrugPrice());
        drugInfo.setDrugType(drugInfoVo.getDrugType());
        drugInfo.setUpdateTime(new Date());
        return this.updateById(drugInfo);
    }


}




