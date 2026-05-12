package com.creditCardValidator.controller;

import com.creditCardValidator.pojo.CardRequest;
import com.creditCardValidator.pojo.CardResponse;
import com.creditCardValidator.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/validate")
    public ResponseEntity<CardResponse> validate(@RequestBody CardRequest request) {
        return ResponseEntity.ok(cardService.validateCard(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<CardResponse> validates() {
        System.out.println("success");
        return ResponseEntity.ok(new CardResponse(true,"fjks","fdjs"));
    }
}