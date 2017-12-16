package com.imooc.o2o.dto;

import java.util.List;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;

//店铺操作处理类
public class ShopExcution {
	//店铺状态
	private int state;
	//店铺状态描述
	private String stateInfo;
	//店铺数量
	private int count;
	
	private Shop shop; //用于增删改的返回对象
	
	private List<Shop> shopList; //用于查询的返回对象
	
	public ShopExcution() {
		// TODO Auto-generated constructor stub
	}
	
	//店铺操作失败返回的店铺构造器
	public ShopExcution(ShopStateEnum shopstatenum){
		this.state = shopstatenum.getState();
		this.stateInfo = shopstatenum.getStateInfo();
	}
	
	//店铺操作成功返回的店铺构造器
	public ShopExcution(ShopStateEnum shopstatenum,Shop shop){
		this.state = shopstatenum.getState();
		this.stateInfo = shopstatenum.getStateInfo();
		this.shop = shop;
	}
	
	//店铺操作成功返回的店铺构造器
	public ShopExcution(ShopStateEnum shopstatenum,List<Shop> shoplist){
		this.state = shopstatenum.getState();
		this.stateInfo = shopstatenum.getStateInfo();
		this.shopList = shoplist;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	
}
