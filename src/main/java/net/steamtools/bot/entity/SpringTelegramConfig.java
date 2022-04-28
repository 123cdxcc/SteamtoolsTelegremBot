package net.steamtools.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "telegram")
public class SpringTelegramConfig {
    private Proxy proxy;
    private Bot bot;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Proxy {
        private String host;
        private Integer port;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Bot {
        private String username;
        private String token;
    }
}




