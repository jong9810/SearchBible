package com.search.bible.repository;

import com.search.bible.memorydata.BibleGraph;
import com.search.bible.memorydata.Document;
import com.search.bible.memorydata.Testament;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBibleRepository implements BibleRepository {

    private static final BibleGraph bibleGraph = new BibleGraph();

    @Override
    public List<String> getDocEngNames(String oldNew) {
        Testament testament = bibleGraph.getOldOrNewTestament(oldNew).orElseThrow();
        return testament.getEngNameList();
    }

    @Override
    public List<String> getDocKorNames(String oldNew) {
        Testament testament = bibleGraph.getOldOrNewTestament(oldNew).orElseThrow();
        return testament.getKorNameList();
    }

    @Override
    public List<String> getDocEngNamesAll() {
        List<String> result = new ArrayList<>();
        result.addAll(getDocEngNames("OLD"));
        result.addAll(getDocEngNames("NEW"));
        return result;
    }

    @Override
    public List<String> getDocKorNamesAll() {
        List<String> result = new ArrayList<>();
        result.addAll(getDocKorNames("OLD"));
        result.addAll(getDocKorNames("NEW"));
        return result;
    }

    @Override
    public Optional<Map<String, Document>> getDocMap(String oldNew) {
        Optional<Map<String, Document>> result = Optional.empty();
        try {
            Testament testament = bibleGraph.getOldOrNewTestament(oldNew).orElseThrow();
            result = Optional.ofNullable(testament.getDocMap());
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public Optional<Map<Integer, Integer>> getChapterMap(String oldNew, String engName) {
        Optional<Map<Integer, Integer>> result = Optional.empty();
        try {
            Map<String, Document> docMap = getDocMap(oldNew).orElseThrow();
            result = Optional.ofNullable(docMap.get(engName).getChapterMap());
        } catch(Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public Optional<Integer> getDocMaxChapter(String oldNew, String engName) {
        Optional<Integer> result = Optional.empty();
        try {
            Map<String, Document> docMap = getDocMap(oldNew).orElseThrow();
            result = Optional.ofNullable(docMap.get(engName).getMaxChapter());
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public Optional<Integer> getDocChapterMaxVerse(String oldNew, String engName, Integer chapterNum) {
        Optional<Integer> result = Optional.empty();
        try {
            Map<Integer, Integer> chapterMap = getChapterMap(oldNew, engName).orElseThrow();
            result = Optional.ofNullable(chapterMap.get(chapterNum));
        } catch(Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public Optional<String> engNameToKorName(String oldNew, String engName) {
        Optional<String> result = Optional.empty();
        try {
            Testament testament = bibleGraph.getOldOrNewTestament(oldNew).orElseThrow();
            result = Optional.ofNullable(testament.getDocMap().get(engName).getKorName());
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public Optional<String> korNameToEngName(String oldNew, String korName) {
        Optional<String> result = Optional.empty();
        try {
            Testament testament = bibleGraph.getOldOrNewTestament(oldNew).orElseThrow();
            List<String> korNameList = testament.getKorNameList();
            List<String> engNameList = testament.getEngNameList();
            for (int i = 0; i < korNameList.size(); i++) {
                if (korNameList.get(i).equals(korName)) {
                    result = Optional.ofNullable(engNameList.get(i));
                }
            }
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public String checkOldNew(String engName) {
        List<String> docEngOldNames = getDocEngNames("OLD");
        List<String> docEngNewNames = getDocEngNames("NEW");

        if (docEngOldNames.contains(engName)) {
            return "OLD";
        } else if (docEngNewNames.contains(engName)) {
            return "NEW";
        } else {
            return null;
        }
    }
}
