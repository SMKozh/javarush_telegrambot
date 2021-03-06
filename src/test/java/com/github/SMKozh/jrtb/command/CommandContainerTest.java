package com.github.SMKozh.jrtb.command;

import com.github.SMKozh.jrtb.javarushclient.JavaRushGroupClient;
import com.github.SMKozh.jrtb.service.GroupSubService;
import com.github.SMKozh.jrtb.service.SendBotMessageService;
import com.github.SMKozh.jrtb.service.StatisticService;
import com.github.SMKozh.jrtb.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        JavaRushGroupClient javaRushGroupClient = Mockito.mock(JavaRushGroupClient.class);
        GroupSubService groupSubService = Mockito.mock(GroupSubService.class);
        StatisticService statisticService = Mockito.mock(StatisticService.class);
        commandContainer = new CommandContainer(sendBotMessageService,
                telegramUserService,
                javaRushGroupClient,
                groupSubService,
                Collections.singletonList("username"),
                statisticService
                );
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values()).forEach(commandName -> {Command command = commandContainer.retrieveCommand(commandName.getCommandName(), "username");
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/srtgrgf";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand, "username");

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
