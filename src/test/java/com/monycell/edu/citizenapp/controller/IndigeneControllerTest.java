package com.monycell.edu.citizenapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monycell.edu.citizenapp.model.Address;
import com.monycell.edu.citizenapp.model.Contact;
import com.monycell.edu.citizenapp.model.Indigene;
import com.monycell.edu.citizenapp.service.IndigeneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IndigeneController.class)
public class IndigeneControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IndigeneService indigeneService;

    @Test
    public void indigeneListShouldReturnListOfIndigenes() throws Exception {
        List<Indigene> indigeneList = Arrays.asList(new Indigene(new Contact("Chinedu", "Ugwu", 30), new Address()),
                new Indigene(new Contact("Chinedu", "Ugwu", 30), new Address("80 East Rich Street", "43215")),
                new Indigene(new Contact("Blessing", "Ugwu", 30), new Address("N0 4 Adebiyi Street", "042")));

        when(indigeneService.indigeneList()).thenReturn(indigeneList);

        this.mockMvc.perform(get("/all")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(indigeneList)));
    }


    @Test
    public void indigeneListShouldReturnInternalServerErrorOnException() throws Exception {
        Exception e = new Exception("System down");
        when(indigeneService.indigeneList()).thenThrow(e);

        String s = e.getMessage();
        this.mockMvc.perform(get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().json(s));
    }

    private static String asJsonString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
