package com.dgut.springcloud.service;

/**
 * @atuhor:
 * @date: 2020-05-24  21:50
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
