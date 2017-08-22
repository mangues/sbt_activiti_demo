package com.eadydb.boot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 10:58:01 AM
 *       <p/>
 * @DESCRIPTION
 */
@Data
@Entity
@Table(name = "t_company")
public class Company implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2097384152801573438L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id")
	private Long compId;

	@Column(name = "comp_name", unique = true, nullable = false)
	private String compName;

	@OneToMany(mappedBy = "company", targetEntity = Person.class)
	private List<Person> people;

	public Company(String compName) {
		super();
		this.compName = compName;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
