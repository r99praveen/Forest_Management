package com.cg.fms.services;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.InvalidSchedulerException;
import com.cg.fms.entities.Scheduler;
import com.cg.fms.repository.OrderRepository;
import com.cg.fms.repository.SchedulerRepository;

import org.slf4j.LoggerFactory;

@Service
public class SchedulerServiceImpl implements ISchedulerservice{
	
	Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);
	
	@Autowired
	private SchedulerRepository repository;// repository is a dependency of ProductServiceImpl

	
	@Override
	public Scheduler getScheduler(int schedulerId) throws InvalidSchedulerException {
		Optional<Scheduler> scheduler = repository.findById(schedulerId);
		if (!scheduler.isPresent())
			throw new InvalidSchedulerException();
		return scheduler.get();
	}
	

	@Override
	public Scheduler addScheduler(Scheduler scheduler) {
		logger.info("inside addscheduler method of schedulerServiceImpl");
		return repository.save(scheduler);
	}
	

	
	@Override
	public long updateScheduler(Scheduler scheduler) {
		Scheduler sc = repository.save(scheduler);
		return 0;
	}
	
	
	// deleting a product
	
	@Override
	public void delScheduler(int schedulerId) throws InvalidSchedulerException {
		Optional<Scheduler> scheduler = repository.findById(schedulerId);
		if (!scheduler.isPresent())
			throw new InvalidSchedulerException();

		repository.findById(schedulerId);
	}


	@Override
	public List<Scheduler> getAllSchedulers(int schedulerId) {
		return repository.findAll();
	}
		



}
