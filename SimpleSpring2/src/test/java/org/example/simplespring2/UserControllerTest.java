package org.example.simplespring2;

import org.example.simplespring2.controller.UserController;
import org.example.simplespring2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testAddUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .param("name", "John Doe")
                        .param("email", "john.doe@example.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }
}
