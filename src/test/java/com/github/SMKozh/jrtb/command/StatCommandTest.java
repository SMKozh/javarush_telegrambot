package com.github.SMKozh.jrtb.command;

import com.github.SMKozh.jrtb.dto.GroupStatDTO;
import com.github.SMKozh.jrtb.dto.StatisticDTO;
import com.github.SMKozh.jrtb.service.SendBotMessageService;
import com.github.SMKozh.jrtb.service.StatisticService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;

import static com.github.SMKozh.jrtb.command.AbstractCommandTest.prepareUpdate;
import static com.github.SMKozh.jrtb.command.CommandName.STAT;
import static com.github.SMKozh.jrtb.command.StatCommand.STAT_MESSAGE;

@DisplayName("Unit-level testing for StatCommand")
public class StatCommandTest{

    private SendBotMessageService sendBotMessageService;
    private StatisticService statisticService;
    private Command statCommand;

    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        statisticService = Mockito.mock(StatisticService.class);
        statCommand = new StatCommand(sendBotMessageService, statisticService);
    }

    @Test
    public void shouldProperlySendMessage() {
        //given
        Long chatId = 1234567L;
        GroupStatDTO groupDTO = new GroupStatDTO(1, "group", 1);
        StatisticDTO statisticDTO = new StatisticDTO(1, 1, Collections.singletonList(groupDTO), 2.5);
        Mockito.when(statisticService.countBotStatistic()).thenReturn(statisticDTO);

        //when
        statCommand.execute(prepareUpdate(chatId, CommandName.STAT.getCommandName()));

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), String.format(STAT_MESSAGE,
                statisticDTO.getActiveUserCount(),
                statisticDTO.getInactiveUserCount(),
                statisticDTO.getAverageGroupCountByUser(),
                String.format("%s (id = %s) - %s подписчиков", groupDTO.getTitle(),groupDTO.getId(), groupDTO.getActiveUserCount())));
    }
}
