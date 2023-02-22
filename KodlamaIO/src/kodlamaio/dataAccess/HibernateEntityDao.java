package kodlamaio.dataAccess;

import kodlamaio.entities.Category;
import kodlamaio.entities.Course;
import kodlamaio.entities.Trainer;

public class HibernateEntityDao implements EntityDao{

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		System.out.println("Hibernate " + course );
	}

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		System.out.println("Hibernate " + trainer );

	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println("Hibernate " + category );

	}

}
