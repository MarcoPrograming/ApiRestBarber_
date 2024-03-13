package pe.com.sistemabarber.SistemaBarber.service.base;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    T findById(Long id);

    T guardar(T t);

    T actualizar(T t, Long id);

    T  delete(Long id);

}
