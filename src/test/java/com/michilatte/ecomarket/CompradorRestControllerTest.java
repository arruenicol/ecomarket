package com.michilatte.ecomarket;

import com.michilatte.ecomarket.api.CompradorRestController;
import com.michilatte.ecomarket.service.CompradorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompradorRestController.class)
public class CompradorRestControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockitoBean
    private CompradorServiceImpl compradorService;
    @Test
    public void solicitudListaDeProductoDeboObtener200 () throws Exception {
        mvc.perform(get("/api/compradores/lista"))
                .andExpect(status().isOk());
    }
}