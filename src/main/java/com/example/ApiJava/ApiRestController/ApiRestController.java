package com.example.ApiJava.ApiRestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiJava.entity.Pokemon;
import com.example.ApiJava.reposity.PokemonRepository;



@RestController
public class ApiRestController {

    @Autowired
    PokemonRepository pokemonRepository;

       //ajout d'un pokemon
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody Pokemon pokemon) {
 
           if (pokemonRepository.existsByName(pokemon.getName())) {
           return new ResponseEntity<>("ce pokemon existe déja", HttpStatus.BAD_REQUEST);
       }
       Pokemon newpokemon = new Pokemon();

        newpokemon.setName(pokemon.getName());
        newpokemon.setGenre(pokemon.getGenre());
        pokemonRepository.save(newpokemon);
        return  new ResponseEntity<>("pokemon enregistré", HttpStatus.OK);
   } 


   
   @GetMapping("/pokemons")
      public List<Pokemon> getAllPokemons() {
      return pokemonRepository.findAll();
      }

   
   @GetMapping("/pokemon/{name}")
   public Pokemon readPokemon(@PathVariable String name) {
       return pokemonRepository.findByName(name).get();
   }

   
   @PutMapping("/update/{name}")
   public Pokemon updatePokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
       readPokemon(name).setName(pokemon.getName());
       
       return pokemonRepository.save(readPokemon(name));
   }

   
   @GetMapping("/delete/{id}")
   public String deletePokemon(@PathVariable int id) {
       pokemonRepository.deleteById(id);
       return "pokemon supprimé";
   }




    
}
