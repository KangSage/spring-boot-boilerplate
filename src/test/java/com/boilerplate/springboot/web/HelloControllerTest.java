package com.boilerplate.springboot.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

@Slf4j // logback 자동 설정
@SpringBootTest // Spring Boot 서버 구동해서 테스트 실행
@AutoConfigureMockMvc // 자동 MocKMvc 구성 설정
@ActiveProfiles(profiles = "local") // 테스트 시 사용할 프로파일 yaml 설정 셋팅
class HelloControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void TEST_HELLO() throws Exception {

    // given
    var hello = "안녕하세요.";

    ResultActions resultActions =
      mockMvc.perform(get("/hello")
              .contentType(MediaType.TEXT_PLAIN_VALUE)
              .param("hello", hello));

    // when
    MvcResult mvcResult =
        resultActions.andExpect(status().isOk()).andDo(print()).andReturn();

    var result = mvcResult.getResponse().getContentAsString();

    // then
    log.debug("result: {}", result);
    assertThat(result).isEqualTo(hello);
  }
}
