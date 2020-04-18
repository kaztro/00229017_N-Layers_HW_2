package com.uca.layers._NLayers_HW_2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/student")
	public @ResponseBody String student() {
		String student = "German Castro, carné numero: 00229017, estudio Ing. Informática y he cursado 3 años estoy en el cuarto.";
		return student;
	}
	
	@RequestMapping("/params")
	public @ResponseBody String params(HttpServletRequest request) {
		String dateFromParams = request.getParameter("dia")+
				"/"+request.getParameter("mes")+
				"/"+request.getParameter("año");
		String response = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date actualD = null;
		 
		try {
			 actualD = dateFormat.parse(dateFromParams);
		} catch (ParseException e) {
			System.err.println("F, No he podido parsear la fecha que me diste xd");
			e.printStackTrace();
		}
		 
		GregorianCalendar calendarD = new GregorianCalendar();
		calendarD.setTime(actualD);
		 
		int weekDay = calendarD.get(Calendar.DAY_OF_WEEK);
		response = weekDay(weekDay);
		return "El día de la semana según la fecha dada es: " + response;
}
	
	public String weekDay(int n) {
		String day = "";
		switch(n) {
			case 1:
				day = "Domingo";
				break;
			case 2:
				day = "Lunes";
				break;
			case 3:
				day = "Martes";
				break;
			case 4:
				day = "Miercoles";
				break;
			case 5:
				day = "Jueves";
				break;
			case 6:
				day = "Viernes";
				break;
			case 7:
				day = "Sabado";
				break;
			default:
				day = "Big F";
				break;
		} return day;
	}
	
}
