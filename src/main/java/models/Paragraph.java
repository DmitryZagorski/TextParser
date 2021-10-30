package models;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Builder {

    List<Sentence> elements;

    public Paragraph() {
        this.elements = new ArrayList<>();
    }

    public List<Sentence> getAllElements() {
        return elements;
    }

    public void addElements(Sentence sentence) {
        elements.add(sentence);
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentencePart : getAllElements()) {
            sb.append(sentencePart.buildOriginalString());
        }
        return sb.toString();
    }

}
