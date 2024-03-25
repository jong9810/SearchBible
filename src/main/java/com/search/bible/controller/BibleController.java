package com.search.bible.controller;

import com.search.bible.dto.BibleSearchDto;
import com.search.bible.dto.BibleSearchResult;
import com.search.bible.repository.BibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BibleController {

    private final BibleRepository bibleRepository;
    private final BibleApiController bibleApiController;

    @GetMapping("/bible")
    public String bibleHome() {
        return "home";
    }

    @GetMapping("/bible/search")
    public String bibleSearchResultPage(
            Model model,
            @ModelAttribute(name = "bibleSearchDto") BibleSearchDto bibleSearchDto
    ) {
        String doc = bibleSearchDto.getDoc();
        int startChapter = bibleSearchDto.getStartChapter();
        int startVerse = bibleSearchDto.getStartVerse();
        int endChapter = bibleSearchDto.getEndChapter();
        int endVerse = bibleSearchDto.getEndVerse();

        String korName = bibleRepository.engNameToKorName(bibleSearchDto.getOldNew(), doc).orElseThrow();
        String resultTitle = korName + " " +
                startChapter + "장 " + startVerse + "절 ~ " +
                endChapter + "장 " + endVerse + "절";

        String start = startChapter + ":" + startVerse;
        String end = endChapter + ":" + endVerse;

        List<BibleSearchResult> bibleSearchResult = bibleApiController.getBibleSearchResult(doc, start, end);

        model.addAttribute("resultTitle", resultTitle);
        model.addAttribute("bibleSearchResult", bibleSearchResult);
        return "bibleSearchResult";
    }

}
