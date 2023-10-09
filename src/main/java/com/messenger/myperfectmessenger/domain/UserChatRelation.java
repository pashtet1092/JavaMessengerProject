package com.messenger.myperfectmessenger.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity(name = "l_users_chats")
@Data
public class UserChatRelation {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "l_users_chats_id_seq", allocationSize = 1)//для нерандомных id а по sequence
    @GeneratedValue(generator = "mySeqGen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    private Chat chat;


}
