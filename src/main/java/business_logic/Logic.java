package business_logic;

import fileloader.FileLoader;
import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logic {

    private static final Logger Log = LoggerFactory.getLogger(Logic.class.getSimpleName());

    public void replaceLettersInWords(Text text) {
        Log.info("Start of replacing words in '{}'", text.buildOriginalString());
        Parser parser = new Parser();
        for (Paragraph paragraph : text.getAllElements()) {
            for (Sentence sentence : paragraph.getAllElements()) {
                for (SentencePart sentencePart : sentence.getAllElements()) {
                    if (parser.getSymbolType(sentencePart.toString()).equals(SymbolType.WORD)) {
                        replaceElements(sentencePart);
                    }
                }
            }
        }
    }

    public void replaceElements(SentencePart sentencePart) {
        Log.info("Starting of replacing first and last elements of {}", sentencePart.getElements());
        String firstElement = sentencePart.getElements().get(0);
        String lastElement = sentencePart.getElements().get(sentencePart.getElements().size() - 1);
        if (sentencePart.getElements().size() > 1) {
            sentencePart.getElements().set(0, lastElement);
            sentencePart.getElements().set(sentencePart.getElements().size() - 1, firstElement);
        }
    }

    public void printTextFromFile() {
        Log.info("Printing strings from file");
        FileLoader fileLoader = new FileLoader();
        System.out.println(fileLoader.readFile());
    }

    public void printTextWithReplacedLettersInWords() {
        Log.info("Printing text with replaced letters in words");
        Parser parser = new Parser();
        FileLoader fileLoader = new FileLoader();
        Logic logic = new Logic();
        Text text = parser.textParsing(fileLoader.readFile());
        logic.replaceLettersInWords(text);
        for (Paragraph paragraph : text.getAllElements()) {
            System.out.println(paragraph.buildOriginalString());
        }
    }
}
