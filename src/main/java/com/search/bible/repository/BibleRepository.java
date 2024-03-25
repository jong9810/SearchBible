package com.search.bible.repository;

import com.search.bible.memorydata.Document;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BibleRepository {

    List<String> getDocEngNames(String oldNew);
    List<String> getDocKorNames(String oldNew);
    List<String> getDocEngNamesAll();
    List<String> getDocKorNamesAll();
    Optional<Map<String, Document>> getDocMap(String oldNew);
    Optional<Map<Integer, Integer>> getChapterMap(String oldNew, String engName);
    Optional<Integer> getDocMaxChapter(String oldNew, String engName);
    Optional<Integer> getDocChapterMaxVerse(String oldNew, String engName, Integer chapterNum);
    Optional<String> engNameToKorName(String oldNew, String engName);
    Optional<String> korNameToEngName(String oldNew, String korName);
    String checkOldNew(String engName);
}
