package com.search.bible.memorydata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Document {

    private String engName;
    private String korName;
    private Integer maxChapter;
    private Map<Integer, Integer> chapterMap = new HashMap<>();

    public Document(String engName, String korName, Integer maxChapter, Map<Integer, Integer> chapterMap) {
        this.engName = engName;
        this.korName = korName;
        this.maxChapter = maxChapter;
        this.chapterMap = chapterMap;
    }
}
