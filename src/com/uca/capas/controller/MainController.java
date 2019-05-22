package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;

	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-min" + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll(); //llamando metodo
			log.info("Termino de buscar en la base de datos");
		}catch(Exception e){
			log.log(Level.SEVERE, "Exception Ocurr", e);
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	public Student searchByCode(int cStudent) {
		Student s = null;
		try {
			s = studentDao.findOne(cStudent);
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	//Buscar estudiante por codigo
	@RequestMapping(value = "/formSearch", method = RequestMethod.POST)
	public ModelAndView formSearch(@RequestParam Integer cStudent) {
		ModelAndView mav = new ModelAndView();
		Student rstudent = null;
		try {
			rstudent = studentDao.findOne(cStudent);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(rstudent == null) {
			mav.addObject("message","The student id you are searching for doesn't exist");
		}else {
		mav.addObject("rstudent",rstudent);
		}
		mav.setViewName("searchresult");

		return mav;
	}
	//Controler que envia de la vista principal al form enviando una nueva instancia de 
	//Student
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav;
	}
	
	
	//Funcion que recibe objeto Student
	//Muestra en el main que el objeto forma parte de la lista ahora
	@RequestMapping(value = "/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		int valor_retorno=0;
		
		try {
			studentDao.guardar(s, s.getcStudent() == null? 1: 0);
		}catch(Exception e){
			log.info("Error:" + e.toString());
		}
		students = studentDao.findAll();
		log.info(valor_retorno+"");
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
		
	//Presento nuevo form con valores existentes
	@RequestMapping(value = "/formUpdate/{cStudent}")
	public ModelAndView formUpdate(@PathVariable int cStudent) {
		ModelAndView mav = new ModelAndView();
		Student rstudent =  null;
		try {
			rstudent = studentDao.findOne(cStudent);
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("student",rstudent);
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping(value = "/delete/{cStudent}")
	public ModelAndView delete(@PathVariable int cStudent) {
		ModelAndView mav = new ModelAndView();
		Student s = null;
		List<Student> students = null;
		try {
			s = studentDao.findOne(cStudent);
			studentDao.delete(s); 
			log.info("Elimino un usuario");
		}catch(Exception e){
			log.info("Error:" + e.toString());
		}
		//se manda nueva lista que deberia mostrar sin el usario eliminado
		students = studentDao.findAll(); 
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
}