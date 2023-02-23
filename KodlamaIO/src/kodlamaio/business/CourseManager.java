package kodlamaio.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.core.Logger;
import kodlamaio.dataAccess.EntityDao;
import kodlamaio.entities.Course;

public class CourseManager {
	EntityDao[] databases;
	private Logger[] loggers;
	private List<Course> listOfCourses;
	private List<Course> deneme;

	
	public CourseManager(EntityDao[] databases, Logger[] loggers, List<Course> courses) {
		super();
		this.databases = databases;
		this.loggers = loggers;
		this.listOfCourses = courses;
	}


	public void add(Course course) throws Exception {
		

		 for(Course checkCourses: listOfCourses)
		{
		        if(course.getName().equals(checkCourses.getName()))
		        {
		            throw new Exception ("Course name can not be same!");
		        }
		        listOfCourses.add(checkCourses);
		    	}
		 

			for(EntityDao database: databases) {
				database.addCourse(course);
			}
			
			for(Logger logger : loggers) {
				logger.log(course.getName());
			}	
	  
	
	}
}

