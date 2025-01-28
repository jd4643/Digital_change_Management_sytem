package com.dcms.cmsApiGateway.controller;


import jakarta.ws.rs.POST;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @PostMapping("/users")
    public Mono<ResponseEntity<String>> userFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("User Service is currently unavailable. Please try again later."));
    }

    @PostMapping("/vendors")
    public Mono<ResponseEntity<String>> vendorFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Vendor Service is currently unavailable. Please try again later."));
    }

    @PostMapping("/transactions")
    public Mono<ResponseEntity<String>> transactionFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Transaction Service is currently unavailable. Please try again later."));
    }
}

