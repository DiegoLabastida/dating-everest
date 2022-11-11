package com.everest.dating.models.entity;

import com.everest.dating.models.converter.HobbiesConverter;
import com.everest.dating.models.converter.ProfileTypeConverter;
import com.everest.dating.models.enums.ProfileType;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tbl_profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First Name Name may not be NULL")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "First Name Name may not be NULL")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Profession may not be NULL")
    private String profession;

    private int balance;

    @NotNull
    @Convert(converter = ProfileTypeConverter.class)
    private ProfileType type;

    @OneToOne(optional = true, fetch = FetchType.LAZY, targetEntity = User.class)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ProfileType getType() {
        return type;
    }

    public void setType(ProfileType type) {
        this.type = type;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }
}
