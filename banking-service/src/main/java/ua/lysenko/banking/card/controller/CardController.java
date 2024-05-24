package ua.lysenko.banking.card.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.banking.card.models.CardResponseModel;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.utils.mappers.CardMapper;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new card for user")
    public ResponseEntity<CardResponseModel> createCard(@RequestHeader("Authorization") String authorizationHeader) {

        CardResponseModel createdCard = cardMapper.toCardResponseModel(cardService.createCard(authorizationHeader));
        return ResponseEntity.status(HttpStatus.OK).
                body(createdCard);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get card by id")
    public ResponseEntity<CardResponseModel> getCardById(@RequestHeader("Authorization") String authorizationHeader,
                                                         @PathVariable Long id) {
        CardResponseModel createdCard = cardMapper.toCardResponseModel(cardService.getById(id, authorizationHeader));
        return ResponseEntity.status(HttpStatus.OK).
                body(createdCard);
    }
}
