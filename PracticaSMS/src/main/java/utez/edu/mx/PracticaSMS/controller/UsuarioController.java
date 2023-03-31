package utez.edu.mx.PracticaSMS.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utez.edu.mx.PracticaSMS.model.Usuario;
import utez.edu.mx.PracticaSMS.service.UsuarioServiceImpl;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    public static final String ACCOUNT_SID = "AC035aa5f0b2a8568337f94738a97198a6";
    public static final String AUTH_TOKEN = "61927011a2b62cc23a7331d00a056d3c";

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping(value = { "/listar"})
    public String listarMascotas(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.listar());

        return "usuarios";
    }

    @GetMapping("/register")
    public String crearUsuario(Usuario usuario, Model model) {

        Usuario usuario1 = new Usuario();
        model.addAttribute("usuarios", usuario1);

        return "registrarUsuario";
    }

    @PostMapping("/register")
    public String guardarUsuario(@ModelAttribute("usuarios") Usuario usuario, Model model,
                                 RedirectAttributes redirectAttributes) {

        usuarioService.guardar(usuario);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(usuario.getTelefono()),
                new PhoneNumber("+15856011228"),
                "Se a registrado correctamente!! :D").create();

        System.out.println(message.getSid());


        model.addAttribute("usuarios", usuarioService.listar());

        return "redirect:/usuarios/listar";
    }

    @GetMapping(value = {"/usuarios/eliminar/{id}"})
    public String eliminarUsuarios(@PathVariable Long id) {

        usuarioService.eliminar(id);

        return "redirect:/usuarios/listar";
    }
}
