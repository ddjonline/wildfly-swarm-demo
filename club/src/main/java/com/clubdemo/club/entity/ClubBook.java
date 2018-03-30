package com.clubdemo.club.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@Entity
@Table(name = "clubbooks")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = ClubBook.FIND_ALL, query = "select c from ClubBook c"),
        @NamedQuery(name = ClubBook.FIND_BY_ID, query = "select c from ClubBook c where c.id = ?")
})
public class ClubBook {

    public static final String FIND_ALL = "ClubBook.findAll";
    public static final String FIND_BY_ID = "ClubBook.findById";

    @Id
    @GeneratedValue(generator = "idGenerator")
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "book_id")
    private Long bookId;

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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubBook clubBook = (ClubBook) o;
        return Objects.equals(id, clubBook.id);
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
                ", bookId='" + getBookId() +
                '}';
    }
}
