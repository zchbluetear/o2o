package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {
	//新增店铺
	public int insertShop(Shop shop);
	//更改店铺
	public int updateShop(Shop shop);
}
