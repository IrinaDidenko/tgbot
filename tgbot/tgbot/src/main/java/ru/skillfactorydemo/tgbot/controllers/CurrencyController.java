package ru.skillfactorydemo.tgbot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactorydemo.tgbot.DTO.CentralRussianBankService;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CentralRussianBankService centralRussianBankService;

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCourseOnDate() throws Exception{
        return centralRussianBankService.getCurrenciesFromCbr();
    }
}
