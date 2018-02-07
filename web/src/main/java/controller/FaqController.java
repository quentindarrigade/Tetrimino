package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {
	
//	@RequestMapping(value={"/home", "/home/{username}"},method=RequestMethod.GET)
//	public String home(@PathVariable(value="username", required=false) String username, @RequestParam(value="idProduit",defaultValue="12") int idProduit, Model model) {
//	model.addAttribute("utilisateur", username);
//	model.addAttribute("idProduit", idProduit);
//	return "home";
//	}
	
	@GetMapping("/faq")
	public String faq( Model model) {
		System.out.println("faq faq faq faq faq !");
	return "faq";
	}
}
