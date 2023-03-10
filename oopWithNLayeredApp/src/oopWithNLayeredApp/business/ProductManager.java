package oopWithNLayeredApp.business;

import java.util.List;

import oopWithNLayeredApp.core.Logger;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {
	private ProductDao productDao;
	private Logger[] loggers;
	
	
	public ProductManager(ProductDao productDao, Logger[] loggers) {
		super();
		this.productDao = productDao;
		this.loggers = loggers;
	}


	public void add(Product product) throws Exception {
		//iş kuralları 
		//business rules
		//business domain
		if(product.getUnitPrice() < 10) {
			throw new Exception("ürün fiyatı 10'dan küçük olamaz");
		}
		
		//kötü kod 
		//JdbcProductDao productDao = new JdbcProductDao();
		productDao.add(product);
		
		for (Logger logger : loggers) {
			logger.log(product.getName());
		}
				
	}

}
