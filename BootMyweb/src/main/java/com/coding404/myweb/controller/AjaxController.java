package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.ProductService;

@RestController
public class AjaxController {

	
	//프로덕트 서비스 영역으로 연결
	@Autowired
	ProductService productService;
	
	//카테고리 로드
	@GetMapping("/getCategory")
	public ArrayList<CategoryVO> getCategory() {
		
		ArrayList<CategoryVO> list = productService.getCategory();
		//화면에 필요한 형식으로 변경해서 List<Map> 반환해도 됩니다.
		
		
		return list;
	}
	
	//두,세번째 카테고리
	@GetMapping("/getCategoryChild/{group_id}/{category_lv}/{category_detail_lv}")
	public ArrayList<CategoryVO> getCategoryChild(@PathVariable("group_id") String group_id,
												  @PathVariable("category_lv") int category_lv,
												  @PathVariable("category_detail_lv") int category_detail_lv) {
		//마이바티스 전달을 위해 vo에 저장
		CategoryVO vo = CategoryVO.builder()
								  .group_id(group_id)
								  .category_lv(category_lv)
								  .category_detail_lv(category_detail_lv)
								  .build();
		
		//서비스 영역 호출(조회)
		ArrayList<CategoryVO> list = productService.getCategoryChild(vo);
		
		
		
		return list;
	}
	
	
	
	
	
	
	
	
}
