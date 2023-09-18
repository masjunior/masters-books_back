package com.example.masters_of_books.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

