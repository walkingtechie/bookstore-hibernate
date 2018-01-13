package com.walking.techie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CHAPTER")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Chapter {
    @EmbeddedId
    private ChapterPrimaryKey chapterPrimaryKey;

    @Column(name = "TITLE")
    private String title;

    public Chapter(String title, ChapterPrimaryKey chapterPrimaryKey) {
        this.title = title;
        this.chapterPrimaryKey = chapterPrimaryKey;
    }
}