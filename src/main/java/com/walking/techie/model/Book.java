package com.walking.techie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "BOOK_NAME")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PUBLISHER_CODE")
    private Publisher publisher;

    @OneToMany(mappedBy = "chapterPrimaryKey.book", cascade = CascadeType.PERSIST)
    private List<Chapter> chapters;

    public Book(String isbn, String name, Publisher publisher, List<Chapter> chapters) {
        this.isbn = isbn;
        this.name = name;
        this.publisher = publisher;
        this.chapters = chapters;
    }
}