package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listArea(){
		logger.info("==start==");
		
		long starttime = System.currentTimeMillis();
		
		Map<String, Object> modelArea = new HashMap<String, Object>();
		List<Area> arealist = new ArrayList<>();
		
		try {
			arealist = areaService.getAreaList();
			modelArea.put("rows",arealist.size());
			modelArea.put("total", arealist);
		}catch(Exception e){
			e.printStackTrace();
			modelArea.put("success", false);
			modelArea.put("fail", e.toString());
		}
		logger.error("test error");
		
		long endtime = System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endtime-starttime);
		
		logger.info("==end==");
		
		return modelArea;		
	}
}
