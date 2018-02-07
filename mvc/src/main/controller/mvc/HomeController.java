package mvc;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/home")
public class HomeController {

	@GetMapping(value={ "","/{username}"})
	public String home(@PathVariable(required=false) String username, @RequestParam(required=false, defaultValue="0") int idProduit, Model model) {
		
	model.addAttribute("username", username);
	model.addAttribute("idProduit", idProduit);
	return "home";
	}
	
	}

