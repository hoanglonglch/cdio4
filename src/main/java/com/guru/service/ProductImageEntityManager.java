package com.guru.service;

import java.util.List;

import com.guru.entities.ProductEntity;
import com.guru.entities.ProductImageEntity;

public interface ProductImageEntityManager {
	List<ProductImageEntity> getByProduct(ProductEntity productEntity);
}
