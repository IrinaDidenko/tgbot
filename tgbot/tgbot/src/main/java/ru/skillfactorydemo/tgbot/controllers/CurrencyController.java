package ru.skillfactorydemo.tgbot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;
import ru.skillfactorydemo.tgbot.service.StatsService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @GetMapping("/getCurrencies")

    @Operation(operationId = "Получение курсов всех валют на текущий день")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getStatsIncome")
    @Operation(operationId = "получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncome(@RequestParam(value = "amount") BigDecimal amount ){
        return statsService.getCountOfIncomesThatGreaterThan(amount);
    }

    @GetMapping("/getStatsSpend")
    @Operation(operationId = "получение количества трат, которые превышают определенную сумму")
    public int getStatsAboutSpend(@RequestParam(value = "amount") BigDecimal amount ){
        return statsService.getCountOfSpendThatGreaterThan(amount);
    }
}