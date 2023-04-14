package dev.guldeniz.cv.entities.concretes;

import dev.guldeniz.cv.entities.abstracts.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User {
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_identity")
	private String nationalIdentity;

	
	@Column(name = "birth_year")
	private int birthYear;
	
	
}
