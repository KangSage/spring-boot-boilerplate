package com.boilerplate.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@DynamicInsert
public class User extends BaseDateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private char useFlag;

  @Column(nullable = false)
  @Email @NotBlank @NotNull
  private String email;

  @Column(nullable = false)
  @NotBlank @NotNull
  private String password;

}
