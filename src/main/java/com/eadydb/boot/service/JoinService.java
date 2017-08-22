package com.eadydb.boot.service;

import java.util.Arrays;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eadydb.boot.entity.Company;
import com.eadydb.boot.entity.Person;
import com.eadydb.boot.repository.CompanyRepository;
import com.eadydb.boot.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 11:25:57 AM
 *       <p/>
 * @DESCRIPTION
 */
@Service
@Slf4j
public class JoinService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CompanyRepository companyRepository;

	/**
	 * 加入公司操作，可以从DelegateExecution获取流程中的变量
	 * 
	 * @param execution
	 */
	public void joinGroup(DelegateExecution execution) {
		Boolean bool = (Boolean) execution.getVariable("joinApproved");
		if (bool) {
			Long personId = (Long) execution.getVariable("personId");
			Long compId = (Long) execution.getVariable("compId");
			Company company = companyRepository.findOne(compId);
			Person person = personRepository.findOne(personId);
			person.setCompany(company);
			personRepository.save(person);
			log.info("加入组织成功!");
		}else {
			log.info("加入组织失败!");
		}
	}
	
	/**
	 * 获取符合条件的审批人
	 * @param execution
	 * @return
	 */
	public List<String> findUsers(DelegateExecution execution) {
		return Arrays.asList("admin","db2");
	}
	
}
