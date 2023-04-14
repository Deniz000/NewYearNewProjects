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
@Table(name = "employers")
public class Employer extends User {
	
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;

    @Column(name = "phone")
    private String phone;

}
