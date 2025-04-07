package com.tamizhselvan.pingme.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;



    @Column(name = "department_id")
    private Long departmentId;

    @ManyToMany(mappedBy = "participants")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<ChatRoom> chatRooms = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long createdAt;


    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now().getEpochSecond();
    }

}

