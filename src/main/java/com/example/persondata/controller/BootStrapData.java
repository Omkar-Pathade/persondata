package com.example.persondata.controller;

import com.example.persondata.model.Address;
import com.example.persondata.model.Person;
import com.example.persondata.repository.AddressRepository;
import com.example.persondata.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public BootStrapData(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Person omkar=new Person("omkar","pathade");
        Address omkarAddress=new Address("7/1,Kailas Housing Society","Ahmednagar","Mah", 414003L);
        omkar.getAddresses().add(omkarAddress);
        omkarAddress.getPersons().add(omkar);

        addressRepository.save(omkarAddress);
        personRepository.save(omkar);

        System.out.println("Data for user: "+personRepository.count());
    }
}
