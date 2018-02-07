package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
//	@RequestMapping(value={"/home", "/home/{username}"},method=RequestMethod.GET)
//	public String home(@PathVariable(value="username", required=false) String username, @RequestParam(value="idProduit",defaultValue="12") int idProduit, Model model) {
//	model.addAttribute("utilisateur", username);
//	model.addAttribute("idProduit", idProduit);
//	return "home";
//	}
	
	@GetMapping("/home")
	public String home( Model model) {
		System.out.println("COUCOU !");
	return "home";
	}
}
