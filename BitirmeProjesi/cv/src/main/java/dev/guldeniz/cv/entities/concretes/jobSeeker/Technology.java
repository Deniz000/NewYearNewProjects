package dev.guldeniz.cv.entities.concretes.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.entities.concretes.languages.ProgrammingLanguage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="tachnology_name")
	private String tehnology_name;

	@OneToMany(mappedBy="technology")
	private List<ProgrammingLanguage> languages;
}
