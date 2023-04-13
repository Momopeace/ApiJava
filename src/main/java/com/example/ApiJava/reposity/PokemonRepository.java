package com.example.ApiJava.reposity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiJava.entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    Boolean existsByName(String name);
    Boolean existsById(int id);

    Optional<Pokemon> findByName(String name); 
    Optional<Pokemon> findById(int id);

    
}


