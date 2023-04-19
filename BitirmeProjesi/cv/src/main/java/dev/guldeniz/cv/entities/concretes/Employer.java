package dev.guldeniz.cv.entities.concretes;

import dev.guldeniz.cv.entities.abstracts.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
