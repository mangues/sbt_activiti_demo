package com.eadydb.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 10:55:25 AM
 *       <p/>
 * @DESCRIPTION
 */
@Data
@Entity
@Table(name = "t_person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long personId;

	@Column(name = "person_name", unique = true, nullable = false)
	private String personName;

	@ManyToOne(targetEntity = Company.class)
	private Company company;

	public Person(String personName) {
		super();
		this.personName = personName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
