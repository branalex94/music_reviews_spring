package com.music_reviews.music_reviews.products;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final Logger logger = LoggerFactory
			.getLogger(ProductController.class);
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PostMapping("")
	public void create(@RequestBody CreateProductDTO product) {
		productService.createProduct(product);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody Product product, Long id) {
		productService.updateProduct(product, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
