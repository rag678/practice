package com.creditCardValidator.service;

import com.creditCardValidator.pojo.CardRequest;
import com.creditCardValidator.pojo.CardResponse;

public interface CardService {
    CardResponse validateCard(CardRequest request);
}
