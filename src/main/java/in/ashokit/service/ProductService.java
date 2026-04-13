package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId);
	
	public void deleteProduct(Long productId);
	 
}
