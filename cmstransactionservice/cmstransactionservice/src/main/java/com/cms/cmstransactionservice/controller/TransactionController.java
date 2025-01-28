package com.cms.cmstransactionservice.controller;

import com.cms.cmstransactionservice.DTO.TransactionDto;
import com.cms.cmstransactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction",consumes = "application/json")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    /*@CrossOrigin(origins = "http://localhost:63342") */ // Allow specific origin
    @PostMapping(value = "/points",consumes = "application/json")
    public ResponseEntity<String> processTransaction(@RequestBody TransactionDto transactionDto){
        String response = transactionService.processTransaction(transactionDto);
        return ResponseEntity.ok(response);
    }

}