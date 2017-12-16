$(function() {
	//获取店铺的初始信息
	var initurl = "/o2o/shopadmin/getshopinitinfo"
	//注册店铺的url
	var registURL = "/o2o/shopadmin/registershop";
	getShopInitInfo();
	
	function getShopInitInfo() {
		
		$.getJSON(initurl,function(data) {
			if(data.success){
				var tempHtml = "";
				var tempAreaHtml = "";
				
				data.shopCategoryList.map(function(item,index){
					tempHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
				});
				
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaname + '</option>';
				});
				
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}
	
	$("#submit").click(function(){
		var shop = {};
		// 获取表单里的数据并填充进对应的店铺属性中
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		
		// 选择选定好的店铺类别
		shop.shopCategory = {
				shopCategoryId : $("#shop-category").find("option").not(function() {
					return !this.selected;
				}).data('id')
		};
		// 选择选定好的区域信息
		shop.area = {
			areaId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		
		// 获取上传的图片文件流
		var shopimg = $("#shop-img")[0].files[0];
		
		// 生成表单对象，用于接收参数并传递给后台
		var formData = new FormData();
		formData.append("shopImg",shopimg);
		// 将shop json对象转成字符流保存至表单对象key为shopStr的的键值对里
		formData.append('shopStr', JSON.stringify(shop));
		
		// 获取表单里输入的验证码
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		
		//AJAX提交表单
		$.ajax({
			url:registURL,
			type:"POST",
			data:formData,
			contentType:false,
			processData:false,
			cache:false,
			success:function(data){
				if(data.success){
					$.toast("提交成功");
				}else{
					$.toast("提交失败" + data.errMsg);
				}
				// 点击验证码图片的时候，注册码会改变
				$('#captcha_img').click();
			}
		});
	});
	
});