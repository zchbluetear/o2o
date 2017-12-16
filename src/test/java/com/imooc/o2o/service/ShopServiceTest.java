package com.imooc.o2o.service;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExcution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testAddShop() {
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
		shop.setPhone("17778052354");
		shop.setPriority(2);
		shop.setShopAddr("北京");
		shop.setShopDesc("北京烤鸭店");
		shop.setShopName("奶茶店");
		
		File file = new File("");
		FileInputStream fileInpustream = null;
		
		try {
			fileInpustream = new FileInputStream("/Users/bluetear/o2o/image/63.jpg");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageHolder imageHolder = new ImageHolder("63.jpg",fileInpustream);
		ShopExcution shopExcution = shopService.addShop(shop, imageHolder);
		assertEquals(shopExcution.getState(),ShopStateEnum.CHECK.getState());
	}
}
