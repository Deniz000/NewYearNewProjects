package dev.guldeniz.cv.entities.concretes.languages;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="language_level")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LanguageLevel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="level_point")
	private int levelPoint;
	
	@OneToOne
	private ProgrammingLanguage programmingLanguage;

}
