package dev.guldeniz.cv.entities.concretes.job;

import java.util.List;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Experience;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position_name")
    private String positionName; 
    

    @OneToMany(mappedBy="jobPosition")
    private List<JobPosting> jobPosting;
    
    @OneToOne
    private Experience experience;
    
}
