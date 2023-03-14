package dao;

import java.util.ArrayList;

import dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	// 새로운 상품 정보를 등록하는 메소드
	
	public ProductRepository() {
		Product dogPicture1 = new Product("P1234", "멍멍이 사진1", 999999);
		dogPicture1.setDescription("귀여움과 매력이 철철 넘치는 활기찬 사진");
		dogPicture1.setCategory("강아지 사진1");
		dogPicture1.setManufacturer("내 폰");
		dogPicture1.setUnitsInStock(1000);
		dogPicture1.setCondition("New");
		dogPicture1.setFilename("P1234.jpg");
		
		
		Product dogPicture2 = new Product("P1235", "멍멍이 사진2", 9999999);
		dogPicture2.setDescription("위트와 센스가 넘치는 깜찍한 사진");
		dogPicture2.setCategory("강아지 사진2");
		dogPicture2.setManufacturer("주인 폰");
		dogPicture2.setUnitsInStock(2000);
		dogPicture2.setCondition("Refurbished");
		dogPicture2.setFilename("P1235.jpg");
		
		Product dogPicture3 = new Product("P1236", "멍멍이 사진3", 9899999);
		dogPicture3.setDescription("위엄과 도도함이 넘치는 기품있는 사진");
		dogPicture3.setCategory("강아지 사진3");
		dogPicture3.setManufacturer("가족 폰");
		dogPicture3.setUnitsInStock(500);
		dogPicture3.setCondition("Old");
		dogPicture3.setFilename("P1236.jpg");
		
		Product dogPicture4 = new Product("P1240", "멍멍이 사진5", 9899999);
		dogPicture4.setDescription("카리스마와 귀여움이 공존하는 멋있는 사진");
		dogPicture4.setCategory("강아지 사진5");
		dogPicture4.setManufacturer("해규 폰");
		dogPicture4.setUnitsInStock(5004);
		dogPicture4.setCondition("New");
		dogPicture4.setFilename("P1240.jpg");
		
		listOfProducts.add(dogPicture1);
		listOfProducts.add(dogPicture2);
		listOfProducts.add(dogPicture3);
	}
	
	public ArrayList<Product> getAllProducts() {
		return listOfProducts;
	}
	// 객체 타입의 변수 listOfProducts에 저장된 모든 상품 목록을 가져오는 getAllProduct() 메소드 작성

	public Product getProductById(String productId) {
		Product productById = null;
		
		for(int i=0; i<listOfProducts.size(); i++) {
			Product product = listOfProducts.get(i);
			if(product != null && product.getProductId() != null &&
			product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		return productById;
	}
	// 객체 변수 listOfProducts에 저장된 모든 상품목록에서 상품아이디와 일치하는 상품을 가져오는 메소드
}





