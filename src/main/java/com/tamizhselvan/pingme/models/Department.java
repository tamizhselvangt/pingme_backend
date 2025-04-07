package com.tamizhselvan.pingme.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long createdAt;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<User> users = new ArrayList<>();

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<NoticeBoard> noticeBoard = new ArrayList<>();


    public Department (String name, Timestamp createdAt, List<User> users, List<NoticeBoard> noticeBoard) {
        this.name = name;
        this.createdAt = Instant.now().getEpochSecond();
        this.users = new ArrayList<>(users);
        this.noticeBoard = new ArrayList<>(noticeBoard);
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now().getEpochSecond();
    }

}
