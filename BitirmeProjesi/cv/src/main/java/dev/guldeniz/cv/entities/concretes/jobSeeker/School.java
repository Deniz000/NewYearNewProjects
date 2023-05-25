package dev.guldeniz.cv.entities.concretes.jobSeeker;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "candidate")
	private Candidate candidate;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "department")
	private String department;

	@Column(name = "sart_day")
	private LocalDate startDay;

	@Column(name = "end_day")
	private LocalDate endDay;

	@Column(name = "grade_avarage")
	private float gradeAvarage;

	@Column(name = "descriptio")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "school_type")
	private SchoolType type;

	public enum SchoolType {
		UNDERGRADUATE, GRADUATE, POSTGRADUATE
	}

	@Column(name = "address")
	private String address;

}
