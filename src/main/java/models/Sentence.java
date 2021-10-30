package models;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Builder {

    List<SentencePart> elements;

    public Sentence() {
        this.elements = new ArrayList<>();
    }

    public List<SentencePart> getAllElements() {
        return elements;
    }

    public void addElement(SentencePart sentencePart) {
        elements.add(sentencePart);
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (SentencePart sentencePart : getAllElements()) {
            sb.append(sentencePart.buildOriginalString());
        }
        return sb.toString();
    }
}
