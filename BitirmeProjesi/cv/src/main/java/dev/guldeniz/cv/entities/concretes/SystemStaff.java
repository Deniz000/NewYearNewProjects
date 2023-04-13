package dev.guldeniz.cv.entities.concretes;

import dev.guldeniz.cv.entities.abstracts.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name="system_staff")
public class SystemStaff extends User{

}
