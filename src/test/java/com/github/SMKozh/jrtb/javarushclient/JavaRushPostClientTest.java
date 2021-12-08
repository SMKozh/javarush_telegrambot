package com.github.SMKozh.jrtb.javarushclient;

import com.github.SMKozh.jrtb.javarushclient.dto.PostInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.SMKozh.jrtb.javarushclient.JavaRushGroupClientTest.JAVARUSH_API_PATH;

@DisplayName("Integration-level testing for JavaRushPostClient")
public class JavaRushPostClientTest {
    private final JavaRushPostClient postClient = new JavaRushPostClientImpl(JAVARUSH_API_PATH);

    @Test
    public void shouldProperlyGetNew15Posts() {
        //when
        List<PostInfo> newPosts = postClient.findNewPosts(30, 2935);

        //then
        Assertions.assertEquals(15, newPosts.size());
    }
}
