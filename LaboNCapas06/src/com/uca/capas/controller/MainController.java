package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain(){
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
		 students = studentDao.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = "/formSearch", method = RequestMethod.POST)
	public ModelAndView formSearch(@RequestParam Integer studentCode) {
		ModelAndView mav = new ModelAndView();
		Student studentresult = null;
		try {
			studentresult = studentDao.findOne(studentCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(studentresult == null) {
			mav.addObject("message","El id del estudiante ingresado no existe");
		}else {
		mav.addObject("studentresult",studentresult);
		}
		mav.setViewName("searchresult");

		return mav;
	}

}