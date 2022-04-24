package com.example.cepproject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "cepService", url = "https://viacep.com.br/ws/")
public interface CepService {

    @RequestMapping("/{cep}/json/")
    Map<String, String> getCep(@PathVariable("cep") String cep);
}