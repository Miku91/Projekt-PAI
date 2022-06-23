package com.example.egzamin.service;

import com.example.egzamin.models.Locations;
import com.example.egzamin.models.Users;
import com.example.egzamin.repository.LocationsRepository;
import com.example.egzamin.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class InitService {

    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    UsersRepository usersRepository;
    @PostConstruct
    private void init() {
        log.info("init");
        Locations destLocation = new Locations("Profesora Sylwestra Kaliskiego 7, 85-796 Bydgoszcz", 7L);
        Locations destLocation2 = new Locations("Generała Władysława Andersa 2, 85-796 Bydgoszcz", 7L);
        Locations destLocation3 = new Locations("Jana Karola Chodkiewicza 30, 85-064 Bydgoszcz", 7L);
        Locations destLocation4 = new Locations("Fordońska 430, 85-790 Bydgoszcz", 8L);
        Locations destLocation5 = new Locations("Wojska Polskiego 1, 85-171 Bydgoszcz", 8L);
        Locations destLocation6 = new Locations("Jagiellońska 39-47, 85-097 Bydgoszcz", 8L);
        locationsRepository.save(destLocation);
        locationsRepository.save(destLocation2);
        locationsRepository.save(destLocation3);
        locationsRepository.save(destLocation4);
        locationsRepository.save(destLocation5);
        locationsRepository.save(destLocation6);
        Users newUser1 = new Users("pracownik1", "pass1");
        Users newUser2 = new Users("pracownik2", "pass2");
        usersRepository.save(newUser1);
        usersRepository.save(newUser2);
    }
}
