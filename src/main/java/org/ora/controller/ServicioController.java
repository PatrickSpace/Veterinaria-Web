package org.ora.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.ora.entity.Servicio;
import org.ora.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("servicios")
public class ServicioController {

	@Autowired
	private IServicioService seS;

	private boolean nuevo;

	@RequestMapping("/list")
	public String listar(Model model) {
		model.addAttribute("listServicios", seS.listar());
		model.addAttribute("servicio", new Servicio());
		return "servicio/listServicio";
	}

	@RequestMapping("/find")
	public String buscarnombre(Map<String, Object> model, @ModelAttribute Servicio serv) throws ParseException {
		List<Servicio> list = new ArrayList<Servicio>();
		if (serv.getNombreServicio() == "" || serv.getNombreServicio() == null) {
			model.put("listServicios", seS.listar());
		} else {
			list = seS.listarXnombre(serv.getNombreServicio());
			if (list.isEmpty()) {
				model.put("vacio", "No hay Servicios con este nombre");
			} else {
				model.put("listServicios",list);
			}
		}
		return "servicio/listServicio";
	}

	@RequestMapping("/new")
	public String newServ(Model model) {
		model.addAttribute("servicio", new Servicio());
		model.addAttribute("titulo","Nuevo servicio");
		this.setNuevo(true);
		return "servicio/servicio";
	}

	@RequestMapping("/update/{id}")
	public String update(Model model, @PathVariable(value = "id") Long id) {
		Servicio serv = seS.buscarServicio(id);
		model.addAttribute("servicio", serv);
		this.setNuevo(false);
		model.addAttribute("titulo","Actualizar servicio");
		return "servicio/servicio";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value = "id") Long id, RedirectAttributes flash) {
		
		try {
			if (id != null && id > 0) {
				seS.eliminar(id);
				flash.addFlashAttribute("mensaje", "Se eliminó correctamente");
				return "redirect:/servicios/list";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			flash.addFlashAttribute("error",
					"No se puede eliminar, asegurese de que el servicio no este siendo usada. Si este servicio ha sido usado en alguna cita, no se podrá eliminar, intente modificarlo");
			return "redirect:/servicios/list";
		}
		return "redirect:/servicios/list";

	}

	@PostMapping("/save")
	public String save(@Valid Servicio serv, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) throws Exception {

		if (result.hasErrors()) {
			return "servicio/servicio";
		} else {
			int rpta = seS.insert(serv,this.nuevo);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe un Servicio con el nombre a registrar");
				return "servicio/servicio";
			} else {
				flash.addFlashAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}

		return "redirect:/servicios/list";
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

}
