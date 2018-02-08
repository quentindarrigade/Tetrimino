package restController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Le tetrimino n'a pas pu �tre valid�")
public class TetriValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
