package com.example.cepproject;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FreteResource {

    public static final int ONCE_NOT_NEGATIVE = -1;
    private final CepService cepService;

    public FreteResource(CepService cepService) {
        this.cepService = cepService;
    }

    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public Map<String, String> getCep(@PathVariable String cep) {
        Map<String, String> result = cepService.getCep(cep);
        String logradouro = result.get("logradouro");
        return geraValorFrete(logradouro);
    }

    private Map<String, String> geraValorFrete(String logradouro) {
        Map<String, String> map = new HashMap<>();
        map.put("value", String.valueOf(logradouro.hashCode()* ONCE_NOT_NEGATIVE));
        return map;
    }


}
