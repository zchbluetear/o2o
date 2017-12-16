package com.imooc.o2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExcution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao ShopDao;
	
	@Override
	public ShopExcution addShop(Shop shop, ImageHolder fileImg) {
		if(shop == null) {
			return new ShopExcution(ShopStateEnum.NULL_SHOP);
		}
		
		try{
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			shop.setEnableStatus(0);
			int effectedShopNum = ShopDao.insertShop(shop);
			if(effectedShopNum < 1){
				throw new RuntimeException("店铺创建失败");
			}else {
				if(fileImg.getImage() != null) {
					try {
						addFileImgToShop(shop,fileImg);
					}catch(Exception ex){
						throw new RuntimeException("增加店铺信息失败");
					}
					//更新Shop的图片地址
					effectedShopNum = ShopDao.updateShop(shop);
					if(effectedShopNum <= 0) {
						throw new RuntimeException("更新店铺图片失败");
					}
				}
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return new ShopExcution(ShopStateEnum.CHECK,shop);
	}
	
	private void addFileImgToShop(Shop shop,ImageHolder fileImg) {
		//获取shop图片目录的相对路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(fileImg, dest);
		shop.setShopImg(shopImgAddr);
	}
}
