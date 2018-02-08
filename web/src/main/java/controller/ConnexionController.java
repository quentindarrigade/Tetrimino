package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IAdminDAO;
import model.ModelAdmin;

@Controller
public class ConnexionController {
	
	@Autowired
	private IAdminDAO iad;
	
	@RequestMapping(value="/connexion", method=RequestMethod.GET)
	public String home( Model model) {
		System.out.println("connexion");
	return "connexion";
	}
	
	
	
	@RequestMapping(value="/connexion", method=RequestMethod.POST)
	public String connecter(@RequestParam(value="login") String username, @RequestParam(value="password") String password, HttpSession session) {
		ModelAdmin admin=iad.authAdmin(username,password);
		if(admin!=null) {
			session.setAttribute("admin", admin);
			System.out.println(admin);
			return "redirect:./home";
		}
		else {
			System.out.println("La connexion a échoué");
			return "connexion";
		}
		
	}
	
	
}