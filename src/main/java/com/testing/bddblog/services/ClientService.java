package com.testing.bddblog.services;

import com.testing.bddblog.core.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void save(Client client);

    Optional<Client> update(Client client);

    void deleteById(Integer id);

    Iterable<Client> findAll();

    List<Client> finClientByPhone(String phone);

    Optional<Client> findById(Integer id);
}
