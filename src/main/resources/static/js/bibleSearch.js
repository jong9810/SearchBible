$(document).ready(function() {

    const $oldNew = $("#oldNew");
    const $doc = $("#doc");
    const $startChapter = $("#startChapter");
    const $startVerse = $("#startVerse");
    const $endChapter = $("#endChapter");
    const $endVerse = $("#endVerse");

    const selectOldNew = $oldNew.on("change", function() {
        const targetOldNew = $(this).val();

        $doc.val("0");
        $startChapter.val("0");
        $startVerse.val("0");
        $endChapter.val("0");
        $endVerse.val("0");

        $.ajax({
            method: "get",
            url: "/bible/api/getDocNameMap",
            dataType: "json",
            data: {oldNew: targetOldNew},
            success: function(docNameMap) {
                const $selectDoc = $("#doc");
                $selectDoc.html('<option selected value="0">도서 선택</option>');

                const korNameList = docNameMap.korNameList;
                const engNameList = docNameMap.engNameList;
                if (targetOldNew !== "0") {
                    for (let i = 0; i < korNameList.length; i++) {
                        const $option = $("<option>").prop({
                            value: engNameList[i],
                            text: korNameList[i],
                        });
                        $selectDoc.append($option);
                    }
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            },
        });


    });

    const selectDoc = $doc.on("change", function() {
        const targetOldNew = $("#oldNew").val();
        const targetEngName = $(this).val();

        $startChapter.val("0");
        $startVerse.val("0");
        $endChapter.val("0");
        $endVerse.val("0");

        $.ajax({
            method: "get",
            url: "/bible/api/getDocMaxChapter",
            dataType: "json",
            data: {
                oldNew: targetOldNew,
                engName: targetEngName,
            },
            success: function(maxChapter) {
                const $selectStartChapter = $("#startChapter");
                const $selectEndChapter = $("#endChapter");
                $selectStartChapter.html('<option selected value="0">시작 장</option>');
                $selectEndChapter.html('<option selected value="0">끝 장</option>');

                for (let i = 1; i <= maxChapter; i++) {
                    const $startOption = $("<option>").prop({
                       value: i,
                       text: i + "장",
                    });
                    const $endOption = $("<option>").prop({
                        value: i,
                        text: i + "장",
                    });
                    $selectStartChapter.append($startOption);
                    $selectEndChapter.append($endOption);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            },
        });
    });

    const selectStartChapter = $startChapter.on("change", function() {
        const targetOldNew = $("#oldNew").val();
        const targetEngName = $("#doc").val();
        const targetChapterNum = parseInt($(this).val());

        $startVerse.val("0");

        $.ajax({
            method: "get",
            url: "/bible/api/getDocChapterMaxVerse",
            data: {
                oldNew: targetOldNew,
                engName: targetEngName,
                chapterNum: targetChapterNum,
            },
            dataType: "json",
            success: function(maxVerse) {
                const $selectStartVerse = $("#startVerse");
                $selectStartVerse.html('<option selected value="0">시작 절</option>');

                for (let i = 1; i <= maxVerse; i++) {
                    const $startOption = $("<option>").prop({
                        value: i,
                        text: i + "절",
                    });
                    $selectStartVerse.append($startOption);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            },
        });
    });

    const selectEndChapter = $endChapter.on("change", function() {
        const targetOldNew = $("#oldNew").val();
        const targetEngName = $("#doc").val();
        const targetChapterNum = parseInt($(this).val());

        $endVerse.val("0");

        $.ajax({
            method: "get",
            url: "/bible/api/getDocChapterMaxVerse",
            data: {
                oldNew: targetOldNew,
                engName: targetEngName,
                chapterNum: targetChapterNum,
            },
            dataType: "json",
            success: function(maxVerse) {
                const $selectEndVerse = $("#endVerse");
                $selectEndVerse.html('<option selected value="0">끝 절</option>');

                for (let i = 1; i <= maxVerse; i++) {
                    const $endOption = $("<option>").prop({
                        value: i,
                        text: i + "절",
                    });
                    $selectEndVerse.append($endOption);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            },
        });
    });

    $("#search-button").on("click", function (e) {
        e.preventDefault();
        const doc = $("#doc").val();
        const startChapter = $("#startChapter").val();
        const startVerse = $("#startVerse").val();
        const endChapter = $("#endChapter").val();
        const endVerse = $("#endVerse").val();

        if (doc === "0") {
            alert("도서를 선택해주세요.");
            return false;
        } else if (startChapter === "0" || startVerse === "0" || endChapter === "0" || endVerse === "0") {
            alert("검색할 범위를 지정해주세요.");
            return false;
        } else if (startChapter > endChapter) {
            alert("검색 조건을 확인해주세요.");
            return false;
        } else if (startChapter === endChapter && startVerse > endVerse) {
            alert("검색 조건을 확인해주세요.");
            return false;
        } else {
            $("form").submit();
        }
    });

    const urlParams = new URL(location.href).searchParams;
    let oldNew = urlParams.get('oldNew');
    let doc = urlParams.get('doc');
    let startChapter = parseInt(urlParams.get('startChapter'));
    let startVerse = parseInt(urlParams.get('startVerse'));
    let endChapter = parseInt(urlParams.get('endChapter'));
    let endVerse = parseInt(urlParams.get('endVerse'));

    if ([oldNew, doc, startChapter, startVerse, endChapter, endVerse].includes(null)) {
        $oldNew.val("0");
        $doc.val("0");
        $startChapter.val("0");
        $startVerse.val("0");
        $endChapter.val("0");
        $endVerse.val("0");
    } else {
        $oldNew.val(oldNew);
        $oldNew.trigger("change", oldNew);
        setTimeout(function() {
            $doc.val(doc);
            $doc.trigger("change", doc);
            setTimeout(function () {
                $startChapter.val(startChapter);
                $startChapter.trigger("change", startChapter);
                $endChapter.val(endChapter);
                $endChapter.trigger("change", endChapter);
                setTimeout(function () {
                    $startVerse.val(startVerse);
                    $startVerse.trigger("change", startVerse);
                    $endVerse.val(endVerse);
                    $endVerse.trigger("change", endVerse);
                }, 70);
            }, 70);
        }, 70);
    }
});