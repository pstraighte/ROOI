package com.rooi.rooi.entity;

import com.rooi.rooi.dto.ProfileResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) //이넘 타입 데이터를 주입 USER -> USER 그대로 저장
    private UserRoleEnum role;

    public ProfileResponseDto getMyPage(User user) {
        return new ProfileResponseDto(user);
    }

    public User(String username, String password, String email, String introduce, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.introduce = introduce;
        this.role = role;
    }
}
