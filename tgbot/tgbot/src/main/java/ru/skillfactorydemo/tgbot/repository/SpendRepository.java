package ru.skillfactorydemo.tgbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.util.Date;
import java.util.List;

@Repository
public interface SpendRepository extends JpaRepository<Spend, Long> {
    List<Spend> findByDateBetween(Date from, Date to);
}
