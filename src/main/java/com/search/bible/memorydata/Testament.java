package com.search.bible.memorydata;

import java.util.List;
import java.util.Map;

public interface Testament {
    List<String> getEngNameList();
    List<String> getKorNameList();
    List<Integer> getMaxChapterList();
    int[][] getMaxVerse2DimensionArray();
    Map<String, Document> getDocMap();
}
