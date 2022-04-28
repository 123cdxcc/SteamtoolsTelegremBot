package net.steamtools.bot.config;

import lombok.extern.log4j.Log4j2;
import net.steamtools.bot.service.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@Log4j2
public class SpringbootConfig {

    @Autowired
    Bot bot;

    @Bean
    public TelegramBotsApi telegramBotApi() {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return botsApi;
    }

}
