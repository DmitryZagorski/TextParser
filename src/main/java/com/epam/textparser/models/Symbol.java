package com.epam.textparser.models;

import java.util.Collections;

public class Symbol extends SentencePart implements Builder {

    public Symbol(String symbol) {
        super(Collections.singletonList(symbol));
    }
}
