package com.messenger.myperfectmessenger.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity(name = "friends_lists")
@Data
@Component
@EqualsAndHashCode(exclude = {"users"})
@ToString(exclude = {"users"})
public class FriendsList {
    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "friends_lists_id_seq", allocationSize = 1)//для нерандомных id а по sequence
    @GeneratedValue(generator = "mySeqGen")
    private Long id;

    @Column(name = "close_friend")
    private Boolean isClose;

    @Column(name = "friends_since")
    private LocalDate friendSince;

    @Column(name = "friend_name")
    private String friendName;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "l_users_friends_lists", joinColumns = @JoinColumn(name = "friend_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users;

}