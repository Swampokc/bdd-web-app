package com.testing.bddblog.repors;

import com.testing.bddblog.core.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findClientByPhone(String phone);
}
