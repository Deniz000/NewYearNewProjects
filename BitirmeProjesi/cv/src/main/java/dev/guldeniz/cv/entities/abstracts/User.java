package dev.guldeniz.cv.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="email", unique=true)
	private String EMail;
	
	
	@Column(name="password_hash")
	private String passwordHash;
	
	
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_verified")
    private boolean isVerified;
	
//Bu sınıf abstract çünkü veritabanında base sınıfın bir tablosunun olmasını istemiyoruz 
}
