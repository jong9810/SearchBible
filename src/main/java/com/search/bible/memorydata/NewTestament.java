package com.search.bible.memorydata;

import lombok.Getter;

import java.util.*;

@Getter
public class NewTestament implements Testament {

    private final int docCount = 27;
    private final List<String> engNameList = new ArrayList<>(Arrays.asList(
            "mat", "mark", "luke", "john", "acts", "rom", "1cor", "2cor", "gal", "eph", "phi", "col",
            "1th", "2th", "1tim", "2tim", "titus", "phmn", "heb", "jas", "1pet", "2pet", "1jn", "2jn", "3jn",
            "jude", "rev"
    ));
    private final List<String> korNameList = new ArrayList<>(Arrays.asList(
            "마태복음", "마가복음", "누가복음", "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서", "갈라디아서",
            "에베소서", "빌립보서", "골로새서", "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서", "디도서",
            "빌레몬서", "히브리서", "야고보서", "베드로전서", "베드로후서", "요한1서", "요한2서", "요한3서", "유다서",
            "요한계시록"
    ));
    private final List<Integer> maxChapterList = new ArrayList<>(Arrays.asList(
            28, 16, 24, 21, 28, 16, 16, 13, 6, 6, 4, 4, 5, 3, 6, 4, 3, 1, 13, 5, 5, 3, 5, 1, 1, 1, 22
    ));
    private final int[][] maxVerse2DimensionArray = {
            {25, 23, 17, 25, 48, 34, 29, 34, 38, 42, 30, 50, 58, 36, 39, 28, 27, 35, 30, 34, 46, 46, 39, 51, 46, 75, 66, 20},
            {45, 28, 35, 41, 43, 56, 37, 38, 50, 52, 33, 44, 37, 72, 47, 20},
            {80, 52, 38, 44, 39, 49, 50, 56, 62, 42, 54, 59, 35, 35, 32, 31, 37, 43, 48, 47, 38, 71, 56, 53},
            {51, 25, 36, 54, 47, 71, 53, 59, 41, 42, 57, 50, 38, 31, 27, 33, 26, 40, 42, 31, 25},
            {26, 47, 26, 37, 42, 15, 60, 40, 43, 48, 30, 25, 52, 28, 41, 40, 34, 28, 41, 38, 40, 30, 35, 27, 27, 32, 44, 31},
            {32, 29, 31, 25, 21, 23, 25, 39, 33, 21, 36, 21, 14, 23, 33, 27},
            {31, 16, 23, 21, 13, 20, 40, 13, 27, 33, 34, 31, 13, 40, 58, 24},
            {24, 17, 18, 18, 21, 18, 16, 24, 15, 18, 33, 21, 14},
            {24, 21, 29, 31, 26, 18},
            {23, 22, 21, 32, 33, 24},
            {30, 30, 21, 23},
            {29, 23, 25, 18},
            {10, 20, 13, 18, 28},
            {12, 17, 18},
            {20, 15, 16, 16, 25, 21},
            {18, 26, 17, 22},
            {16, 15, 15},
            {25},
            {14, 18, 19, 16, 14, 20, 28, 13, 28, 39, 40, 29, 25},
            {27, 26, 18, 17, 20},
            {25, 25, 22, 19, 14},
            {21, 22, 18},
            {10, 29, 24, 21, 21},
            {13},
            {14},
            {25},
            {20, 29, 22, 11, 14, 17, 17, 13, 21, 11, 19, 17, 18, 20, 8, 21, 18, 24, 21, 15, 27, 21},
    };
    private Map<String, Document> docMap = new HashMap<>();

    public NewTestament() {
        for (int i = 0; i < engNameList.size(); i++) {
            String tempEngName = engNameList.get(i);
            String tempKorName = korNameList.get(i);
            int tempMaxChapter = maxChapterList.get(i);

            Map<Integer, Integer> tempChapterMap = new HashMap<>();
            for (int j = 0; j < tempMaxChapter; j++) {
                int tempMaxVerse = maxVerse2DimensionArray[i][j];
                tempChapterMap.put(j + 1, tempMaxVerse);
            }

            Document tempDoc = new Document(tempEngName, tempKorName, tempMaxChapter, tempChapterMap);
            docMap.put(tempEngName, tempDoc);
        }
    }
}

