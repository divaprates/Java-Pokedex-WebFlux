package com.study.pokedex.model;

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
public class PokemonEvent {
    
    private Long eventId;
    private String eventType;

}
