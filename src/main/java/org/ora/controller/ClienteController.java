package org.ora.controller;

import javax.validation.Valid;

import org.ora.entity.Cliente;
import org.ora.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService dS;
	
	
	@RequestMapping("/list")
	public String listar(Model model)
	{
		model.addAttribute("listCliente",dS.listar());
		return "cliente/listCliente";
	}
	
	@RequestMapping("/new")
	public String irnew(Model model)
	{
		model.addAttribute("cliente", new Cliente());
		return "cliente/cliente";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid Cliente cli, BindingResult result, Model model, SessionStatus status,RedirectAttributes flash)
			throws Exception {
		if (result.hasErrors()) {
			return "dueño/dueño";
		} else {
			int rpta = dS.insert(cli);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe un Dueño con el DNI a registrar");
				return "dueño/dueño";
			} else {
				flash.addFlashAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listCliente", dS.listar());

		return "redirect:/clientes/list";
	}
	
	
}
