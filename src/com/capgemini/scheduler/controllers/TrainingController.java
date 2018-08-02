package com.capgemini.scheduler.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.scheduler.beans.CourseList;
import com.capgemini.scheduler.exception.NoDataException;
import com.capgemini.scheduler.services.ITrainingService;
//Controller for mapping the required web pages

@Controller
public class TrainingController {

	@Autowired(required=true)
	ITrainingService service;
	
	//Mapping to Load the home page of the webapp when it is requested.
	@RequestMapping("/")
	public ModelAndView getIndexPage() {
		try {	
		List<CourseList>clist=service.getdetails();
		//Exception is thrown when there are no courses available in the database table to be listed (i.e) the table is created but it is empty without values
		if(clist.size()==0)
			throw new NoDataException("No Courses Scheduled Yet...");//List of sessions are fetched from the database
		ModelAndView modelAndView = new ModelAndView("ScheduledSessions", "course", clist);	//The sessions list is mapped with the homepage of the webapp to list all the courses.
		return modelAndView;
		}
		 catch (NoDataException e) {
			 ModelAndView modelAndView = new ModelAndView("error", "exception", e.getMessage());
				return modelAndView;
		 }
	}
	
	//Mapping to load the success page of the webapp when the user enrolls for a particular course.
	@RequestMapping(value="/enroll",method=RequestMethod.POST)
public ModelAndView getUpdate(@RequestParam("name") String name) { 	//@Requestparam is used to request the course name in which the user enrolls which are listed in the home page.
			
		ModelAndView modelAndView = new ModelAndView("Success", "name", name);
			return modelAndView;
	}

}
