package com.example.ecommerce.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long, ClienteRepository> implements ClienteService {
    @Autowired
    public ClienteRepository repo;
    @Autowired
    public ClienteServiceImpl(ClienteRepository repository) {
        super(repository);

    }

    @Override
      public Cliente findByUsuario(String usuario) {
        return  this.repo.findByUsuario(usuario);
    }
}
