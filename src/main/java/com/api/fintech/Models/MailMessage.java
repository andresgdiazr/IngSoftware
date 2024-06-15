package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mail_messages", schema = "public")
public class MailMessage {
    @Id
    private Integer id;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "header", length = 50)
    private String header;

    @Column(name = "bodymail", length = 100)
    private String bodymail;

    @Column(name = "status", length = 1)
    private String status;

}
