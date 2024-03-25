package com.search.bible.memorydata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NewTestamentTest {

    NewTestament newTestament = new NewTestament();

    @Test
    void newTestamentTest() {
        //then
        assertThat(newTestament.getEngNameList().size()).isEqualTo(27);
        assertThat(newTestament.getEngNameList()).containsExactly(
                "mat", "mark", "luke", "john", "acts", "rom", "1cor", "2cor", "gal", "eph", "phi", "col",
                "1th", "2th", "1tim", "2tim", "titus", "phmn", "heb", "jas", "1pet", "2pet", "1jn", "2jn", "3jn",
                "jude", "rev"
        );

        assertThat(newTestament.getKorNameList().size()).isEqualTo(27);
        assertThat(newTestament.getKorNameList()).containsExactly(
                "마태복음", "마가복음", "누가복음", "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서",
                "갈라디아서", "에베소서", "빌립보서", "골로새서", "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서",
                "디도서", "빌레몬서", "히브리서", "야고보서", "베드로전서", "베드로후서", "요한1서", "요한2서", "요한3서", "유다서",
                "요한계시록"
        );

        assertThat(newTestament.getMaxChapterList().size()).isEqualTo(27);
        assertThat(newTestament.getMaxChapterList()).containsExactly(
                28, 16, 24, 21, 28, 16, 16, 13, 6, 6, 4, 4, 5, 3, 6, 4, 3, 1, 13, 5, 5, 3, 5, 1, 1, 1, 22
        );

        assertThat(newTestament.getMaxVerse2DimensionArray().length).isEqualTo(27);

        assertThat(newTestament.getMaxVerse2DimensionArray()[0].length).isEqualTo(28);
        assertThat(newTestament.getMaxVerse2DimensionArray()[1].length).isEqualTo(16);
        assertThat(newTestament.getMaxVerse2DimensionArray()[2].length).isEqualTo(24);
        assertThat(newTestament.getMaxVerse2DimensionArray()[3].length).isEqualTo(21);
        assertThat(newTestament.getMaxVerse2DimensionArray()[4].length).isEqualTo(28);
        assertThat(newTestament.getMaxVerse2DimensionArray()[5].length).isEqualTo(16);
        assertThat(newTestament.getMaxVerse2DimensionArray()[6].length).isEqualTo(16);
        assertThat(newTestament.getMaxVerse2DimensionArray()[7].length).isEqualTo(13);
        assertThat(newTestament.getMaxVerse2DimensionArray()[8].length).isEqualTo(6);
        assertThat(newTestament.getMaxVerse2DimensionArray()[9].length).isEqualTo(6);
        assertThat(newTestament.getMaxVerse2DimensionArray()[10].length).isEqualTo(4);
        assertThat(newTestament.getMaxVerse2DimensionArray()[11].length).isEqualTo(4);
        assertThat(newTestament.getMaxVerse2DimensionArray()[12].length).isEqualTo(5);
        assertThat(newTestament.getMaxVerse2DimensionArray()[13].length).isEqualTo(3);
        assertThat(newTestament.getMaxVerse2DimensionArray()[14].length).isEqualTo(6);
        assertThat(newTestament.getMaxVerse2DimensionArray()[15].length).isEqualTo(4);
        assertThat(newTestament.getMaxVerse2DimensionArray()[16].length).isEqualTo(3);
        assertThat(newTestament.getMaxVerse2DimensionArray()[17].length).isEqualTo(1);
        assertThat(newTestament.getMaxVerse2DimensionArray()[18].length).isEqualTo(13);
        assertThat(newTestament.getMaxVerse2DimensionArray()[19].length).isEqualTo(5);
        assertThat(newTestament.getMaxVerse2DimensionArray()[20].length).isEqualTo(5);
        assertThat(newTestament.getMaxVerse2DimensionArray()[21].length).isEqualTo(3);
        assertThat(newTestament.getMaxVerse2DimensionArray()[22].length).isEqualTo(5);
        assertThat(newTestament.getMaxVerse2DimensionArray()[23].length).isEqualTo(1);
        assertThat(newTestament.getMaxVerse2DimensionArray()[24].length).isEqualTo(1);
        assertThat(newTestament.getMaxVerse2DimensionArray()[25].length).isEqualTo(1);
        assertThat(newTestament.getMaxVerse2DimensionArray()[26].length).isEqualTo(22);

        int verseSum = 0;
        for (int[] ints : newTestament.getMaxVerse2DimensionArray()) {
            for (int i : ints) {
                verseSum += i;
            }
        }
        assertThat(verseSum).isEqualTo(7957);
    }

}