package com.testing.bddblog.ServicesImpl;

import com.testing.bddblog.core.Client;
import com.testing.bddblog.repors.ClientRepository;
import com.testing.bddblog.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) { clientRepository.save(client); }

    @Override
    public Optional<Client> update(Client client) {
        return Optional.of(clientRepository.save(client));
    }

    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> finClientByPhone(String phone) {
        return clientRepository.findClientByPhone(phone);
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }
}
