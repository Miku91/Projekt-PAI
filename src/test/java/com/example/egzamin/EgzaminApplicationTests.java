package com.example.egzamin;
import com.example.egzamin.models.Locations;
import com.example.egzamin.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

//Autowired
//UsersRepository usersRepository;

@SpringBootTest
class EgzaminApplicationTests{
    @Test // Pokrywanie się użytkowników
    void getReport() {
        Users user3 = new Users(1l, "login1", "haslo1");
        Users user4 = new Users(1l, "login2", "haslo2");

        assertEquals(user3,user4);
        }


    @Test // Sprawdzenie listy lokalizacji
    void KurierPktTest(){
        Users user5 = new Users(1l, "login3", "haslo3");
        Users user6 = new Users(2l, "login4", "haslo4");

        Locations Lokacja1 = new Locations(1l,"Kaliskiego 10A",2l);
        Locations Lokacja2 = new Locations(1l,"Fordońska 10A",2l);

        List<Locations> Lokacje = new ArrayList<>();
        Lokacje.add(Lokacja1);
        Lokacje.add(Lokacja2);

        Locations Lokacja3 = new Locations(1l,"Kaliskiego 10A",2l);
        Locations Lokacja4 = new Locations(1l,"Fordońska 10A",2l);
        List<Locations> Lokacje2 = new  ArrayList<>();
        Lokacje.add(Lokacja3);
        Lokacje.add(Lokacja4);
        assertSame(Lokacje,Lokacje2);

    }
}
