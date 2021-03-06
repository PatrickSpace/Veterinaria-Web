package org.ora.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.ora.entity.Cliente;
import org.ora.service.IClienteService;
import org.ora.service.IMascotaService;
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
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService dS;

	@Autowired
	private IMascotaService mS;

	boolean nuevo = true;

	@RequestMapping("/list/nombre")
	public String listar(Model model) {
		Integer busqueda = 0;
		model.addAttribute("listCliente", dS.listar());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("busqueda", busqueda);
		return "cliente/listCliente";
	}
	
	@RequestMapping("/list/dni")
	public String listardni(Model model) {
		Integer busqueda = 0;
		model.addAttribute("listCliente", dS.listar());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("busqueda", busqueda);
		return "cliente/listClienteDNI";
	}

	@RequestMapping("/find/nombre")
	public String buscarnombre(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		List<Cliente> list = new ArrayList<Cliente>();
		if (cliente.getName() == "" || cliente.getName() == null) {
			model.put("listCliente", dS.listar());
		} else {
			list = dS.listarXnombre(cliente.getName());
			if (list.isEmpty()) {
				model.put("vacio", "No hay Clientes con este nombre");
			} else {
				model.put("listCliente", dS.listarXnombre(cliente.getName()));
			}
		}
		return "cliente/listCliente";
	}

	@RequestMapping("/find/dni")
	public String buscardni(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		List<Cliente> list = new ArrayList<Cliente>();
		if (cliente.getDni() == "" || cliente.getDni() == null) {
			model.put("listCliente", dS.listar());
		} else {
			list = dS.listarXdni(cliente.getDni());
			if (list.isEmpty()) {
				model.put("vacio", "No hay Clientes con este DNI");
			} else {
				model.put("listCliente", dS.listarXdni(cliente.getDni()));
			}
		}
		return "cliente/listClienteDNI";
	}

	@RequestMapping("/new")
	public String irnew(Model model) {
		model.addAttribute("cliente", new Cliente());
		this.nuevo = true;
		return "cliente/cliente";
	}

	@RequestMapping("/update/{id}")
	public String actualizar(Model model, @PathVariable Long id) {
		model.addAttribute("cliente", dS.getCliente(id));
		this.nuevo = false;
		return "cliente/cliente";
	}

	@RequestMapping("/ver/{id}")
	public String ver(Model model, @PathVariable Long id) {
		model.addAttribute("cliente", dS.getCliente(id));
		model.addAttribute("perros", mS.listarPerroXCliente(id));
		model.addAttribute("gatos", mS.listarGatoXCliente(id));
		return "cliente/detalle";
	}

	@PostMapping("/save")
	public String save(@Valid Cliente cli, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) throws Exception {
		String ret = "";
		if (result.hasErrors()) {
			return "cliente/cliente";
		} else {
			int rpta = dS.insert(cli,this.nuevo);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe un Dueño con el DNI a registrar");
				return "cliente/cliente";
			} else {
				flash.addFlashAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		ret = "redirect:/clientes/ver/" + cli.getIdCliente().toString();
		return ret;
	}

	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String ret = "redirect:/clientes/ver/" + id;
		try {
			if (id != null && id > 0) {
				dS.eliminar(id);
				flash.addFlashAttribute("mensaje", "Se eliminó correctamente");
				ret = "redirect:/clientes/list";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			flash.addFlashAttribute("error",
					"No se puede eliminar, asegurese de elimnar antes las mascotas de este cliente");
			ret = "redirect:/clientes/ver/" + id;
		}
		return ret;

	}

}
