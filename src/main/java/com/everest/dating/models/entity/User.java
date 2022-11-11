package com.everest.dating.models.entity;

import com.everest.dating.models.converter.GenderConverter;
import com.everest.dating.models.converter.SexualOrientationConverter;
import com.everest.dating.models.enums.Gender;
import com.everest.dating.models.enums.Hobbies;
import com.everest.dating.models.enums.SexualOrientation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Convert;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First Name Name may not be NULL")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last Name may not be NULL")
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotEmpty(message = "Email may not be NULL")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Gender Name may not be NULL")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "sexual_orientation")
    @Convert(converter = SexualOrientationConverter.class)
    private SexualOrientation sexualOrientation;

    @ElementCollection(targetClass = Hobbies.class)
    @JoinTable(name = "tbl_hobbies", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "hobby", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<Hobbies> hobbies;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Match> users;

    @JsonIgnore
    @OneToMany(mappedBy = "match")
    private List<Match> matches;

//    @ManyToMany
//    @JoinTable(name="tbl_matches",
//            joinColumns=@JoinColumn(name="personId"),
//            inverseJoinColumns=@JoinColumn(name="matchId")
//    )
//    private List<User> matches;
//
//    @ManyToMany
//    @JoinTable(name="tbl_matches",
//            joinColumns=@JoinColumn(name="matchId"),
//            inverseJoinColumns=@JoinColumn(name="personId")
//    )
//    private List<User> matchesOf;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public Collection<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Collection<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Match> getUsers() {
        return users;
    }

    public void setUsers(List<Match> userId) {
        this.users = userId;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matchId) {
        this.matches = matchId;
    }

    //    public List<User> getMatches() {
//        return matches;
//    }
//
//    public void setMatches(List<User> matches) {
//        this.matches = matches;
//    }
//
//    public List<User> getMatchesOf() {
//        return matchesOf;
//    }
//
//    public void setMatchesOf(List<User> matchesOf) {
//        this.matchesOf = matchesOf;
//    }
}
