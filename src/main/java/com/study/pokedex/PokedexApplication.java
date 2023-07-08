package com.study.pokedex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.study.pokedex.model.Pokemon;
import com.study.pokedex.repository.PokemonRepository;

import reactor.core.publisher.Flux;

@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@SpringBootApplication
public class PokedexApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ReactiveMongoOperations operations, PokemonRepository repository) {
		return args -> {
			Flux<Pokemon> pokemonFlux = Flux.just(
					new Pokemon(null, "Blastoise", "Marisco", "Torrente", 9.0),
					new Pokemon(null, "Caterpie", "Minhoca", "Poeira do excuto", 2.08),
					new Pokemon(null, "Bulbassauro", "Semente", "Grandeza", 10.0))
					.flatMap(repository::save);

			pokemonFlux
					.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}

}
