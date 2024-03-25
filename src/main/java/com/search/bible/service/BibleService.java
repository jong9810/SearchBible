package com.search.bible.service;

import com.search.bible.dto.BiblePrevNextBtnDto;

public interface BibleService {


    BiblePrevNextBtnDto getPrevCurNextDocChapterVerseInfo(String curDocName, Integer curStartChapter, Integer curEndChapter);
}
