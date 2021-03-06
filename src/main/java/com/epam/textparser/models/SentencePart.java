package com.epam.textparser.models;

import java.util.List;

public abstract class SentencePart implements Builder {

    List<String> elements;

    public SentencePart(List<String> elements) {
        this.elements = elements;
    }

    public List<String> getElements() {
        return elements;
    }

    public void addElement(String element) {
        elements.add(element);
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (String sentencePart : getElements()) {
            sb.append(sentencePart);
        }
        return sb.toString();
    }
}