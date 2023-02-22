package kodlamaio.dataAccess;

import kodlamaio.business.CourseManager;
import kodlamaio.core.Logger;
import kodlamaio.core.SMSLogger;
import kodlamaio.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Course course = new Course(1, "Mat");
		System.out.println(course.getName());
		
		EntityDao[] entityDao = {new HibernateEntityDao()}; 
		Logger[] loggers = {new SMSLogger()};
		
		CourseManager courseManager = new CourseManager(entityDao, loggers );
		courseManager.add(course);
	}

}
