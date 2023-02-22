package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.Logger;
import oopWithNLayeredApp.core.DatabaseLogger;
import oopWithNLayeredApp.core.FileLogger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//ürün ekleme
		Product product1 = new Product(1,"samsung", 10000);
		
		Logger[] loggers = {new DatabaseLogger()};
		//veritabanına kaydetme
		ProductManager productManager = 
				new ProductManager(new HibernateProductDao(), loggers);
		productManager.add(product1);
		
	}

}
