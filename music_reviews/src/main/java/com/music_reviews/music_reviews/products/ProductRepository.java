package com.music_reviews.music_reviews.products;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {
//    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

//    private Integer id = 1;
//
//    private List<Product> products = new ArrayList<Product>();
//
//    public List<Product> findAll() {
//        return products;
//    }
//
//    public Optional<Product> findById(Integer id) {
//        return Optional.ofNullable(
//                products.stream().filter(product -> product.id() == id).findFirst().orElseThrow(ProductNotFound::new));
//    }
//
//    public void create(Product product) {
//        Product newProduct = new Product(id, product.name(), product.description(), product.price(), product.category(),
//                product.createdAt(), LocalDateTime.now());
//        id++;
//        products.add(newProduct);
//    }
//
//    public void update(Product updatedProduct, Integer id) {
//        Optional<Product> existingProduct = findById(id);
//
//        if (existingProduct.isPresent()) {
//            Product product = existingProduct.get();
//            products.set(products.indexOf(product), product);
//            logger.info("Actualizando producto: " + id);
//        }
//    }
//
//    public void delete(Integer id) {
//        products.removeIf(product -> product.id().equals(id));
//    }
}
