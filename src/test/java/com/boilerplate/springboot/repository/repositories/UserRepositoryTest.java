package com.boilerplate.springboot.repository.repositories;

import com.boilerplate.springboot.entity.User;
import com.boilerplate.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = "h2") // 테스트 시 사용할 프로파일 yaml 설정 셋팅
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

//  @BeforeEach
//  void setUp() {
//  }
//
//  @AfterEach
//  void tearDown() {
//    userRepository.deleteAll();
//  }

  @Test
  void save() {

    User user = new User();
    user.setEmail("wlswlsqud@naver.com");
    user.setUseFlag('Y');
    user.setPassword("dsadasdas");
    var save = userRepository.save(user);
    log.info("save: {}", save);
  }

}
