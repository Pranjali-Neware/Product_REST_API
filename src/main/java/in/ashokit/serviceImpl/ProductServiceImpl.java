package in.ashokit.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.entity.Product;
import in.ashokit.repository.ProductRepository;
import in.ashokit.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

}
