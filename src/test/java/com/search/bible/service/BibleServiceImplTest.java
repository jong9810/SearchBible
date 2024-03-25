package com.search.bible.service;

import com.search.bible.dto.BiblePrevNextBtnDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BibleServiceImplTest {

    @Autowired
    BibleService bibleService;

    /*@Test
    void getPrevCurNextDocChapterVerseInfo() {
        //given
        String curDocName1 = "ge";
        Integer curChapter1 = 1;

        String curDocName2 = "ge";
        Integer curChapter2 = 50;

        String curDocName3 = "mal";
        Integer curChapter3 = 1;

        String curDocName4 = "mal";
        Integer curChapter4 = 4;

        String curDocName5 = "mat";
        Integer curChapter5 = 1;

        String curDocName6 = "mat";
        Integer curChapter6 = 28;

        String curDocName7 = "rev";
        Integer curChapter7 = 1;

        String curDocName8 = "rev";
        Integer curChapter8 = 22;

        String curDocName9 = "ge";
        Integer curChapter9 = 0;

        String curDocName10 = "ge";
        Integer curChapter10 = 51;

        String curDocName11 = "rev";
        Integer curChapter11 = 0;

        String curDocName12 = "rev";
        Integer curChapter12 = 23;

        //when
        BiblePrevNextBtnDto result1 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName1, curChapter1);
        BiblePrevNextBtnDto result2 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName2, curChapter2);
        BiblePrevNextBtnDto result3 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName3, curChapter3);
        BiblePrevNextBtnDto result4 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName4, curChapter4);
        BiblePrevNextBtnDto result5 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName5, curChapter5);
        BiblePrevNextBtnDto result6 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName6, curChapter6);
        BiblePrevNextBtnDto result7 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName7, curChapter7);
        BiblePrevNextBtnDto result8 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName8, curChapter8);

        BiblePrevNextBtnDto result9 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName9, curChapter9);
        BiblePrevNextBtnDto result10 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName10, curChapter10);
        BiblePrevNextBtnDto result11 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName11, curChapter11);
        BiblePrevNextBtnDto result12 = bibleService.getPrevCurNextDocChapterVerseInfo(curDocName12, curChapter12);

        //then
        assertThat(result1.getPrevDocName()).isEqualTo("");
        assertThat(result1.getPrevDocMaxChapter()).isEqualTo(0);
        assertThat(result1.getPrevChapterMaxVerse()).isEqualTo(0);
        assertThat(result1.getCurDocMaxChapter()).isEqualTo(50);
        assertThat(result1.getCurChapterMaxVerse()).isEqualTo(31);
        assertThat(result1.getNextDocName()).isEqualTo("exo");

        assertThat(result2.getPrevDocName()).isEqualTo("");
        assertThat(result2.getPrevDocMaxChapter()).isEqualTo(0);
        assertThat(result2.getPrevChapterMaxVerse()).isEqualTo(33);
        assertThat(result2.getCurDocMaxChapter()).isEqualTo(50);
        assertThat(result2.getCurChapterMaxVerse()).isEqualTo(26);
        assertThat(result2.getNextDocName()).isEqualTo("exo");

        assertThat(result3.getPrevDocName()).isEqualTo("zec");
        assertThat(result3.getPrevDocMaxChapter()).isEqualTo(14);
        assertThat(result3.getPrevChapterMaxVerse()).isEqualTo(21);
        assertThat(result3.getCurDocMaxChapter()).isEqualTo(4);
        assertThat(result3.getCurChapterMaxVerse()).isEqualTo(14);
        assertThat(result3.getNextDocName()).isEqualTo("mat");

        assertThat(result4.getPrevDocName()).isEqualTo("zec");
        assertThat(result4.getPrevDocMaxChapter()).isEqualTo(14);
        assertThat(result4.getPrevChapterMaxVerse()).isEqualTo(18);
        assertThat(result4.getCurDocMaxChapter()).isEqualTo(4);
        assertThat(result4.getCurChapterMaxVerse()).isEqualTo(6);
        assertThat(result4.getNextDocName()).isEqualTo("mat");

        assertThat(result5.getPrevDocName()).isEqualTo("mal");
        assertThat(result5.getPrevDocMaxChapter()).isEqualTo(4);
        assertThat(result5.getPrevChapterMaxVerse()).isEqualTo(6);
        assertThat(result5.getCurDocMaxChapter()).isEqualTo(28);
        assertThat(result5.getCurChapterMaxVerse()).isEqualTo(25);
        assertThat(result5.getNextDocName()).isEqualTo("mark");

        assertThat(result6.getPrevDocName()).isEqualTo("mal");
        assertThat(result6.getPrevDocMaxChapter()).isEqualTo(4);
        assertThat(result6.getPrevChapterMaxVerse()).isEqualTo(66);
        assertThat(result6.getCurDocMaxChapter()).isEqualTo(28);
        assertThat(result6.getCurChapterMaxVerse()).isEqualTo(20);
        assertThat(result6.getNextDocName()).isEqualTo("mark");

        assertThat(result7.getPrevDocName()).isEqualTo("jude");
        assertThat(result7.getPrevDocMaxChapter()).isEqualTo(1);
        assertThat(result7.getPrevChapterMaxVerse()).isEqualTo(25);
        assertThat(result7.getCurDocMaxChapter()).isEqualTo(22);
        assertThat(result7.getCurChapterMaxVerse()).isEqualTo(20);
        assertThat(result7.getNextDocName()).isEqualTo("");

        assertThat(result8.getPrevDocName()).isEqualTo("jude");
        assertThat(result8.getPrevDocMaxChapter()).isEqualTo(1);
        assertThat(result8.getPrevChapterMaxVerse()).isEqualTo(27);
        assertThat(result8.getCurDocMaxChapter()).isEqualTo(22);
        assertThat(result8.getCurChapterMaxVerse()).isEqualTo(21);
        assertThat(result8.getNextDocName()).isEqualTo("");

        assertThat(result9.getPrevDocName()).isEqualTo("");
        assertThat(result9.getPrevDocMaxChapter()).isEqualTo(0);
        assertThat(result9.getPrevChapterMaxVerse()).isEqualTo(0);
        assertThat(result9.getCurDocMaxChapter()).isEqualTo(50);
        assertThat(result9.getCurChapterMaxVerse()).isEqualTo(0);
        assertThat(result9.getNextDocName()).isEqualTo("exo");
    }*/



}