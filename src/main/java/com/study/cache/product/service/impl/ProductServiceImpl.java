package com.study.cache.product.service.impl;

import com.study.cache.product.entity.Product;
import com.study.cache.product.mapper.ProductMapper;
import com.study.cache.product.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack
 * @since 2019-11-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
