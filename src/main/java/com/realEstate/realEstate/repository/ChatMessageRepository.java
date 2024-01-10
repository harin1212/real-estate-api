package com.realEstate.realEstate.repository;

import com.realEstate.realEstate.model.entity.Chat.ChatMessage;
import com.realEstate.realEstate.model.entity.Chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
