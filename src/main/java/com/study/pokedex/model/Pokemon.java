package com.study.pokedex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Pokemon {
    
    @Id
    private String id;
    private String nome;
    private String categoria;
    private String habilidade;
    private String peso;
    
    public Pokemon(String id2, String nome2, String categoria2, String habilidade2, double d) {}
    
}
