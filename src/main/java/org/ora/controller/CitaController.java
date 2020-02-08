package org.ora.controller;

import org.ora.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private  ICitaService cS;
	
	@RequestMapping("/list")
	public String listar(Model model)
	{
		model.addAttribute("listCitaHoy",cS.listarCitasHoy());
		model.addAttribute("listCitaNext",cS.listarCitasNext());
		model.addAttribute("listCitas",cS.listar());
		return "cita/listCita";
	}
	
	
	

}
