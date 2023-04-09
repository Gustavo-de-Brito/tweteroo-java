package com.tweteroo.api.models;

import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true ,length = 30, nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;

  public User(UserDTO user) {
    this.username = user.username();
    this.avatar = user.avatar();
  }
}
