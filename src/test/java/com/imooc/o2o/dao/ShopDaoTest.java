package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testUpdateShop(){
		Shop shop = new Shop();
		shop.setShopId(3L);
		shop.setAdvice("审核中");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setLastEditTime(new Date());
		shop.setShopImg("img");
		shop.setShopName("水果店");
		int effectedRows = shopDao.updateShop(shop);
		assertEquals(1,effectedRows);
	}
	
	@Test
	@Ignore
	public void testInsertShop(){
		Area area = new Area();
		PersonInfo owner = new PersonInfo();
		ShopCategory shopCategory = new ShopCategory();
		Shop shop = new Shop();
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		owner.setUserId(1L);
		shop.setArea(area);
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setAdvice("审核中");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setLastEditTime(new Date());
		shop.setPhone("17778052351");
		shop.setPriority(2);
		shop.setShopAddr("北京");
		shop.setShopDesc("北京店铺");
		shop.setShopImg("test");
		shop.setShopName("奶茶店");
		int effectedRows = shopDao.insertShop(shop);
		assertEquals(1,effectedRows);
	}
	
}
