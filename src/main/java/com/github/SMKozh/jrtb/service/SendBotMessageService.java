package com.github.SMKozh.jrtb.service;

import java.util.List;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);

    void sendMessage(String chatId, List<String> messages);
}
