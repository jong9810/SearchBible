package com.search.bible.repository;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryBibleRepositoryTest {

    BibleRepository bibleRepository = new MemoryBibleRepository();

    @Test
    void getDocNames() {
        //when
        List<String> oldDocEngNames = bibleRepository.getDocEngNames("OLD");
        List<String> oldDocKorNames = bibleRepository.getDocKorNames("OLD");
        List<String> newDocEngNames = bibleRepository.getDocEngNames("NEW");
        List<String> newDocKorNames = bibleRepository.getDocKorNames("NEW");
        List<String> docEngNamesAll = bibleRepository.getDocEngNamesAll();
        List<String> docKorNamesAll = bibleRepository.getDocKorNamesAll();

        //then
        assertThat(oldDocEngNames.size()).isEqualTo(39);
        assertThat(oldDocEngNames).containsExactly(
                "ge", "exo", "lev", "num", "deu", "josh", "jdgs", "ruth", "1sm", "2sm", "1ki", "2ki",
                "1chr", "2chr", "ezra", "neh", "est", "job", "psa", "prv", "eccl", "ssol", "isa", "jer",
                "lam", "eze", "dan", "hos", "joel", "amos", "obad", "jonah", "mic", "nahum", "hab", "zep",
                "hag", "zec", "mal"
        );

        assertThat(oldDocKorNames.size()).isEqualTo(39);
        assertThat(oldDocKorNames).containsExactly(
                "창세기", "출애굽기", "레위기", "민수기", "신명기", "여호수아", "사사기", "룻기", "사무엘상", "사무엘하",
                "열왕기상", "열왕기하", "역대상", "역대하", "에스라", "느헤미야", "에스더", "욥기", "시편", "잠언", "전도서",
                "아가", "이사야", "예레미야", "예레미야애가", "에스겔", "다니엘", "호세아", "요엘", "아모스", "오바댜",
                "요나", "미가", "나훔", "하박국", "스바냐", "학개", "스가랴", "말라기"
        );

        assertThat(newDocEngNames.size()).isEqualTo(27);
        assertThat(newDocEngNames).containsExactly(
                "mat", "mark", "luke", "john", "acts", "rom", "1cor", "2cor", "gal", "eph", "phi", "col",
                "1th", "2th", "1tim", "2tim", "titus", "phmn", "heb", "jas", "1pet", "2pet", "1jn", "2jn", "3jn",
                "jude", "rev"
        );

        assertThat(newDocKorNames.size()).isEqualTo(27);
        assertThat(newDocKorNames).containsExactly(
                "마태복음", "마가복음", "누가복음", "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서", "갈라디아서",
                "에베소서", "빌립보서", "골로새서", "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서", "디도서",
                "빌레몬서", "히브리서", "야고보서", "베드로전서", "베드로후서", "요한1서", "요한2서", "요한3서", "유다서",
                "요한계시록"
        );

        assertThat(docEngNamesAll.size()).isEqualTo(66);
        assertThat(docEngNamesAll).containsExactly(
                "ge", "exo", "lev", "num", "deu", "josh", "jdgs", "ruth", "1sm", "2sm", "1ki", "2ki",
                "1chr", "2chr", "ezra", "neh", "est", "job", "psa", "prv", "eccl", "ssol", "isa", "jer",
                "lam", "eze", "dan", "hos", "joel", "amos", "obad", "jonah", "mic", "nahum", "hab", "zep",
                "hag", "zec", "mal", "mat", "mark", "luke", "john", "acts", "rom", "1cor", "2cor", "gal", "eph",
                "phi", "col", "1th", "2th", "1tim", "2tim", "titus", "phmn", "heb", "jas", "1pet", "2pet", "1jn",
                "2jn", "3jn", "jude", "rev"
        );

        assertThat(docKorNamesAll.size()).isEqualTo(66);
        assertThat(docKorNamesAll).containsExactly(
                "창세기", "출애굽기", "레위기", "민수기", "신명기", "여호수아", "사사기", "룻기", "사무엘상", "사무엘하",
                "열왕기상", "열왕기하", "역대상", "역대하", "에스라", "느헤미야", "에스더", "욥기", "시편", "잠언", "전도서",
                "아가", "이사야", "예레미야", "예레미야애가", "에스겔", "다니엘", "호세아", "요엘", "아모스", "오바댜",
                "요나", "미가", "나훔", "하박국", "스바냐", "학개", "스가랴", "말라기", "마태복음", "마가복음", "누가복음",
                "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서", "갈라디아서", "에베소서", "빌립보서", "골로새서",
                "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서", "디도서", "빌레몬서", "히브리서", "야고보서",
                "베드로전서", "베드로후서", "요한1서", "요한2서", "요한3서", "유다서", "요한계시록"
        );
    }

    @Test
    void getDocMaxChapter() {
        //given
        Optional<Integer> docMaxChapter1 = bibleRepository.getDocMaxChapter("OLD", "ge");
        Optional<Integer> docMaxChapter2 = bibleRepository.getDocMaxChapter("OLD", "jdgs");
        Optional<Integer> docMaxChapter3 = bibleRepository.getDocMaxChapter("OLD", "neh");
        Optional<Integer> docMaxChapter4 = bibleRepository.getDocMaxChapter("OLD", "psa");
        Optional<Integer> docMaxChapter5 = bibleRepository.getDocMaxChapter("OLD", "mal");

        Optional<Integer> docMaxChapter6 = bibleRepository.getDocMaxChapter("NEW", "mat");
        Optional<Integer> docMaxChapter7 = bibleRepository.getDocMaxChapter("NEW", "acts");
        Optional<Integer> docMaxChapter8 = bibleRepository.getDocMaxChapter("NEW", "phi");
        Optional<Integer> docMaxChapter9 = bibleRepository.getDocMaxChapter("NEW", "phmn");
        Optional<Integer> docMaxChapter10 = bibleRepository.getDocMaxChapter("NEW", "rev");

        Optional<Integer> docMaxChapter11 = bibleRepository.getDocMaxChapter("OLD", "rev");
        Optional<Integer> docMaxChapter12 = bibleRepository.getDocMaxChapter("NEW", "ge");
        Optional<Integer> docMaxChapter13 = bibleRepository.getDocMaxChapter("old", "ge");
        Optional<Integer> docMaxChapter14 = bibleRepository.getDocMaxChapter("New", "rev");
        Optional<Integer> docMaxChapter15 = bibleRepository.getDocMaxChapter("OLD", "rsdgfdfev");
        Optional<Integer> docMaxChapter16 = bibleRepository.getDocMaxChapter("NEW", "rsdgfdfev");
        Optional<Integer> docMaxChapter17 = bibleRepository.getDocMaxChapter("Ndhn", "rev");
        Optional<Integer> docMaxChapter18 = bibleRepository.getDocMaxChapter("Ndhn", "rdfev");

        //then
        assertThat(docMaxChapter1.orElseThrow()).isEqualTo(50);
        assertThat(docMaxChapter2.orElseThrow()).isEqualTo(21);
        assertThat(docMaxChapter3.orElseThrow()).isEqualTo(13);
        assertThat(docMaxChapter4.orElseThrow()).isEqualTo(150);
        assertThat(docMaxChapter5.orElseThrow()).isEqualTo(4);

        assertThat(docMaxChapter6.orElseThrow()).isEqualTo(28);
        assertThat(docMaxChapter7.orElseThrow()).isEqualTo(28);
        assertThat(docMaxChapter8.orElseThrow()).isEqualTo(4);
        assertThat(docMaxChapter9.orElseThrow()).isEqualTo(1);
        assertThat(docMaxChapter10.orElseThrow()).isEqualTo(22);

        assertThat(docMaxChapter11).isEqualTo(Optional.empty());
        assertThat(docMaxChapter12).isEqualTo(Optional.empty());
        assertThat(docMaxChapter13).isEqualTo(Optional.empty());
        assertThat(docMaxChapter14).isEqualTo(Optional.empty());
        assertThat(docMaxChapter15).isEqualTo(Optional.empty());
        assertThat(docMaxChapter16).isEqualTo(Optional.empty());
        assertThat(docMaxChapter17).isEqualTo(Optional.empty());
        assertThat(docMaxChapter18).isEqualTo(Optional.empty());
    }

    @Test
    void getDocChapterMaxVerse() {
        //given
        Optional<Integer> docChapterMaxVerse1 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 1);
        Optional<Integer> docChapterMaxVerse2 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 33);
        Optional<Integer> docChapterMaxVerse3 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 77);
        Optional<Integer> docChapterMaxVerse4 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 126);
        Optional<Integer> docChapterMaxVerse5 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 150);

        Optional<Integer> docChapterMaxVerse6 = bibleRepository.getDocChapterMaxVerse("NEW", "acts", 1);
        Optional<Integer> docChapterMaxVerse7 = bibleRepository.getDocChapterMaxVerse("NEW", "acts", 7);
        Optional<Integer> docChapterMaxVerse8 = bibleRepository.getDocChapterMaxVerse("NEW", "acts", 15);
        Optional<Integer> docChapterMaxVerse9 = bibleRepository.getDocChapterMaxVerse("NEW", "acts", 20);
        Optional<Integer> docChapterMaxVerse10 = bibleRepository.getDocChapterMaxVerse("NEW", "acts", 28);

        Optional<Integer> docChapterMaxVerse11 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 0);
        Optional<Integer> docChapterMaxVerse12 = bibleRepository.getDocChapterMaxVerse("OLD", "psa", 151);
        Optional<Integer> docChapterMaxVerse13 = bibleRepository.getDocChapterMaxVerse("NEW", "act", 0);
        Optional<Integer> docChapterMaxVerse14 = bibleRepository.getDocChapterMaxVerse("NEW", "act", 22);
        Optional<Integer> docChapterMaxVerse15 = bibleRepository.getDocChapterMaxVerse("OLD", "rev", 1);
        Optional<Integer> docChapterMaxVerse16 = bibleRepository.getDocChapterMaxVerse("NEW", "ge", 1);
        Optional<Integer> docChapterMaxVerse17 = bibleRepository.getDocChapterMaxVerse("OLD", "rsdgfdfev", 1);
        Optional<Integer> docChapterMaxVerse18 = bibleRepository.getDocChapterMaxVerse("NEW", "rsdgfdfev", 1);
        Optional<Integer> docChapterMaxVerse19 = bibleRepository.getDocChapterMaxVerse("Ndhn", "rev", 1);
        Optional<Integer> docChapterMaxVerse20 = bibleRepository.getDocChapterMaxVerse("Ndhn", "rdfev", 1);

        //then
        assertThat(docChapterMaxVerse1.orElseThrow()).isEqualTo(6);
        assertThat(docChapterMaxVerse2.orElseThrow()).isEqualTo(22);
        assertThat(docChapterMaxVerse3.orElseThrow()).isEqualTo(20);
        assertThat(docChapterMaxVerse4.orElseThrow()).isEqualTo(6);
        assertThat(docChapterMaxVerse5.orElseThrow()).isEqualTo(6);

        assertThat(docChapterMaxVerse6.orElseThrow()).isEqualTo(26);
        assertThat(docChapterMaxVerse7.orElseThrow()).isEqualTo(60);
        assertThat(docChapterMaxVerse8.orElseThrow()).isEqualTo(41);
        assertThat(docChapterMaxVerse9.orElseThrow()).isEqualTo(38);
        assertThat(docChapterMaxVerse10.orElseThrow()).isEqualTo(31);

        assertThat(docChapterMaxVerse11).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse12).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse13).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse14).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse15).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse16).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse17).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse18).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse19).isEqualTo(Optional.empty());
        assertThat(docChapterMaxVerse20).isEqualTo(Optional.empty());
    }

    @Test
    void engNameToKorName() {
        //given
        String engName1 = "ge";
        String engName2 = "psa";
        String engName3 = "mal";
        String engName4 = "mat";
        String engName5 = "acts";
        String engName6 = "rev";

        //when
        Optional<String> result1 = bibleRepository.engNameToKorName("OLD", engName1);
        Optional<String> result2 = bibleRepository.engNameToKorName("OLD", engName2);
        Optional<String> result3 = bibleRepository.engNameToKorName("OLD", engName3);
        Optional<String> result4 = bibleRepository.engNameToKorName("NEW", engName4);
        Optional<String> result5 = bibleRepository.engNameToKorName("NEW", engName5);
        Optional<String> result6 = bibleRepository.engNameToKorName("NEW", engName6);

        Optional<String> result7 = bibleRepository.engNameToKorName("NEW", engName1);
        Optional<String> result8 = bibleRepository.engNameToKorName("NEW", engName2);
        Optional<String> result9 = bibleRepository.engNameToKorName("NEW", engName3);
        Optional<String> result10 = bibleRepository.engNameToKorName("OLD", engName4);
        Optional<String> result11 = bibleRepository.engNameToKorName("OLD", engName5);
        Optional<String> result12 = bibleRepository.engNameToKorName("OLD", engName6);

        Optional<String> result13 = bibleRepository.engNameToKorName("new", engName4);
        Optional<String> result14 = bibleRepository.engNameToKorName("old", engName1);
        Optional<String> result15 = bibleRepository.engNameToKorName("new", engName1);
        Optional<String> result16 = bibleRepository.engNameToKorName("old", engName4);
        Optional<String> result17 = bibleRepository.engNameToKorName("sadfgs", engName5);
        Optional<String> result18 = bibleRepository.engNameToKorName("OLD", "sdgfsfdg");
        Optional<String> result19 = bibleRepository.engNameToKorName("sfghs", "sdgfsfdg");

        //then
        assertThat(result1.orElseThrow()).isEqualTo("창세기");
        assertThat(result2.orElseThrow()).isEqualTo("시편");
        assertThat(result3.orElseThrow()).isEqualTo("말라기");
        assertThat(result4.orElseThrow()).isEqualTo("마태복음");
        assertThat(result5.orElseThrow()).isEqualTo("사도행전");
        assertThat(result6.orElseThrow()).isEqualTo("요한계시록");

        assertThat(result7).isEqualTo(Optional.empty());
        assertThat(result8).isEqualTo(Optional.empty());
        assertThat(result9).isEqualTo(Optional.empty());
        assertThat(result10).isEqualTo(Optional.empty());
        assertThat(result11).isEqualTo(Optional.empty());
        assertThat(result12).isEqualTo(Optional.empty());

        assertThat(result13).isEqualTo(Optional.empty());
        assertThat(result14).isEqualTo(Optional.empty());
        assertThat(result15).isEqualTo(Optional.empty());
        assertThat(result16).isEqualTo(Optional.empty());
        assertThat(result17).isEqualTo(Optional.empty());
        assertThat(result18).isEqualTo(Optional.empty());
        assertThat(result19).isEqualTo(Optional.empty());
    }

    @Test
    void korNameToEngName() {
        //given
        String korName1 = "창세기";
        String korName2 = "시편";
        String korName3 = "말라기";
        String korName4 = "마태복음";
        String korName5 = "사도행전";
        String korName6 = "요한계시록";

        //when
        Optional<String> result1 = bibleRepository.korNameToEngName("OLD", korName1);
        Optional<String> result2 = bibleRepository.korNameToEngName("OLD", korName2);
        Optional<String> result3 = bibleRepository.korNameToEngName("OLD", korName3);
        Optional<String> result4 = bibleRepository.korNameToEngName("NEW", korName4);
        Optional<String> result5 = bibleRepository.korNameToEngName("NEW", korName5);
        Optional<String> result6 = bibleRepository.korNameToEngName("NEW", korName6);

        Optional<String> result7 = bibleRepository.korNameToEngName("NEW", korName1);
        Optional<String> result8 = bibleRepository.korNameToEngName("NEW", korName2);
        Optional<String> result9 = bibleRepository.korNameToEngName("NEW", korName3);
        Optional<String> result10 = bibleRepository.korNameToEngName("OLD", korName4);
        Optional<String> result11 = bibleRepository.korNameToEngName("OLD", korName5);
        Optional<String> result12 = bibleRepository.korNameToEngName("OLD", korName6);

        Optional<String> result13 = bibleRepository.korNameToEngName("new", korName4);
        Optional<String> result14 = bibleRepository.korNameToEngName("old", korName1);
        Optional<String> result15 = bibleRepository.korNameToEngName("new", korName1);
        Optional<String> result16 = bibleRepository.korNameToEngName("old", korName4);
        Optional<String> result17 = bibleRepository.korNameToEngName("sadfgs", korName5);
        Optional<String> result18 = bibleRepository.korNameToEngName("OLD", "sdgfsfdg");
        Optional<String> result19 = bibleRepository.korNameToEngName("sfghs", "sdgfsfdg");

        //then
        assertThat(result1.orElseThrow()).isEqualTo("ge");
        assertThat(result2.orElseThrow()).isEqualTo("psa");
        assertThat(result3.orElseThrow()).isEqualTo("mal");
        assertThat(result4.orElseThrow()).isEqualTo("mat");
        assertThat(result5.orElseThrow()).isEqualTo("acts");
        assertThat(result6.orElseThrow()).isEqualTo("rev");

        assertThat(result7).isEqualTo(Optional.empty());
        assertThat(result8).isEqualTo(Optional.empty());
        assertThat(result9).isEqualTo(Optional.empty());
        assertThat(result10).isEqualTo(Optional.empty());
        assertThat(result11).isEqualTo(Optional.empty());
        assertThat(result12).isEqualTo(Optional.empty());

        assertThat(result13).isEqualTo(Optional.empty());
        assertThat(result14).isEqualTo(Optional.empty());
        assertThat(result15).isEqualTo(Optional.empty());
        assertThat(result16).isEqualTo(Optional.empty());
        assertThat(result17).isEqualTo(Optional.empty());
        assertThat(result18).isEqualTo(Optional.empty());
        assertThat(result19).isEqualTo(Optional.empty());
    }

    @Test
    void checkOldNew() {
        //given
        String name1 = "ge";
        String name2 = "psa";
        String name3 = "mal";

        String name4 = "mat";
        String name5 = "1tim";
        String name6 = "rev";

        String name7 = "dsf";
        String name8 = "sdfsadg";

        //when
        String result1 = bibleRepository.checkOldNew(name1);
        String result2 = bibleRepository.checkOldNew(name2);
        String result3 = bibleRepository.checkOldNew(name3);

        String result4 = bibleRepository.checkOldNew(name4);
        String result5 = bibleRepository.checkOldNew(name5);
        String result6 = bibleRepository.checkOldNew(name6);

        String result7 = bibleRepository.checkOldNew(name7);
        String result8 = bibleRepository.checkOldNew(name8);

        //then
        assertThat(result1).isEqualTo("OLD");
        assertThat(result2).isEqualTo("OLD");
        assertThat(result3).isEqualTo("OLD");

        assertThat(result4).isEqualTo("NEW");
        assertThat(result5).isEqualTo("NEW");
        assertThat(result6).isEqualTo("NEW");

        assertThat(result7).isNull();
        assertThat(result8).isNull();
    }

}