package com.walking.techie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISHER")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"book"})
public class Publisher {
    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "PUBLISHER_NAME")
    private String name;

    @OneToOne(mappedBy = "publisher")
    private Book book;

    public Publisher(String code, String name) {
        this.code = code;
        this.name = name;
    }
}