package br.com.vininiceto.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id){

        if(id == null){
            return "Primeiro metodo sem id";
        }
        return "O parametro é: " + id;
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody User user){
        return "metodo com body params: " + user.username();
    }

    @PostMapping("/metodoComHeader")
    public String metodoComHeader(@RequestHeader("name") String name){
        return "Metodo com header com name: " + name;
    }

    @PostMapping("/metodoComListHeader")
    public String metodoComHeader(@RequestHeader Map<String, String> headers){
        return "Metodo com header com name: " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro");
    }



    record User(String username){

    }
}
