package com.clubdemo.club.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@Entity
@Table(name = "clubmember")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = ClubMember.FIND_ALL, query = "select c from ClubMember c"),
        @NamedQuery(name = ClubMember.FIND_BY_ID, query = "select c from ClubMember c where c.id = ?")
})
public class ClubMember {

    public static final String FIND_ALL = "ClubMember.findAll";
    public static final String FIND_BY_ID = "ClubMember.findById";

    @Id
    @GeneratedValue(generator = "idGenerator")
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "book_id")
    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMember clubMember = (ClubMember) o;
        return Objects.equals(id, clubMember.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id='" + id + '\'' +
                ", clubId='" + getClubId() + '\'' +
                ", memberId='" + getMemberId() +
                '}';
    }
}
