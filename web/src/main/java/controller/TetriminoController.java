package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ITetriminoDAO;

@Controller
public class TetriminoController {
	
	@Autowired
	private ITetriminoDAO itd;
	
	@RequestMapping(value="/tetriminos/liste", method=RequestMethod.GET)
	public String produits(Model model) {
		model.addAttribute("tetriminos",itd.findAll());
		return("tetriminos");
	}
	@RequestMapping(value="tetriminos/supprimer", method=RequestMethod.GET)
	public String supprimer(@RequestParam(value="idTetrimino") int id) {
		
		itd.deleteById(id);
		return("redirect:tetriminos/liste");
	}
	
	@RequestMapping(value="tetriminos/editer", method=RequestMethod.GET)
	public String editer(@RequestParam(value="idTetrimino") int idTetrimino, Model model) {
		model.addAttribute("tetrimino", itd.findById(idTetrimino).get() );
		return("ajoutTetri");
	}
	
	@RequestMapping(value="tetriminos/ajouter", method=RequestMethod.GET)
	public String ajouter() {
		return("ajoutTetri");
	}
		
	}
