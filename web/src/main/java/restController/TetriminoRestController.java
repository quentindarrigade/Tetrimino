package restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IFAQDAO;
import dao.ITetriminoDAO;
import model.ModelFAQ;
import model.ModelTetrimino;

@RestController
@RequestMapping("/tetri")
public class TetriminoRestController {

	@Autowired
	private ITetriminoDAO daoTetrimino;

	@GetMapping("/{id}")
	public String findById(@PathVariable("id") int id){
		return this.daoTetrimino.findById(id).get().getNom();
	}
	
	@GetMapping("")
	public List<ModelTetrimino> findAll() {
		System.out.println("liste tetrimino");
		System.out.println(this.daoTetrimino.findAll());
		return this.daoTetrimino.findAll();
	}


	@PostMapping("")
	public ModelTetrimino add(@RequestBody ModelTetrimino tetri, BindingResult result) {
		if (result.hasErrors()) {
			throw new TetriValidationException();
		}
		System.out.println(tetri);
		System.out.println("Nom "+tetri.getNom()+", Couleur: "+tetri.getCouleur()+" , Forme 0: "+tetri.getTetrimino00());
		this.daoTetrimino.save(tetri);
		return tetri;
	}
}
