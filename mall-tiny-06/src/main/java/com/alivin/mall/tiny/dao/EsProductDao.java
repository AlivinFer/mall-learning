package com.alivin.mall.tiny.dao;

import com.alivin.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fer
 * @date 2021/8/12
 */
@Mapper
@Repository
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
