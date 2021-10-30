package models;

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

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }

//    public void replace() {
//        String firstElement = elements.get(0);
//        String lastElement = elements.get(elements.size() - 1);
//
//        if (elements.size() > 1) {
//            elements.set(0, lastElement);
//            elements.set(elements.size() - 1, firstElement);
//        }
//    }
}