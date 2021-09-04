package com.boilerplate.springboot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<String> hello(@RequestParam String hello) {
      log.debug("hello: {}", hello);
      return new ResponseEntity<>(hello, HttpStatus.OK);
  }

}
