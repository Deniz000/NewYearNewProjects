package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class HibernateProductDao implements ProductDao {
	public void add(Product product) {
		//buraya sadece ve sadece db erişim kodları yazılır
		//sql bilmek gerekir. 
		System.out.println("Hibernate ile veritabanına eklendi. ");
	}
	public void delete(Product product) {
		System.out.println("Hibernate ile veritabanından silindi. ");
	}
	public void update(Product product) {
		System.out.println("Hibernate ile güncellendi. ");
	}
}