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
import br.com.everton.sbpay.StatusPagamento;

@RestController
public class SBPayService {

    private static final String AUT_TOKEN = "r2d2";

    @PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> pagar(@RequestHeader("Token") String token, //
                                                 @Valid @RequestBody DadosCartao dadosCartao, //
                                                 Errors errors) {

        if (!AUT_TOKEN.equals(token)) {
            return ResponseEntity.badRequest().body(new PaymentResponse("Token inválido"));
        }

        if (errors.hasErrors()) {
            return ResponseEntity.ok(new PaymentResponse(StatusPagamento.CartaoInvalido));
        }

        String numCartao = dadosCartao.getNumCartao();

        StatusPagamento status = numCartao.startsWith("111") ? StatusPagamento.Autorizado : StatusPagamento.NaoAutorizado;

        return ResponseEntity.ok(new PaymentResponse(status));
    }
}
