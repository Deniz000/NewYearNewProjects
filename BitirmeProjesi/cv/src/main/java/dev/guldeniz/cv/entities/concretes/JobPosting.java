package dev.guldeniz.cv.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="job_postings")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;

    @Column(name = "job_description")
    private String jobDescription;

    //Bu da bir class olabilir 
    @Column(name = "city")
    private String city;
    
    @Column(name="min_salary")
    private int minSalary;
    
    @Column(name="max_salary")
    private int maxSalary;
    
    @Column(name="open_position_count")
    private int openPositionCount;
    

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name="is_active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;
}
