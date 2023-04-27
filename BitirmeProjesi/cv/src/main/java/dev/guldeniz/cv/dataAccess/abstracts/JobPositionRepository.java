package dev.guldeniz.cv.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {

	JobPosition getByPositionName(String positionName);

	List<JobPosition> getByPositionNameStartsWith(String positionName);

	List<JobPosition> getByPositionNameContains(String positionName);

}
