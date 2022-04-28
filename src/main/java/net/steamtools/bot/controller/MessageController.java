package net.steamtools.bot.controller;

import com.google.gson.Gson;
import net.steamtools.bot.entity.request.MessageRequest;
import net.steamtools.bot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
public class MessageController {

    @Autowired
    Gson gson;

    @Autowired
    MessageService messageService;

    @PostMapping("send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest) {
        boolean result = false;
        if ("text".equals(messageRequest.getType())) {
            String json = gson.toJson(messageRequest.getMessage());
            MessageRequest.TextMessageRequest textMessage = gson.fromJson(json, MessageRequest.TextMessageRequest.class);
            result = messageService.sendTextMessage(messageRequest.getToId(), textMessage.getText());
        }
        if (result) return ResponseEntity.ok("发送成功");
        else return ResponseEntity.status(201).body("发送消息失败");
    }
}
