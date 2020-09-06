package com.dgut.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @atuhor:
 * @date: 2020-05-24  21:49
 */
@Mapper
public interface StorageDao {


    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
