package com.onebit.microservicio.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage() throws Exception {
        String message = "Hola desde el test";
        mockMvc.perform(post("/api/message")
                        .content(message))
                .andExpect(status().isOk());
    }
}
