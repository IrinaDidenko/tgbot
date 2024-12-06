package ru.skillfactorydemo.tgbot.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@RequiredArgsConstructor
public class BotService extends TelegramLongPollingBot {


    private final CentralRussianBankService centralRussianBankService;

    @Value("${bot.api.key}")
    private String apiKey;

    @Value("${bot.name}")
    private String botName;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage(); //Этой строчкой мы получаем сообщение от пользователя
        try {
            SendMessage response = new SendMessage(); //Данный класс представляет собой реализацию команды отправки сообщения, которую за нас выполнит ранее подключенная библиотека
            Long chatId = message.getChatId(); //ID чата, в который необходимо отправить ответ
            response.setChatId(String.valueOf(chatId)); //Устанавливаем ID, полученный из предыдущего этап сюда, чтобы сообщить, в какой чат необходимо отправить сообщение

            //Тут начинается самое интересное - мы сравниваем, что прислал пользователь, и какие команды мы можем обработать. Пока что у нас только одна команда
            if ("/currentrates".equalsIgnoreCase(message.getText())) {
//Получаем все курсы валют на текущий момент и проходимся по ним в цикле
                for (ValuteCursOnDate valuteCursOnDate : centralRussianBankService.getCurrenciesFromCbr()) {
//В данной строчке мы собираем наше текстовое сообщение
//StringUtils.defaultBlank – это метод из библиотеки Apache Commons, который нам нужен для того, чтобы на первой итерации нашего цикла была вставлена пустая строка вместо null, а на следующих итерациях не перетерся текст, полученный из предыдущих итерации. Подключение библиотеки см. ниже
                    response.setText(StringUtils.defaultIfBlank(response.getText(), "") + valuteCursOnDate.getName() + " - " + valuteCursOnDate.getCourse() + "\n");
                }
            }
            //Теперь мы сообщаем, что пора бы и ответ отправлять
            execute(response);
            //Ниже очень примитивная обработка исключений, чуть позже мы это поправим
        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostConstruct
    public void start() {
        log.info("username: {}, token: {}", botName, apiKey);
    }


    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return apiKey;
    }
}