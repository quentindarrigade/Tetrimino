package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ITetriminoDAO;
import model.ModelTetrimino;

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
		return("redirect:./liste");
	}
	
	@RequestMapping(value="tetriminos/editer", method=RequestMethod.GET)
	public String editer(@RequestParam(value="idTetrimino") int idTetrimino, Model model) {
		model.addAttribute("tetrimino", itd.findById(idTetrimino).get() );
		ModelTetrimino tetri =itd.findById(idTetrimino).get();
		String forme = tetri.getTetrimino00();
		String[] tab = forme.split("/");
		String[][] l2 = new String[tab.length][tab.length];
		
		
		for (int i =0; i< tab.length;i++ ){
			l2[i]=tab[i].split(",");
		}
		
//		for (String [] str:l2) {
//			for(String s: str) {
//				System.out.print( s + ",");
//			}
//			System.out.print("/");
//		}
		model.addAttribute("forme",l2);
		if(tab.length>l2[0].length)
			model.addAttribute("max", tab.length);
		else{
			model.addAttribute("max",l2[0].length);
		}
		return("ajoutTetri");
	}
	
	@RequestMapping(value="tetriminos/ajouter", method=RequestMethod.GET)
	public String formulaire(@RequestParam(value="taille") int taille, Model model) {
		model.addAttribute("max",taille);
		return("ajoutTetri");
	}
	
	@RequestMapping(value="tetriminos/editer", method=RequestMethod.POST)
	public String editer(@RequestParam(value="idTetrimino") int id,@RequestParam(value="nom") String nom,@RequestParam(value="couleur") String couleur,@RequestParam(value="max") int max, HttpServletRequest request ) {
		String forme="";
		
		for (int y=0; y<max; y++) {
			for (int x=0; x<max; x++) {
				if(request.getParameter("box-"+x+"-"+y)==null) {
					forme+="0,";
				}
				else {
					forme+="1,";
				}
			}
			forme+="/";
		}
		System.out.println(forme);
		ModelTetrimino tetri= itd.findById(id).get();
		tetri.setCouleur(couleur);
		tetri.setNom(nom);
		tetri.setTetrimino00(forme);
		itd.save(tetri);
		return"redirect:./liste";
		
	}
	
	@RequestMapping(value="tetriminos/ajouter", method=RequestMethod.POST)
	public String ajouter(@RequestParam(value="nom") String nom,@RequestParam(value="couleur") String couleur,@RequestParam(value="max") int max, HttpServletRequest request ) {
		String forme="";
		
		for (int y=0; y<max; y++) {
			for (int x=0; x<max; x++) {
				if(request.getParameter("box-"+x+"-"+y)==null) {
					forme+="0,";
				}
				else {
					forme+="1,";
				}
			}
			forme+="/";
		}
		System.out.println(forme);
		ModelTetrimino tetri= new ModelTetrimino();
		tetri.setCouleur(couleur);
		tetri.setNom(nom);
		tetri.setTetrimino00(forme);
		itd.save(tetri);
		return"redirect:./liste";
		
	}
	
	@RequestMapping(value="tetriminos/taille", method=RequestMethod.GET)
	public String taille(){
		return"taille";
	}
		
	}
