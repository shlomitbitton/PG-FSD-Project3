package com.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyShoes.model.Product;
import com.sportyShoes.service.ProductCrudService;




//@Api(tags = { SportyShoesConfigBean.TAG_1 })
//@Api(value="productcrud")
@RestController
public class ProductCrudController {
	
	@Autowired
	private ProductCrudService productCrudService;
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return productCrudService.createProduct(product);
//		return "Hello from Post";
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return productCrudService.updateProduct(product);
	}

	@GetMapping("/product/{productId}")
	public Product getProductById(@PathVariable (value="productId") int productId) {
		// TODO Auto-generated method stub
		return productCrudService.getProductById(productId);
	}

	@DeleteMapping("/product/{productId}")
	public void deleteProductById(@PathVariable (value="productId") int productId) {
		// TODO Auto-generated method stub
		productCrudService.deleteProductById(productId);
	}


}
