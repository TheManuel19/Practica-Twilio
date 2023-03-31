package utez.edu.mx.PracticaSMS.service;

import utez.edu.mx.PracticaSMS.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> listar();

    boolean guardar(Usuario usuario);

    Usuario mostrar(long id);

    boolean eliminar(long id);
}
