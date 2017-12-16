package com.imooc.o2o.service;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("北苑",areaList.get(0).getAreaname());
	}
}
