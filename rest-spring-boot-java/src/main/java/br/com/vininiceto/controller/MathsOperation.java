package br.com.vininiceto.controller;


import br.com.vininiceto.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathsOperation {

    @Autowired
    OperationsService service;

    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        return service.mathSum(num1,num2);
    }

    @RequestMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        return service.mathSub(num1,num2);
    }

    @RequestMapping("/mult/{num1}/{num2}")
    public Double mult(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        return service.mathMult(num1,num2);
    }

    @RequestMapping("/div/{num1}/{num2}")
    public Double div(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        return service.mathDiv(num1,num2);
    }

    @RequestMapping("/media/{num1}/{num2}")
    public Double media(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        return service.mathMedia(num1,num2);
    }

    @RequestMapping("/quadrangular/{num1}")
    public Double quadrangular(@PathVariable("num1") String num1) {
        return service.mathSqu(num1);
    }




}
