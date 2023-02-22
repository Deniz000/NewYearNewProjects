package kodlamaio.dataAccess;

import kodlamaio.entities.Category;
import kodlamaio.entities.Course;
import kodlamaio.entities.Trainer;

public class JdbcEntityDao implements EntityDao{

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		System.out.println(course + " eklendi. Sms bilgisi almak istemiyorsanız ...");
		
	}

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		System.out.println(trainer + " eklendi. Sms bilgisi almak istemiyorsanız ...");

	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println(category + " eklendi. Sms bilgisi almak istemiyorsanız ...");

	}

	

}
