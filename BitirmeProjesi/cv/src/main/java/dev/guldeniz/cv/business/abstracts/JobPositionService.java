package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
	void add(JobPosition jobPosition);
}
