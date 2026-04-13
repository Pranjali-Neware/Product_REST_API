package in.ashokit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Product;
import in.ashokit.service.ProductService;

@RestController
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/")
	public ResponseEntity<String> welcomeToProductAPI(){
		String msg="Welcome to product REST API";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<>(product2, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePrduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product deleted suceessfully", HttpStatus.OK);
	}


}
