package utez.edu.mx.PracticaSMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.PracticaSMS.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
