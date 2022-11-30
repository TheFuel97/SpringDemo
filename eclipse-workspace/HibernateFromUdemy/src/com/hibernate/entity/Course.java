package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@OneToMany(mappedBy="")
	private Instructor ins;

}
