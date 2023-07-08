package com.study.pokedex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.study.pokedex.model.Pokemon;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String>{
    
}
