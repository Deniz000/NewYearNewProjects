package dev.guldeniz.cv.entities.concretes.languages;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Technology;
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
@Table(name="programming_languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="language_name")
	private String languageName;
	
	@ManyToOne
	@JoinColumn(name="technology")
	private Technology technology;

	@OneToOne
	@JoinColumn(name="language_level")
	private LanguageLevel languageLevel;
}
