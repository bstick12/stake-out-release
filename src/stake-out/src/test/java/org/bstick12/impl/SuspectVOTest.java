package org.bstick12.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bstick12.api.Suspect;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SuspectVOTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void before() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testJSON() throws IOException {

        Suspect suspect = SuspectVO.create("name", "type", "host");
        String suspectAsString = objectMapper.writeValueAsString(suspect);
        Suspect unmarshalled = objectMapper.readValue(suspectAsString, Suspect.class);
        assertEquals(suspect, unmarshalled);

    }

}