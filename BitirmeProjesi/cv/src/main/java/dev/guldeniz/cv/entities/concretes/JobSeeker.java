package dev.guldeniz.cv.entities.concretes;

import dev.guldeniz.cv.entities.abstracts.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User {
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Column(name = "national_identity")
	private String nationalIdentity;

	@NotNull
	@Column(name = "birth_year")
	private int birthYear;
	
	
}
