package net.steamtools.bot.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Log4j2
public class MessageService {

    @Autowired
    Bot bot;

    public boolean sendTextMessage(String toId, String text) {
        if (toId.isEmpty() || text.isEmpty()) return false;
        SendMessage message = new SendMessage();
        message.setChatId(toId);
        message.setText(text);
        try {
            bot.execute(message);
            log.debug("给id" + toId + "发送消息成功,消息内容：" + text.substring(0, Math.min(text.length(), 15)));
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

}
