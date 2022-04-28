package net.steamtools.bot;

import lombok.SneakyThrows;
import net.steamtools.bot.entity.SpringTelegramConfig;
import net.steamtools.bot.service.Bot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootTest
class BotApplicationTests {

    @Autowired
    Bot bot;

    @SneakyThrows
    @Test
    void contextLoads() {
    }

}
