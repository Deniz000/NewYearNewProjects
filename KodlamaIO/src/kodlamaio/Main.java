package kodlamaio;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.business.CourseManager;
import kodlamaio.core.Logger;
import kodlamaio.core.SMSLogger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.dataAccess.HibernateEntityDao;
import kodlamaio.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Course course = new Course();
		course.setId(1);
		course.setName("Ek 1");
		System.out.println(course.getName());
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("Ek 2");
		System.out.println(course1.getName());
		
		Course course2 = new Course();
		course2.setId(1);
		course2.setName("Ek 1");
		System.out.println(course2.getName());
		
		EntityDao[] entityDao = {new HibernateEntityDao()}; 
		Logger[] loggers = {new SMSLogger()};
		List<Course> courses = new ArrayList<>();
 		
		CourseManager courseManager = new CourseManager(entityDao, loggers, courses);

		courseManager.add(course);
		courseManager.add(course1);
		courseManager.add(course2);


	}

}
