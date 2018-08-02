package com.capgemini.scheduler.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.scheduler.beans.CourseList;
import com.capgemini.scheduler.daoservices.ITrainingDAO;
//Service Implementation
@Component(value="schedulerservices")
public class TrainingServiceImpl implements ITrainingService {

	@Autowired
	private ITrainingDAO daoServices;

	@Transactional
	@Override
	public List<CourseList> getdetails() {
		List<CourseList> clist= daoServices.findAll();//All the list of courses are fetched from the database and is sent to the controller for mapping
		return clist;
	}
}
