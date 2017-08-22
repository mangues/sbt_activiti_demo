package com.eadydb.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eadydb.boot.entity.TaskRepresentation;
import com.eadydb.boot.service.ActivitiService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE Aug 22, 2017 11:53:31 AM
 *       <p/>
 * @DESCRIPTION
 */
@RestController
@Slf4j
public class EntryProcessRestController {

	@Autowired
	private ActivitiService activitiService;

	@GetMapping("/process/{personId}/{compId}")
	public void startProcessInstance(@PathVariable Long personId, @PathVariable Long compId) {
		log.info("开启流程实例,personId={},compId={}", personId, compId);
		activitiService.startProccess(personId, compId);
	}

	@GetMapping("/tasks")
	public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
		log.info("获取当前人任务,assignee={}", assignee);
		List<Task> tasks = activitiService.getTasks(assignee);
		List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
		tasks.forEach(task -> dtos.add(new TaskRepresentation(task.getId(), task.getName())));
		return dtos;
	}

	@GetMapping("/complete/{joinApproved}/{taskId}")
	public String complete(@PathVariable Boolean joinApproved, @PathVariable String taskId) {
		log.info("完成任务,joinApproved={},taskId={}", joinApproved, taskId);
		activitiService.completeTask(joinApproved, taskId);
		return "Ok";
	}

}
