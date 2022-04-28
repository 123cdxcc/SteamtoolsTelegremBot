package net.steamtools.bot.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageRequest {

    private String toId;
    private String type;
    private Object message;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class TextMessageRequest {
        private String text;
    }

}
