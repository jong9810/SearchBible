package com.search.bible.service;

import com.search.bible.dto.BiblePrevNextBtnDto;
import com.search.bible.repository.BibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibleServiceImpl implements BibleService{

    private final BibleRepository bibleRepository;

    @Override
    public BiblePrevNextBtnDto getPrevCurNextDocChapterVerseInfo(String curDocName, Integer curStartChapter, Integer curEndChapter) {
        List<String> docEngNamesAll = bibleRepository.getDocEngNamesAll();

        String prevDocName = "";
        Integer prevDocMaxChapter = 0;
        Integer prevChapterMaxVerse = 0;
        Integer curDocMaxChapter = 0;
        Integer curChapterMaxVerse = 0;
        String nextDocName = "";
        Integer nextDocFirstChapterMaxVerse = 0;
        Integer nextChapterMaxVerse = 0;
        for (int i = 0; i < docEngNamesAll.size(); i++) {
            String temp = docEngNamesAll.get(i);
            if (temp.equals(curDocName)) {
                if (i == 0) {
                    prevChapterMaxVerse = bibleRepository.getDocChapterMaxVerse("OLD", "ge", curStartChapter - 1).orElse(0);
                    curDocMaxChapter = 50;
                    curChapterMaxVerse = bibleRepository.getDocChapterMaxVerse("OLD", "ge", curEndChapter).orElse(0);
                    nextDocFirstChapterMaxVerse = 22;
                    nextChapterMaxVerse = bibleRepository.getDocChapterMaxVerse("OLD", "ge", curEndChapter + 1).orElse(0);
                    nextDocName = "exo";
                    break;
                }

                if (i == docEngNamesAll.size() - 1) {
                    prevDocName = "jude";
                    prevDocMaxChapter = 1;
                    if (curStartChapter == 1) {
                        prevChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(prevDocName), prevDocName, prevDocMaxChapter).orElse(0);
                    } else {
                        prevChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(curDocName), curDocName, curStartChapter - 1).orElse(0);
                    }
                    curDocMaxChapter = 22;
                    curChapterMaxVerse = bibleRepository.getDocChapterMaxVerse("NEW", curDocName, curEndChapter).orElse(0);
                    break;
                }

                prevDocName = docEngNamesAll.get(i - 1);
                prevDocMaxChapter = bibleRepository.getDocMaxChapter(bibleRepository.checkOldNew(prevDocName), prevDocName).orElse(0);
                if (curStartChapter == 1) {
                    prevChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(prevDocName), prevDocName, prevDocMaxChapter).orElse(0);
                } else {
                    prevChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(curDocName), curDocName, curStartChapter - 1).orElse(0);
                }
                curDocMaxChapter = bibleRepository.getDocMaxChapter(bibleRepository.checkOldNew(curDocName), curDocName).orElse(0);
                curChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(curDocName), curDocName, curEndChapter).orElse(0);
                nextDocName = docEngNamesAll.get(i + 1);
                nextDocFirstChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(nextDocName), nextDocName, 1).orElse(0);
                nextChapterMaxVerse = bibleRepository.getDocChapterMaxVerse(bibleRepository.checkOldNew(curDocName), curDocName, curEndChapter + 1).orElse(0);
            }
        }
        return new BiblePrevNextBtnDto(prevDocName, prevDocMaxChapter, prevChapterMaxVerse, curDocMaxChapter, curChapterMaxVerse, nextDocName, nextDocFirstChapterMaxVerse, nextChapterMaxVerse);
    }
}
