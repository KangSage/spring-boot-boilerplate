package com.boilerplate.springboot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter // getter 자동 생성
@MappedSuperclass // 자식 클래스에서 이 클래스의 필드를 컬럼으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 기능을 포함 시킨다
public abstract class BaseDateEntity implements Serializable {

  @CreatedDate // 생성일
  private LocalDateTime createdDate;

  @LastModifiedDate // 수정일
  private LocalDateTime modifiedDate;

}
