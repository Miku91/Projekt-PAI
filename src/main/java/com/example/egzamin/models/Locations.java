package com.example.egzamin.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String Adres;

    @NotNull
    private Long IdKuriera;

    public Locations (String adres, Long idKuriera){
        this.Adres = adres;
        this.IdKuriera = idKuriera;
    }

}
