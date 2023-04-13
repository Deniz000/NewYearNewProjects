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
@Table(name = "employers")
public class Employer extends User {
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@Column(name = "web_address")
	private String webAddress;

	@NotNull
    @Column(name = "phone")
    private String phone;

}
