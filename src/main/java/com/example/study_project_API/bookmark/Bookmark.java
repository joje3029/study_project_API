package com.example.study_project_API.bookmark;

import com.example.study_project_API.common.model.BaseEntity;
import com.example.study_project_API.problem.Problem;
import com.example.study_project_API.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Bookmarks")
public class Bookmark extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)// 지연로딩 : 연관 관계.
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problems_id")
    private Problem problem;
    
    @Builder
    public Bookmark(User user, Problem problem) {
        this.user = user;
        this.problem = problem;
    }
}