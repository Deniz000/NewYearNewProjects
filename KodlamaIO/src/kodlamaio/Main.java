package kodlamaio;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.business.CategoryManager;
import kodlamaio.business.CourseManager;
import kodlamaio.core.FileLogger;
import kodlamaio.core.Logger;
import kodlamaio.core.SMSLogger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.dataAccess.HibernateEntityDao;
import kodlamaio.dataAccess.JdbcEntityDao;
import kodlamaio.entities.Category;
import kodlamaio.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EntityDao[] databases = {new HibernateEntityDao(), new JdbcEntityDao() };
		Logger[] logs = {new SMSLogger(), new FileLogger()};
		
		Course course1 = new Course(0, "Matematik", 130);
		Course course2 = new Course(1, "Türkçe", 110);
		Course course3 = new Course(2, "Fen", 100);
		
		CourseManager courseManager = new CourseManager(databases, logs);
		courseManager.add(course1);
		courseManager.add(course2);
		courseManager.add(course3);
		
		
		  
		  Category category = new Category(0, "Ev Eşyası"); 
		  Category category2 = new Category(1, "Giyim"); 
		  Category category3 = new Category(2, "Bahçe");
		  

		  CategoryManager categoryManager = new CategoryManager(databases, logs);
		  categoryManager.add(category); categoryManager.add(category2);
		  categoryManager.add(category3);
		 
		/* 
		 * Course course = new Course(); course.setId(1); course.setName("Ek 1");
		 * System.out.println(course.getName());
		 * 
		 * Course course1 = new Course(); course1.setId(1); course1.setName("Ek 2");
		 * System.out.println(course1.getName());
		 * 
		 * Course course2 = new Course(); course2.setId(1); course2.setName("Ek 1");
		 * System.out.println(course2.getName());
		 * 
		 * EntityDao[] entityDao = {new HibernateEntityDao()}; Logger[] loggers = {new
		 * SMSLogger()}; List<Course> courses = new ArrayList<>();
		 * 
		 * CourseManager courseManager = new CourseManager(entityDao, loggers, courses);
		 * 
		 * courseManager.add(course); courseManager.add(course1);
		 * courseManager.add(course2);
		 */

	}

}