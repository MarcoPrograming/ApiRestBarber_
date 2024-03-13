package pe.com.sistemabarber.SistemaBarber.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFounException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public ResourceNotFounException(String mensaje) {
        super(mensaje);
    }

}
