package kodlamaio.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.core.Logger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.entities.Category;

public class CategoryManager {
	private List<Category> listOfCategory = new ArrayList<>();
	private Logger[] logs;
	private EntityDao[] databases;
	
	
	public CategoryManager() {
		super();
	}

	public CategoryManager(EntityDao[] entityDao, Logger[] log) {
		super();
		this.logs = log;
		this.databases = entityDao;
	}

	public void add(Category category) throws Exception {
		listOfCategory.add(category);
		Category temp;
		
		for(int i = 0; i < listOfCategory.size()-1; i++) {
			temp = listOfCategory.get(i);
			if(temp.getName() == listOfCategory.get(i+1).getName()) {
				throw new Exception("iki kere " + category.getName() + " eklenemez.");
			}
			
		}
		for(EntityDao db : databases) {
			db.addCategory(category);
		}
		
		for(Logger log : logs) {
			log.log(category.getName().toString());
		}
		System.out.println(category.getName() + " Eklendi ");
	
		//System.out.print(category.getName());
		
	}

}
