package com.arun.sims.service;

import com.arun.sims.model.Client;
import com.arun.sims.repository.ClientJpaRepository;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    private final ClientJpaRepository ClientJpaRepository;

    PasswordEncoder bCryptPasswordEncoder;


    public ClientService(  PasswordEncoder bCryptPasswordEncoder, ClientJpaRepository ClientJpaRepository) {
        this.ClientJpaRepository = ClientJpaRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    public void createClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        Client currClient=getClientByPhoneNumber(client.getPhoneNumber());
        if(Objects.isNull(currClient)) {
            ClientJpaRepository.save(client);
            return;
        }
        throw  new IllegalArgumentException("User already Exist");
    }

    public List<Client> getAllClients() {
        return ClientJpaRepository.findAll();
    }

    public Client getClientById(Long id) {
        return ClientJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void updateClient(Long id, Client updatedClient) {
        Client client = getClientById(id);
        if(Objects.isNull(client)){
            throw new RuntimeException("Client not found");
        }

        client.setRoles(updatedClient.getRoles());
        client.setAge(updatedClient.getAge());
        client.setEmail(updatedClient.getEmail());
        client.setPhoneNumber(updatedClient.getPhoneNumber());
        client.setUsername((updatedClient.getUsername()));
        ClientJpaRepository.save(client);
    }

    public void deleteClient(Long id) {
        ClientJpaRepository.deleteById(id);
    }


    public Client getClientByPhoneNumber(@Size( min = 10 , max = 10) String phoneNumber) {
        return ClientJpaRepository.getClientByPhoneNumber(phoneNumber);
    }
}