package org.example.bzhl.drug.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.bzhl.drug.service.DrugInfoService;
import org.example.bzhl.model.DrugInfo;
import org.example.bzhl.vo.DrugInfoVo;
import org.example.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname DrugInfoController
 * @Date 2022/12/12 16:27
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@Api(tags = "药品的增删改查")
@RestController
@RequestMapping("/api/drug")
public class DrugInfoController {

    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 新增药品
     * @param drugInfoVo
     */
    @ApiOperation(value = "新增药品")
    @PostMapping("/insert")
    public void insert(@RequestBody DrugInfoVo drugInfoVo){
        drugInfoService.insert(drugInfoVo);
    }

    /**
     * 商家删除自家的药品
     * 根据药品名字/代码/商家名字删除
     *
     */
    @ApiOperation(value = "删除药品")
    @DeleteMapping("/delete/{drugId}/{drugName}/{business}")
    public void delete(@PathVariable String drugId,@PathVariable String drugName,@PathVariable String business){
        drugInfoService.delete(drugId,drugName,business);
    }

    /**
     * 消费者查询所有药品信息
     */
    @ApiOperation(value = "查询药品")
    @GetMapping("/select")
    public List<DrugInfo> select(){
        return drugInfoService.select();
    }

    /**
     * 商家查询各自的药品信息
     * @param business
     * @return
     */
    @GetMapping("/select/{business}")
    public List<DrugInfo> selectByBus(@PathVariable String business){
        return drugInfoService.selectByBus(business);
    }

    /**
     * 平台管理员根据id删除药品
     * @return
     */
    @DeleteMapping("/update/{id}")
    public Result update(@PathVariable Long id){
        if (drugInfoService.removeById(id)) {
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    /**
     * 平台管理员修改药品信息
     * @param drugInfo
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody DrugInfo drugInfo){
        if (drugInfoService.updateById(drugInfo)) {
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    /**
     * 商家修改对应药品信息
     * @param drugInfoVo
     * @return
     */
    @PostMapping("/update/{drugId}/{drugName}/{business}")
    public Result update(@RequestBody DrugInfoVo drugInfoVo){
        if (drugInfoService.updateByBus(drugInfoVo)){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }
}
