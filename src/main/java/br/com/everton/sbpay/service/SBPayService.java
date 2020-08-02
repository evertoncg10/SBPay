package br.com.everton.sbpay.service;


import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.everton.sbpay.DadosCartao;
import br.com.everton.sbpay.PaymentResponse;

@RestController
public class SBPayService {

    @PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> pagar(@RequestHeader("Token") String token, //
                                                 @Valid @RequestBody DadosCartao dadosCartao, //
                                                 Errors erros) {

        return null;

    }
}
