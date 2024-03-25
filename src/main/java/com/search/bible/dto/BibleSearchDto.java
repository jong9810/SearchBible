package com.search.bible.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class BibleSearchDto {

    private String oldNew;
    private String doc;

    private int startChapter;
    private int startVerse;

    private int endChapter;
    private int endVerse;
}
