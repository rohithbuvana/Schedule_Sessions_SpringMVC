package com.capgemini.scheduler.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.scheduler.beans.CourseList;
//DAO Service Interface
public interface ITrainingDAO extends JpaRepository<CourseList, Integer> {

}
