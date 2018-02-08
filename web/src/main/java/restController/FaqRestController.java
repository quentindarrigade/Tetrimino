package restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IFAQDAO;
import model.ModelFAQ;
import model.ModelPartie;

@RestController
@RequestMapping("/f")
public class FaqRestController {

	@Autowired
	private IFAQDAO daoFaq;

	/*@GetMapping("")
	public ModelPartie getOne() {
		System.out.println("liste one");
		return new ModelPartie();
	}*/
	
	@GetMapping("")
	public List<ModelFAQ> findAll() {
		System.out.println("liste test");
		System.out.println(this.daoFaq.findAll());
		return this.daoFaq.findAll();
	}
}
