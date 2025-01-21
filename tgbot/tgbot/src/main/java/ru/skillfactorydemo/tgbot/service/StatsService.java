package ru.skillfactorydemo.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactorydemo.tgbot.entity.Income;
import ru.skillfactorydemo.tgbot.entity.Spend;
import ru.skillfactorydemo.tgbot.repository.IncomeRepository;
import ru.skillfactorydemo.tgbot.repository.SpendRepository;
import ru.skillfactorydemo.tgbot.repository.StatsRepository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {
    private final StatsRepository statsRepository;
    private final IncomeRepository incomeRepository;
    private final SpendRepository spendRepository;

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount) {
        return  statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }

    public int getCountOfSpendThatGreaterThan(BigDecimal amount) {
        return  statsRepository.getCountOfSpendThatGreaterThan(amount);
    }


    public List<String> getSpendsBetweenDates(Date from, Date to) {
        List<String> result = new ArrayList<>();
        List<Spend> spends = spendRepository.findByDateBetween(from, to);
        for (Spend spend : spends) {
            result.add(new SimpleDateFormat("yyyy-mm-dd").format(spend.getDate()) + ": " +  spend.getSpend());
        }
        return result;
    }
    public List<String> getIncomesBetweenDates(Date from, Date to) {
        List<String> result = new ArrayList<>();
        List<Income> incomes = incomeRepository.findByDateBetween(from, to);
        for (Income income : incomes) {
            result.add(new SimpleDateFormat("yyyy-mm-dd").format(income.getDate()) + ": " +  income.getIncome());
        }
        return result;
    }





}
