package restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IPartieDAO;
import model.ModelPartie;

@RestController
@RequestMapping("/score")
public class ScoreRestController {

	@Autowired
	private IPartieDAO daoPartie;

	@GetMapping("/{id}")
	public int findById(@PathVariable("id") int id){
		return (int) this.daoPartie.findById(id).get().getScore();
	}
}
