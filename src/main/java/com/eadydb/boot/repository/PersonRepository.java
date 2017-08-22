package com.eadydb.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eadydb.boot.entity.Person;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 11:08:15 AM
 *       <p/>
 * @DESCRIPTION
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByPersonName(String personName);

}
