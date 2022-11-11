package com.everest.dating.models.entity;

import com.everest.dating.models.converter.HobbiesConverter;
import com.everest.dating.models.converter.StatusConverter;
import com.everest.dating.models.enums.Status;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String terms;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Profile.class)
    private Profile profileClient;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Profile.class)
    private Profile profileContractor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Profile getProfileClient() {
        return profileClient;
    }

    public void setProfileClient(Profile profileClient) {
        this.profileClient = profileClient;
    }

    public Profile getProfileContractor() {
        return profileContractor;
    }

    public void setProfileContractor(Profile profileContractor) {
        this.profileContractor = profileContractor;
    }
}
