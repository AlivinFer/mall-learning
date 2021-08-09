package com.alivin.mall.tiny.controller;

import com.alivin.mall.tiny.common.impl.CommonPage;
import com.alivin.mall.tiny.common.impl.CommonResult;
import com.alivin.mall.tiny.mbg.model.PmsBrand;
import com.alivin.mall.tiny.service.api.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 品牌管理
 *
 * @author Fer
 * @date 2021/8/4
 */

@Api(tags = "PmsController", description = "商品品牌管理")
@Controller
//@RestController
@RequestMapping("/brand")
public class PmsController {
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsController.class);

   /* @RequestMapping("/test")
    public String Test() {
        return "ok";
    }*/

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        /*for (PmsBrand brand : brandService.listAllBrand()) {
            System.out.println(brand);
        }*/
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsBrand> addBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult<PmsBrand> commonResult;
        int ans = brandService.addBrand(pmsBrand);
        if (ans == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("addBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("addBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsBrand> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand) {
        CommonResult<PmsBrand> commonResult;
        int ans = brandService.updateBrand(id, pmsBrand);
        if (ans == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("更新失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id品牌信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> deleteBrand(@PathVariable("id") Long id, PmsBrand pmsBrand) {
        CommonResult<PmsBrand> commonResult;
        int ans = brandService.deleteBrand(id);
        if (ans == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("deleteBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("删除失败");
            LOGGER.debug("deleteBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("获取指定id品牌信息")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> selectBrand(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> showPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
}

