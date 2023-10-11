package unam.diplomado.pixup.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.domain.Disco;
import unam.diplomado.pixup.domain.DiscoExistsException;
import unam.diplomado.pixup.service.DiscoService;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;


    @Override
    public Response altaDisco(Disco disco) {
       try {
           Disco discoCreado = discoService.registrarDisco(disco);
           return Response
                   .status(Response.Status.CREATED)
                   .entity(discoCreado)
                   .build();
       }catch (DiscoExistsException e) {
              return Response
                     .status(Response.Status.CONFLICT)
                     .entity(null)
                     .build();
       }catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(null)
                    .build();
       }

    }
}
