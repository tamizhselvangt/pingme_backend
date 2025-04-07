package com.tamizhselvan.pingme.models;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ChatNotification {
    private Long id;
    private String senderId;
    private String recipientId;
    private String content;
}
