package kodlamaio.dataAccess;

import kodlamaio.entities.Category;
import kodlamaio.entities.Course;
import kodlamaio.entities.Trainer;

public interface EntityDao {
	void addCourse(Course course);
	void addTrainer(Trainer trainer);
	void addCategory(Category category);

	
}