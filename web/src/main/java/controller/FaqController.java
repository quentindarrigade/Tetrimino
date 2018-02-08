package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IFAQDAO;
import model.ModelFAQ;

@Controller
public class FaqController {

	// @RequestMapping(value={"/home",
	// "/home/{username}"},method=RequestMethod.GET)
	// public String home(@PathVariable(value="username", required=false) String
	// username, @RequestParam(value="idProduit",defaultValue="12") int
	// idProduit, Model model) {
	// model.addAttribute("utilisateur", username);
	// model.addAttribute("idProduit", idProduit);
	// return "home";
	// }

	@Autowired
	private IFAQDAO daoFaq;

	@GetMapping("/faq")
	public String liste(Model model) {
		model.addAttribute("faqAttribute", daoFaq.findAll());
		return "faq";
	}

	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		model.addAttribute("faqAttribute", new ModelFAQ());
		return "faqEdition";
	}

/*	@PostMapping("/ajouter")
	public String ajouter(@ModelAttribute("faq") ModelFAQ faq, Model model) {
		System.out.println("test");
		System.out.println(faq);
		
		//daoFaq.save(faq);
		return "redirect:./faq";
	}*/
	
	@PostMapping("/ajouter")
	public String ajouter(@Valid @ModelAttribute("faqAttribute") ModelFAQ faq, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "faqEdition";
		}
		daoFaq.save(faq);
		return "redirect:./faq";
	}

	/*
	 * @PostMapping("/ajouter") public String
	 * ajouter(@Valid @ModelAttribute("listeFaq") ModelFAQ faq,BindingResult
	 * result, Model model) { if(result.hasErrors()) {
	 * //model.addAttribute("fournisseurs", daoFournisseur.findAll()); return
	 * "faqEdition"; } daoFaq.save(faq); return "redirect:./faq"; }
	 */

	@GetMapping("/editer")
	public String editer(@RequestParam("id") int id, Model model) {
		model.addAttribute("faqAttribute", daoFaq.findById(id).get());
		return "faqEdition";
	}

	@PostMapping("/editer")
	public String editer(@Valid @ModelAttribute("faqAttribute") ModelFAQ faq, BindingResult result, @RequestParam("id") int id,
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			//model.addAttribute("faq", daoFaq.findAll());
			return "faqEdition";
		}
		daoFaq.save(faq);
		return "redirect:./faq";
	}

	@GetMapping("/supprimer")
	public String supprimer(@RequestParam("id") int id) {
		daoFaq.deleteById(id);

		return "redirect:./faq";
	}

}
