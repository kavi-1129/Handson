
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String ProductFeatures;

	public Product(int id, String name, String productFeatures) {
		super();
		this.id = id;
		this.name = name;
		ProductFeatures = productFeatures;
	}
	
	public static Product create(int id, String name, String productFeatures) {
        Product product = new Product();
        product.setId(id);
        product.setname(name);
        product.setProductFeatures(productFeatures);
        
        return product;
    }
	
	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getProductFeatures() {
		return ProductFeatures;
	}

	public void setProductFeatures(String productFeatures) {
		ProductFeatures = productFeatures;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", ProductFeatures=" + ProductFeatures + "]";
	}

}