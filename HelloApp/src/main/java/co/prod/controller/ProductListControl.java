package co.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceMybatis;
import co.prod.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		
		ProductService service = new ProductServiceMybatis();
		
		List<ProductVO> list =  service.products();
		req.setAttribute("list", list);
		
		
		
		return "product/productList.tiles"; 
		
		
		// db 결과 -> attribute("list")
//		return "product/productList.tiles"; // 실행할 페이지.	
		
		
	}

}
