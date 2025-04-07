package com.tamizhselvan.pingme.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Lob
    private String content;

    @Column(name = "time_stamp", nullable = false)
    private Long createdAt;

    @Lob
    @Column(name = "media_data")
    private byte[] mediaData;

    @Column(name = "media_type")
    private String mediaType;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now().getEpochSecond();
    }

}