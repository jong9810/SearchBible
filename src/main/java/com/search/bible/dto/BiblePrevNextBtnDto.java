package com.search.bible.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BiblePrevNextBtnDto {

    private String prevDocName;
    private Integer prevDocMaxChapter;
    private Integer prevChapterMaxVerse;

    private Integer curDocMaxChapter;
    private Integer curChapterMaxVerse;

    private String nextDocName;
    private Integer nextDocFirstChapterMaxVerse;
    private Integer nextChapterMaxVerse;

    public BiblePrevNextBtnDto(String prevDocName, Integer prevDocMaxChapter, Integer prevChapterMaxVerse, Integer curDocMaxChapter, Integer curChapterMaxVerse, String nextDocName, Integer nextDocFirstChapterMaxVerse, Integer nextChapterMaxVerse) {
        this.prevDocName = prevDocName;
        this.prevDocMaxChapter = prevDocMaxChapter;
        this.prevChapterMaxVerse = prevChapterMaxVerse;
        this.curDocMaxChapter = curDocMaxChapter;
        this.curChapterMaxVerse = curChapterMaxVerse;
        this.nextDocName = nextDocName;
        this.nextDocFirstChapterMaxVerse = nextDocFirstChapterMaxVerse;
        this.nextChapterMaxVerse = nextChapterMaxVerse;
    }
}
