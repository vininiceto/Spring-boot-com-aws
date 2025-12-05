package br.com.vininiceto.ioc_di;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MeuComponent {

    public String chamarMeuComponent(){
        return "Chamando meu component";
    }


}
