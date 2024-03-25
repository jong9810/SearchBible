$(document).ready(function() {
    const showVerseCount = 10;

    const urlParams = new URL(location.href).searchParams;
    let oldNew = urlParams.get('oldNew');
    let doc = urlParams.get('doc');
    let startChapter = parseInt(urlParams.get('startChapter'));
    let startVerse = parseInt(urlParams.get('startVerse'));
    let endChapter = parseInt(urlParams.get('endChapter'));
    let endVerse = parseInt(urlParams.get('endVerse'));

    $.ajax({
        method: "get",
        url: "/bible/api/getPrevCurNextDocChapterVerseInfo",
        data: {
            curDoc: doc,
            curStartChapter: startChapter,
            curEndChapter: endChapter,
        },
        dataType: "json",
        success: function(dataMap) {
            //console.log(dataMap);
            window.localStorage.setItem("prevNextData", JSON.stringify(dataMap));
        },
        error: function(jqXHR) {
            console.log(jqXHR);
            console.log(jqXHR.responseText);
        },
    });

    $("#prev-verse-btn").on("click", function() {
        const prevNextData = JSON.parse(localStorage.getItem("prevNextData"));

        const isGe = doc === "ge";
        const isMat = doc === "mat";
        const isDocsFirstVerse = startChapter === 1 && startVerse === 1;
        const isChaptersFirstVerse = startChapter > 1 && startVerse === 1;
        const canShowVerseCount = startVerse > showVerseCount;

        if (isGe && isDocsFirstVerse) {
            alert("이전 " + showVerseCount + "개 절이 존재하지 않습니다.");
            return;
        }

        if (isMat && isDocsFirstVerse) {
            oldNew = "OLD";
            doc = "mal";
            startChapter = 4;
            startVerse = 1;
            endChapter = 4;
            endVerse = 6;
        } else if (!isGe && !isMat && isDocsFirstVerse) {
            doc = prevNextData.prevDocName;  // 이전 도서명
            endChapter = prevNextData.prevDocMaxChapter; // 이전 도서의 최대 장 수
            startChapter = prevNextData.prevDocMaxChapter; // 이전 도서의 최대 장 수
            endVerse = prevNextData.prevChapterMaxVerse; // 이전 장 최대 절 수
            let tempStartVerse = endVerse - showVerseCount + 1;
            startVerse = tempStartVerse > 0 ? tempStartVerse : 1;
        } else if (!isGe && !isMat && isChaptersFirstVerse) {
            startChapter -= 1;
            endChapter = startChapter;
            endVerse = prevNextData.prevChapterMaxVerse; // 이전 장 최대 절 수
            let tempStartVerse = endVerse - showVerseCount + 1;
            startVerse = tempStartVerse > 0 ? tempStartVerse : 1;
        } else if (canShowVerseCount) {
            endChapter = startChapter;
            endVerse = startVerse - 1;
            startVerse = endVerse - showVerseCount + 1;
        } else if (!canShowVerseCount) {
            endChapter = startChapter;
            endVerse = startVerse - 1;
            startVerse = 1;
        }

        const url = "http://" + location.host + location.pathname +
            "?oldNew=" + oldNew + "&doc=" + doc +
            "&startChapter=" + startChapter + "&startVerse=" + startVerse +
            "&endChapter=" + endChapter + "&endVerse=" + endVerse;
        location.href = url;
    });

    $("#next-verse-btn").on("click", function() {
        const prevNextData = JSON.parse(localStorage.getItem("prevNextData"));

        const isMal = doc === "mal";
        const isRev = doc === "rev";
        const isDocsLastVerse = endChapter === prevNextData.curDocMaxChapter && endVerse === prevNextData.curChapterMaxVerse;
        const isChaptersLastVerse = endChapter < prevNextData.curDocMaxChapter && endVerse === prevNextData.curChapterMaxVerse;
        const canShowVerseCount = endVerse + showVerseCount <= prevNextData.curChapterMaxVerse;

        if (isRev && isDocsLastVerse) {
            alert("다음 " + showVerseCount + "개 절이 존재하지 않습니다.");
            return;
        }

        if (isMal && isDocsLastVerse) {
            oldNew = "NEW";
            doc = "mat";
            startChapter = 1;
            startVerse = 1;
            endChapter = 1;
            endVerse = showVerseCount;
        } else if (!isRev && !isMal && isDocsLastVerse) {
            doc = prevNextData.nextDocName;  // 다음 도서명
            startChapter = 1;
            endChapter = 1;
            startVerse = 1;
            let ifNextDocHasEnoughVerse = prevNextData.nextDocFirstChapterMaxVerse - showVerseCount >= 0;
            endVerse = ifNextDocHasEnoughVerse ? showVerseCount : prevNextData.nextDocFirstChapterMaxVerse;
        } else if (!isRev && !isMal && isChaptersLastVerse) {
            startChapter += 1;
            endChapter = startChapter;
            startVerse = 1;
            let ifNextChapterHasEnoughVerse = prevNextData.nextChapterMaxVerse - showVerseCount >= 0;
            endVerse = ifNextChapterHasEnoughVerse ? showVerseCount : prevNextData.nextChapterMaxVerse;
        } else if (canShowVerseCount) {
            startChapter = endChapter;
            startVerse = endVerse + 1;
            endVerse = startVerse + showVerseCount - 1;
        } else if (!canShowVerseCount) {
            startChapter = endChapter;
            startVerse = endVerse + 1;
            endVerse = prevNextData.curChapterMaxVerse;
        }

        let url = "http://" + location.host + location.pathname +
            "?oldNew=" + oldNew + "&doc=" + doc +
            "&startChapter=" + startChapter + "&startVerse=" + startVerse +
            "&endChapter=" + endChapter + "&endVerse=" + endVerse;
        // console.log(url);
        location.href = url;
    });

});