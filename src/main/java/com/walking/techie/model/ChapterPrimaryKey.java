package com.walking.techie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"book"})
public class ChapterPrimaryKey implements Serializable {
    @Column(name = "CHAPTER_NUM")
    private Integer chapterNumber;

    @ManyToOne
    @JoinColumn(name = "BOOK_ISBN")
    private Book book;
}
