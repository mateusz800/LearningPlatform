package controller;

import com.example.configuration.WebSecurityConfig;
import com.example.controller.AuthController;
import com.example.dto.CreateUserDto;
import com.example.exception.UserAlreadyExistsException;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = AuthController.class)
@ContextConfiguration(classes = WebSecurityConfig.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class AuthControllerTest {

    private static ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void registerNewUser() throws Exception {
        CreateUserDto userData = new CreateUserDto("test@test.com", "123123123");
        mockMvc.perform(post("/auth/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userData))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(document("register"));
    }

    @Test
    public void registerUserThatAlreadyExists() throws Exception {
        CreateUserDto userData = new CreateUserDto("test@test.com", "123123123");
        Mockito.doThrow(UserAlreadyExistsException.class).when(userService).createUser(any(CreateUserDto.class));
        mockMvc.perform(post("/auth/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userData))
                .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }
}


