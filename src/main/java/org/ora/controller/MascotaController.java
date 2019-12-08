package org.ora.controller;

import java.util.Map;

import javax.validation.Valid;

import org.ora.entity.Mascota;
import org.ora.service.IClienteService;
import org.ora.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

	@Autowired
	private IMascotaService mS;

	@Autowired
	private IClienteService cS;

	boolean nuevo = true;

	@RequestMapping("/perros")
	public String listarPerros(Model model) {
		model.addAttribute("listPerros", mS.listarPerros());
		return "mascota/listPerro";
	}

	@RequestMapping("/gatos")
	public String listarGatos(Model model) {
		model.addAttribute("listGatos", mS.listarGatos());
		return "mascota/listGatos";
	}

	@RequestMapping("/new/{isperro}/{id}")
	public String irnew(Model model, @PathVariable(value = "id") Long id,
			@PathVariable(value = "isperro") int isperro) {
		Mascota mascota = new Mascota();
		mascota.setCliente(cS.getCliente(id));
		if (isperro == 1)
			mascota.setIsPerro(true);
		else
			mascota.setIsPerro(false);
		model.addAttribute("mascota", mascota);
		model.addAttribute("listCliente", cS.listar());
		this.nuevo = true;
		return "mascota/mascota";
	}

	@RequestMapping("/update/{id}")
	public String Actualizar(Model model, @PathVariable Long id) {
		model.addAttribute("mascota", mS.getMasota(id));
		model.addAttribute("listCliente", cS.listar());
		this.nuevo = false;
		return "mascota/mascota";
	}

	@RequestMapping("/ver/{id}")
	public String ver(Model model, @PathVariable Long id) {
		model.addAttribute("mascota", mS.getMasota(id));
		return "mascota/detalle";
	}

	@RequestMapping("mascotas/{id}")
	public String verMascotas(Model model, @PathVariable Long id) {

		model.addAttribute("perros", mS.listarPerroXCliente(id));
		model.addAttribute("gatos", mS.listarGatoXCliente(id));
		return "cliente/mascotas";
	}

	@PostMapping("/save")
	public String save(@Valid Mascota mascot, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) throws Exception {
		String ret = "";
		if (result.hasErrors()) {
			ret = "mascota/mascota";
			return ret;
		} else {
			mS.insert(mascot);
			if(this.nuevo==true)
			{
				flash.addFlashAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
				ret = "redirect:/clientes/ver/" + mascot.getCliente().getIdCliente().toString();				
			}
			else
			{
				flash.addFlashAttribute("mensaje", "Se actualizó correctamente");
				status.setComplete();
				ret = "redirect:/mascotas/ver/" + mascot.getIdMascota().toString();
			}
			return ret;
		}
	}

	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String ret = "";
		Mascota mascota = new Mascota();
		try {
			if (id != null && id > 0) {
				mascota = mS.getMasota(id);
				mS.eliminar(id);
				flash.addFlashAttribute("mensaje", "Se eliminó correctamente");
				ret = "redirect:/clientes/ver/" + mascota.getCliente().getIdCliente();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("error", "No se puede eliminar");
			ret = "redirect:/mascotas/ver/" + id;
		}
		return ret;
	}
}
