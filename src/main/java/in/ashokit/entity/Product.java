package in.ashokit.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="product_name", nullable = false)
	private String productName;
	
	@Column(name="product_price", nullable = false)
	private BigDecimal productPrice;
}
