package com.cowdog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest extends SpringContainerTest{

    @Test
    @Transactional
    @DisplayName("테스트")
    void getApi() throws Exception {

        mockMvc.perform(get("/cow")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(document("get-groups",
                        PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("success").description("성공 여부"),
                                PayloadDocumentation.fieldWithPath("result.[].id").description("아이디"),
                                PayloadDocumentation.fieldWithPath("result.[].name").description("이름"),
                                PayloadDocumentation.fieldWithPath("result.[].total").description("인원수")
                        )));
    }

}
