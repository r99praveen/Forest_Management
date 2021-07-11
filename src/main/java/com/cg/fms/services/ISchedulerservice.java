package com.cg.fms.services;

import java.util.List;

import com.cg.fms.entities.Scheduler;

import com.cg.fms.exception.SchedulerNotFoundExcption;

public interface ISchedulerservice {
	
	 Scheduler fetchById(Integer schedulerId) throws SchedulerNotFoundExcption;

	 void updateScheduler(Scheduler scheduler);

	 void delScheduler(int schedulerId) throws   SchedulerNotFoundExcption;

	  Scheduler addScheduler(Scheduler scheduler);
	
	 List<Scheduler> fetchAll();
}