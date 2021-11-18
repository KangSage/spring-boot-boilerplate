package com.boilerplate.springboot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.springframework.test.web.servlet.MvcResult;

public class MockMvcUtil {
  /**
   * MvcResult 객체에서 constents Jackson ObjectMapper를 사용해서 Map으로 파싱
   * @param mvcResult MockMvc 실행 결과를 담은 객체
   * @return JSON을 K:V로 파싱해서 Map으로 리턴한다.
   * @throws UnsupportedEncodingException getContentAsString 실행 도중 인코딩 실패 시 발생
   * @throws JsonProcessingException JSON 처리 실패 시 발생
   */
  private Map<String, Object> parseJsonToMap(MvcResult mvcResult, ObjectMapper objectMapper)
      throws UnsupportedEncodingException, JsonProcessingException {

    String jsonString = mvcResult.getResponse().getContentAsString();

    return objectMapper.readValue(jsonString,
      new TypeReference<>() {});
  }
}
