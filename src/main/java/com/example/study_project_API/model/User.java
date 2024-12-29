package com.example.study_project_API.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Users")
public class User extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String userId;
    
    @Column(length = 200)
    private String userPW;
    
    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false, length = 50)
    private String phone;
    
    @Column(length = 255)
    private String nickname;

    @Builder
    public User(String userId, String userPW, String email, String phone, String nickname) {
        this.userId = userId;
        this.userPW = userPW;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
    }
}