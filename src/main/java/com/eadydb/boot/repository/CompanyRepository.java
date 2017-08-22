package com.eadydb.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eadydb.boot.entity.Company;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 11:10:09 AM
 *       <p/>
 * @DESCRIPTION
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
