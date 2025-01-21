package ru.skillfactorydemo.tgbot.entity;

import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "SPEND")
public class Spend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "SPEND")
    private BigDecimal spend;

    @Column(name = "DATE")
    @CreationTimestamp
    private Date date;
}
