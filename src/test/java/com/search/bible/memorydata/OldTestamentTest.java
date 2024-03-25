package com.search.bible.memorydata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OldTestamentTest {

    OldTestament oldTestament = new OldTestament();

    @Test
    void oldTestamentTest() {
        //then
        assertThat(oldTestament.getEngNameList().size()).isEqualTo(39);
        assertThat(oldTestament.getEngNameList()).containsExactly(
                "ge", "exo", "lev", "num", "deu", "josh", "jdgs", "ruth", "1sm", "2sm", "1ki", "2ki",
                "1chr", "2chr", "ezra", "neh", "est", "job", "psa", "prv", "eccl", "ssol", "isa", "jer", "lam",
                "eze", "dan", "hos", "joel", "amos", "obad", "jonah", "mic", "nahum", "hab", "zep", "hag", "zec", "mal"
        );

        assertThat(oldTestament.getKorNameList().size()).isEqualTo(39);
        assertThat(oldTestament.getKorNameList()).containsExactly(
                "창세기", "출애굽기", "레위기", "민수기", "신명기", "여호수아", "사사기", "룻기", "사무엘상", "사무엘하", 
                "열왕기상", "열왕기하", "역대상", "역대하", "에스라", "느헤미야", "에스더", "욥기", "시편", "잠언", "전도서", "아가",
                "이사야", "예레미야", "예레미야애가", "에스겔", "다니엘", "호세아", "요엘", "아모스", "오바댜", "요나", "미가", 
                "나훔", "하박국", "스바냐", "학개", "스가랴", "말라기"
        );

        assertThat(oldTestament.getMaxChapterList().size()).isEqualTo(39);
        assertThat(oldTestament.getMaxChapterList()).containsExactly(
                50, 40, 27, 36, 34, 24, 21, 4, 31, 24, 22, 25, 29, 36, 10, 13, 10, 42, 150, 31, 12, 8, 66,
                52, 5, 48, 12, 14, 3, 9, 1, 4, 7, 3, 3, 3, 2, 14, 4
        );

        assertThat(oldTestament.getMaxVerse2DimensionArray().length).isEqualTo(39);

        assertThat(oldTestament.getMaxVerse2DimensionArray()[0].length).isEqualTo(50);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[1].length).isEqualTo(40);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[2].length).isEqualTo(27);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[3].length).isEqualTo(36);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[4].length).isEqualTo(34);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[5].length).isEqualTo(24);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[6].length).isEqualTo(21);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[7].length).isEqualTo(4);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[8].length).isEqualTo(31);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[9].length).isEqualTo(24);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[10].length).isEqualTo(22);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[11].length).isEqualTo(25);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[12].length).isEqualTo(29);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[13].length).isEqualTo(36);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[14].length).isEqualTo(10);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[15].length).isEqualTo(13);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[16].length).isEqualTo(10);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[17].length).isEqualTo(42);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[18].length).isEqualTo(150);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[19].length).isEqualTo(31);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[20].length).isEqualTo(12);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[21].length).isEqualTo(8);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[22].length).isEqualTo(66);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[23].length).isEqualTo(52);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[24].length).isEqualTo(5);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[25].length).isEqualTo(48);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[26].length).isEqualTo(12);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[27].length).isEqualTo(14);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[28].length).isEqualTo(3);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[29].length).isEqualTo(9);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[30].length).isEqualTo(1);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[31].length).isEqualTo(4);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[32].length).isEqualTo(7);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[33].length).isEqualTo(3);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[34].length).isEqualTo(3);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[35].length).isEqualTo(3);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[36].length).isEqualTo(2);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[37].length).isEqualTo(14);
        assertThat(oldTestament.getMaxVerse2DimensionArray()[38].length).isEqualTo(4);

        int verseSum = 0;
        for (int[] ints : oldTestament.getMaxVerse2DimensionArray()) {
            for (int i : ints) {
                verseSum += i;
            }
        }
        assertThat(verseSum).isEqualTo(23145);
    }

}