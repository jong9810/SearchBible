package com.search.bible.controller;

import com.search.bible.dto.BiblePrevNextBtnDto;
import com.search.bible.dto.BibleSearchResult;
import com.search.bible.repository.BibleRepository;
import com.search.bible.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class BibleApiController {

    private final BibleRepository bibleRepository;
    private final BibleService bibleService;

    @GetMapping("/bible/api/getDocNameMap")
    public Map<String, List<String>> getDocNameMap(@RequestParam("oldNew") String oldNew) {
        Map<String, List<String>> result = new HashMap<>();
        result.put("engNameList", bibleRepository.getDocEngNames(oldNew));
        result.put("korNameList", bibleRepository.getDocKorNames(oldNew));
        return result;
    }

    @GetMapping("/bible/api/getDocMaxChapter")
    public Integer getDocMaxChapter(
            @RequestParam("oldNew") String oldNew,
            @RequestParam("engName") String engName) {
        return bibleRepository.getDocMaxChapter(oldNew, engName).orElseThrow();
    }

    @GetMapping("/bible/api/getDocChapterMaxVerse")
    public Integer getDocChapterMaxVerse(
            @RequestParam("oldNew") String oldNew,
            @RequestParam("engName") String engName,
            @RequestParam("chapterNum") Integer chapterNum) {
        return bibleRepository.getDocChapterMaxVerse(oldNew, engName, chapterNum).orElseThrow();
    }

    @GetMapping("/bible/api/engNameToKorName")
    public String engNameToKorName(
            @RequestParam("oldNew") String oldNew,
            @RequestParam("engName") String engName) {
        return bibleRepository.engNameToKorName(oldNew, engName).orElseThrow();
    }

    @GetMapping("/bible/api/getBibleSearchResult")
    public List<BibleSearchResult> getBibleSearchResult(String doc, String start, String end) {
        // https://yesu.io에서 성경 데이터 받아오기
        WebClient client = WebClient.create("https://yesu.io");
        List<BibleSearchResult> bibleSearchResult = client.get()
                .uri(uriBuilder -> uriBuilder.path("/bible")
                        .queryParam("lang", "kor")
                        .queryParam("doc", doc)
                        .queryParam("start", start)
                        .queryParam("end", end)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BibleSearchResult.class)
                .toStream().toList();

        return bibleSearchResult;
    }

    @GetMapping("/bible/api/getPrevCurNextDocChapterVerseInfo")
    public BiblePrevNextBtnDto getPrevCurNextDocChapterVerseInfo(
            @RequestParam("curDoc") String curDoc,
            @RequestParam("curStartChapter") Integer curStartChapter,
            @RequestParam("curEndChapter") Integer curEndChapter
    ) {
        BiblePrevNextBtnDto result = bibleService.getPrevCurNextDocChapterVerseInfo(curDoc, curStartChapter, curEndChapter);
        return result;
    }
}
