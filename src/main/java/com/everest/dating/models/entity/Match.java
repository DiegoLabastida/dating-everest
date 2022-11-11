package com.everest.dating.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_match", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "match_id"})})
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private User match;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public User getMatch() {
        return match;
    }

    public void setMatch(User matchId) {
        this.match = matchId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
