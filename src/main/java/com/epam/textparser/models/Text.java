package com.epam.textparser.models;

import java.util.ArrayList;
import java.util.List;

public class Text implements Builder {

    List<Paragraph> elements;

    public Text() {
        this.elements = new ArrayList<>();
    }

    public List<Paragraph> getAllElements() {
        return elements;
    }

    public void addElements(Paragraph paragraph) {
        elements.add(paragraph);
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : getAllElements()) {
            sb.append(paragraph.buildOriginalString());
        }
        return sb.toString();
    }
}
