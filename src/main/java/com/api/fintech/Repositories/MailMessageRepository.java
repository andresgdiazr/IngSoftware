package com.api.fintech.Repositories;

import com.api.fintech.Models.MailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMessageRepository extends JpaRepository<MailMessage, Long> {
}
