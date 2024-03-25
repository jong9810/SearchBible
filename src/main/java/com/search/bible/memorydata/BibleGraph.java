package com.search.bible.memorydata;

import lombok.Data;

import java.util.Optional;

@Data
public final class BibleGraph {

    private OldTestament oldTestament = new OldTestament();
    private NewTestament newTestament = new NewTestament();

    public Optional<Testament> getOldOrNewTestament(String oldOrNew) {
        Optional<Testament> result = Optional.empty();
        if (oldOrNew.equals("OLD")) {
            result = Optional.ofNullable(oldTestament);
        } else if (oldOrNew.equals("NEW")) {
            result = Optional.ofNullable(newTestament);
        }
        return result;
    }

}