package tr.softtech.patika.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import tr.softtech.patika.model.exception.ErrorMessage;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
