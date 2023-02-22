package kodlamaio.business;

import java.util.List;

import kodlamaio.core.Logger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.entities.Course;

public class CourseManager {
	EntityDao[] databases;
	private Logger[] loggers;
	private List<Course> courses;
	
	
	public CourseManager(EntityDao[] databases, Logger[] loggers) {
		super();
		this.databases = databases;
		this.loggers = loggers;
	}


	public void add(Course course) throws Exception {

		if(courses.isEmpty()) {
			courses.add(course);
		}
		else {
			throw new Exception("Aynı kursu birden fazla kez ekleyemezsiniz");
			
		}
		
		//list util 'e ekler
		
		for(EntityDao database: databases) {
			database.addCourse(course);
		}
		
		for(Logger logger : loggers) {
			logger.log(course.getName());
		}
		
		
	}

}
