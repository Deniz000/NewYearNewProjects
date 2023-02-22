package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class JdbcProductDao implements ProductDao{
	public void add(Product product) {
		//buraya sadece ve sadece db erişim kodları yazılır
		//sql bilmek gerekir. 
		System.out.println("jdbc ile veritabanına eklendi. ");
	}
	public void delete(Product product) {
		System.out.println("jdbc ile veritabanından silindi. ");
	}
	public void update(Product product) {
		System.out.println("jdbc ile güncellendi. ");
	}
}
