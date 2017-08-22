package com.eadydb.boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ActivitiService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	/**
	 * 开始流程,传入申请者的id以及公司id
	 * 
	 * @param personId
	 *            申请者id
	 * @param compId
	 *            公司id
	 */
	public void startProccess(Long personId, Long compId) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("personId", personId);
		variables.put("compId", compId);
		runtimeService.startProcessInstanceByKey("joinProcess", variables);
	}

	/**
	 * 获取某个人的任务列表
	 * 
	 * @param assignee
	 * @return
	 */
	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskCandidateUser(assignee).list();
	}

	/**
	 * 完成任务
	 * 
	 * @param joinApproved
	 * @param taskId
	 *            任务id
	 */
	public void completeTask(Boolean joinApproved, String taskId) {
		Map<String, Object> taskVariables = new HashMap<>();
		taskVariables.put("joinApproved", joinApproved);
		taskService.complete(taskId, taskVariables);
	}
}
