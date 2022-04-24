package com.example.cepproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FreteResourceTest {

    public static final String LOGRADOURO = "logradouro";
    public static final String PRACA_DA_SE = "Praça da Sé";
    public static final String CEP = "01001000";
    public static final String VALUE = "value";
    public static final int ONCE_NOT_NEGATIVE = -1;

    @Test
    void shouldReturnExceptedNonNegativeLogradouroHashcode(){
        CepService mockCepService = mock(CepService.class);
        Map<String, String> mockCepServiceReturn = new HashMap<>();
        mockCepServiceReturn.put(LOGRADOURO, PRACA_DA_SE);

        doReturn(mockCepServiceReturn)
                .when(mockCepService)
                .getCep(CEP);

        FreteResource cepResource = new FreteResource(mockCepService);
        Map<String, String> cep = cepResource.getCep(CEP);
        String expectedValue = String.valueOf(PRACA_DA_SE.hashCode() * ONCE_NOT_NEGATIVE);
        Assertions.assertEquals(expectedValue, cep.get(VALUE));
    }
}