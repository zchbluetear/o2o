package com.imooc.o2o.service;

import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExcution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {
	public ShopExcution addShop(Shop shop,ImageHolder imgFile);
}
