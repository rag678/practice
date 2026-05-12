package com.creditCardValidator.service;

import com.creditCardValidator.enums.CardType;
import com.creditCardValidator.pojo.CardRequest;
import com.creditCardValidator.pojo.CardResponse;
import com.creditCardValidator.utils.CardUtils;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public CardResponse validateCard(CardRequest request) {
        String number = request.getCardNumber();

        boolean isValid = LuhnValidator.isValid(number);
        CardType type = CardUtils.getCardType(number);

        String masked = mask(number);

        return new CardResponse(isValid, type.name(), masked);
    }

    private String mask(String number) {
        return "*".repeat(number.length() - 4) + number.substring(number.length() - 4);
    }
}