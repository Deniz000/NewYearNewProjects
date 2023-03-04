package kodlamaio.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.core.Logger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.entities.Category;
import kodlamaio.entities.Course;

public class CourseManager {
	EntityDao[] databases;
	private Logger[] loggers;
	private List<Course> listOfCourses = new ArrayList<>();

	
	
	public CourseManager() {
	}


	public CourseManager(EntityDao[] databases, Logger[] loggers) {
		this.databases = databases;
		this.loggers = loggers;
	}


	public void add(Course course) throws Exception {
		listOfCourses.add(course);
		Course temp;

		
		for(int i = 0; i < listOfCourses.size()-1; i++) {
			temp = listOfCourses.get(i);
			
			if(temp.getName() == listOfCourses.get(i+1).getName()) {
				throw new Exception("iki kere " + course.getName() + " eklenemez.");
			}
		}
		if (course.getPrice() < 0) {
			throw new Exception("0 dan küçük fiyat girilemez.");
		}
		
		for(EntityDao db : databases) {
			db.addCourse(course);
		}
		
		for(Logger log : loggers) {
			log.log(course.getName().toString());
		}
		
	
	}
}

