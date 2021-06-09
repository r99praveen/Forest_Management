package com.cg.fms.services;

import java.util.List;

import com.cg.fms.entities.Scheduler;
import com.cg.fms.exception.InvalidSchedulerException;

public interface ISchedulerservice {
	public Scheduler getScheduler(int schedulerId) throws InvalidSchedulerException;

	public long updateScheduler(Scheduler scheduler);

	public void delScheduler(int schedulerId) throws InvalidSchedulerException;

	List<Scheduler> getAllSchedulers(int schedulerId);

	public Scheduler addScheduler(Scheduler scheduler);
}
