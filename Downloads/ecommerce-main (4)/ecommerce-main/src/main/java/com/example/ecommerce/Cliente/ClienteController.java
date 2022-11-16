package com.example.ecommerce.Cliente;

import com.example.ecommerce.Base.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteController extends BaseController<Cliente, Long> {
    public ResponseEntity<?> findClienteByUsuario(@RequestBody Cliente cliente);

}
