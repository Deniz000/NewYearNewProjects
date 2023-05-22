package dev.guldeniz.cv.entities.concretes.jobSeeker;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @OneToOne
    @JoinColumn(name=("job_seeker_id"))
	private JobSeeker jobSeeker;

    @Column(name="cover_letter")
    private String coverLetter;
    
    @Lob // kalıcı, büyük bir nesne olduğunu bildiriyoruz.
    @Column(name="image")
    private byte[] imageData; 
    
    @Column(name="github")
    private String githubLink;
    
    @Column(name="linkedIn")    
    private String linkedInLink;

	@OneToMany
	private List<School> schools;
	
	@OneToMany
	private List<Experience> experiences;
    
    
    
}
