package com.example.ecommerce.Cliente;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteControllerImpl extends BaseControllerImpl<Cliente, Long, ClienteServiceImpl> implements
        ClienteController {

    @Autowired
    public ClienteService serv;

    public ClienteControllerImpl(ClienteServiceImpl service) {
        super(service);

    }

    @Override
    @PostMapping("/loguin")
    public ResponseEntity<?> findClienteByUsuario(@RequestBody Cliente cliente) {
        try {
            Cliente cli = this.serv.findByUsuario(cliente.getUsuario());
            if (cliente != null && cli.getPassword().equals(cliente.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(cli);

            } else {
                if (cliente != null && !(cli.getPassword().equals(cliente.getPassword()))) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{Contraseña incorrecta}");

                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{Usuario inexistente}");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error por favor intente mas tarde.\"}");
        }
    }

}
