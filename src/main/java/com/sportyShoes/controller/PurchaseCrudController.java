package com.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyShoes.model.Purchase;
import com.sportyShoes.service.PurchaseCrudService;


//@Api(value="purchasecrud")
@RestController
public class PurchaseCrudController {

	@Autowired
	private PurchaseCrudService purchaseCrudService;
	
	@PostMapping("/purchase")
	public Purchase createPurchase(@RequestBody Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaseCrudService.createPurchase(purchase);
	}

	@PutMapping("/purchase")
	public Purchase updatePurchase(@RequestBody Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaseCrudService.updatePurchase(purchase);
	}

	@GetMapping("/purchase/{purchaseId}")
	public Purchase getPurchaseById(@PathVariable int purchaseId) {
		// TODO Auto-generated method stub
		return purchaseCrudService.getPurchaseById(purchaseId);
	}

	@DeleteMapping("/purchase/{purchaseId}")
	public void deletePurchaseById(@PathVariable int purchaseId) {
		// TODO Auto-generated method stub
		purchaseCrudService.deletePurchaseById(purchaseId);
	}

}
