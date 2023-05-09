package dev.guldeniz.cv.entities.concretes.jobSeeker;

import java.time.LocalDate;

import dev.guldeniz.cv.entities.concretes.City;
import dev.guldeniz.cv.entities.concretes.employer.Employer;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;
import dev.guldeniz.cv.entities.concretes.job.WorkType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="job_seeker")
	private JobSeeker jobSeeker;

	@OneToOne
	@JoinColumn(name="company_name")
	private Employer companyName;
	
	@OneToOne
	@JoinColumn(name="job_pozitions")
	private JobPosition jobPosition;

	@Column(name="sart_day")
	private LocalDate startDay;
	
	@Column(name="end_day")
	private LocalDate endDay;
	
	@Column(name="descriptio")
	private String description;
	
	@OneToOne
	@JoinColumn(name="city")
	private City city;
	
	@OneToOne
	@JoinColumn(name="work_type")
	private WorkType workType;
	
}