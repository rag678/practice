package com.creditCardValidator.controller;

import com.creditCardValidator.pojo.CardRequest;
import com.creditCardValidator.pojo.CardResponse;
import com.creditCardValidator.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CardService cardService;

    @Test
    void testValidateCardAPI() throws Exception {

        when(cardService.validateCard(any()))
                .thenReturn(new CardResponse(true, "VISA", "************1111"));

        CardRequest request = new CardRequest();
        request.setCardNumber("4111111111111111");

        mockMvc.perform(post("/api/cards/validate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true))
                .andExpect(jsonPath("$.cardType").value("VISA"));
    }
}