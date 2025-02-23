package com.music_reviews.music_reviews.products;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.music_reviews.music_reviews.category.Category;
import com.music_reviews.music_reviews.category.CategoryNotFound;
import com.music_reviews.music_reviews.category.CategoryRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository,
			CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct.isEmpty()) {
			throw new ProductNotFound();
		}
		return existingProduct.get();
	}

	public void createProduct(CreateProductDTO product) {
		Optional<Category> existingCategory = categoryRepository
				.findById(product.getCategoryId());
		if (existingCategory.isEmpty()) {
			throw new CategoryNotFound();
		}
		Product newProduct = new Product();
		LocalDateTime timestamp = LocalDateTime.now();
		newProduct.setCreatedAt(timestamp);
		newProduct.setUpdatedAt(timestamp);
		newProduct.setCategory(existingCategory.get());
		newProduct.setDescription(product.getDescription());
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		productRepository.save(newProduct);
	}

	public void updateProduct(Product product, Long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if (!existingProduct.isPresent()) {
			throw new ProductNotFound();
		}
		productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		Optional<Product> productExists = productRepository.findById(id);
		if (productExists.isEmpty()) {
			throw new ProductNotFound();
		}
		productRepository.deleteById(id);
	}
}
