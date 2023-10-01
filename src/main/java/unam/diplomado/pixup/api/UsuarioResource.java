package unam.diplomado.pixup.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.domain.Domicilio;
import unam.diplomado.pixup.domain.Usuario;
import unam.diplomado.pixup.service.UsuarioService;

public class UsuarioResource implements UsuarioApi {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public Response registrarUsuario(Domicilio domicilio) {
        try {
            Usuario usuarioCreado =
                    usuarioService.registrarUsuario(domicilio.getUsuario(), domicilio);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(usuarioCreado)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(null)
                    .build();
        }
    }

}