package com.example.study_project_API.model;

import jakarta.persistence.Column;
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
@Table(name = "Images")
public class Image extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memo_id")
    private MemorizationNote memorizationNote;
    
    @Column(length = 300)
    private String filePath;
    
    @Column(length = 300)
    private String fileName;
    
    @Builder
    public Image(MemorizationNote memorizationNote, String filePath, String fileName) {
        this.memorizationNote = memorizationNote;
        this.filePath = filePath;
        this.fileName = fileName;
    }
}