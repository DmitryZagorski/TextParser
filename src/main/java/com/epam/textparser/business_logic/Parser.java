package com.epam.textparser.business_logic;

import com.epam.textparser.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Logger Log = LoggerFactory.getLogger(Parser.class.getSimpleName());

    public Text textParsing(String stringText) {
        Log.info("Started textParser");
        Text text = new Text();
        String regex = "\r\n";
        String[] paragraphs = stringText.split(regex);
        for (String oneParagraph : paragraphs) {
            Paragraph paragraph = paragraphParsing(oneParagraph);
            text.addElements(paragraph);
        }
        return text;
    }

    public Paragraph paragraphParsing(String stringParagraph) {
        Log.info("Parsing of paragraph '{}'", stringParagraph);
        Paragraph paragraph = new Paragraph();
        String[] sentences = stringParagraph.split("(?<=[.!?]) ");
        for (String oneSentence : sentences) {
            Sentence sentence = sentenceParsing(oneSentence);
            paragraph.addElements(sentence);
        }
        return paragraph;
    }

    public Sentence sentenceParsing(String stringSentence) {
        Log.info("Parsing of sentence '{}'", stringSentence);
        Sentence sentence = new Sentence();
        String regex = "[\\w']+|[.,!?;]|\\s";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(stringSentence);
        while (m.find()) {
            SentencePart sentencePart = sentencePartParsing(m.group());
            sentence.addElement(sentencePart);
        }
        return sentence;
    }

    public SentencePart sentencePartParsing(String stringWord) {
        Log.info("Parsing of '{}'", stringWord);
        SymbolType symbolType = getSymbolType(stringWord);
        switch (symbolType) {
            case PUNCTUATION:
                return new Symbol(stringWord);
            default:
                String regex = "";
                String[] symbols = stringWord.split(regex);
                return new Word(Arrays.asList(symbols));
        }
    }

    public SymbolType getSymbolType(String sentencePart) {
        Log.info("Getting type of symbol '{}'", sentencePart);
        List<String> symbols = Arrays.asList(".", ",", "!", "?", " ");
        return symbols.contains(sentencePart) ? SymbolType.PUNCTUATION : SymbolType.WORD;
    }
}
