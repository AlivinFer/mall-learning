package com.alivin.mall.tiny.service.api;

import com.alivin.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Fer
 * @date 2021/8/4
 */
public interface PmsBrandService {

    /**
     * 获取所有商家品牌
     */
    List<PmsBrand> listAllBrand();

    /**
     * 根据品牌 id 查询
     */
    PmsBrand getBrand(Long id);

    /**
     * 分页查询
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 增加品牌
     */
    int addBrand(PmsBrand brand);

    /**
     * 更新商家信息
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 根据 id 删除商家
     */
    int deleteBrand(Long id);
}
