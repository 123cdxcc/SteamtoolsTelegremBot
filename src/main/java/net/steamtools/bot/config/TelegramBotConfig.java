package net.steamtools.bot.config;

import net.steamtools.bot.service.Bot;
import net.steamtools.bot.entity.SpringTelegramConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
public class TelegramBotConfig {

    @Autowired
    SpringTelegramConfig telegramConfig;

    @Bean
    public Bot bot() {
        DefaultBotOptions options = new DefaultBotOptions();
        if (!telegramConfig.getProxy().getHost().isEmpty() && telegramConfig.getProxy().getPort() != null){
            options.setProxyHost(telegramConfig.getProxy().getHost());
            options.setProxyPort(telegramConfig.getProxy().getPort());
            options.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        }
        return new Bot(telegramConfig.getBot().getUsername(), telegramConfig.getBot().getToken(), options);
    }

}
