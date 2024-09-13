package com.csc340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    /**
     * Get a pokemon's id, height, and weight from pokeapi.
     *
     * @param pokemonName
     * @return a Pokemon object.
     */
    @GetMapping("/pokemon")
    public Object getPokemon(@RequestParam(value = "name", defaultValue = "charizard") String pokemonName){
        try{
            String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            Pokemon pokemon = new Pokemon(root.get("name").asText(), root.get("id").asInt(), root.get("height").asInt(),
                root.get("weight").asInt());
            return pokemon;
        } catch (JsonProcessingException ex){
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /pokemon";
        }
    }
}
