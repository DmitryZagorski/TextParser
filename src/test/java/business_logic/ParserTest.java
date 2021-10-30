package business_logic;

import fileloader.FileLoader;
import models.Paragraph;
import models.Sentence;
import models.SentencePart;
import models.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void should_parse_the_text() {
        //given
        Parser parser = new Parser();
        FileLoader fileLoader = new FileLoader();
        String textFromFile = fileLoader.readFile();
        //when
        Text text = parser.textParsing(textFromFile);
        int expectedSize = 3;
        int actualSize = text.getAllElements().size();
        //then
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void should_parse_the_paragraph() {
        //given
        Parser parser = new Parser();
        String stringParagraph = "First sentence. Is it first? Yes!";
        //when
        Paragraph paragraph = parser.paragraphParsing(stringParagraph);
        int expectedSize = 3;
        int actualSize = paragraph.getAllElements().size();
        //then
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void should_parse_the_sentence() {
        //given
        Parser parser = new Parser();
        String stringSentence = "First sentence in text.";
        //when
        Sentence sentence = parser.sentenceParsing(stringSentence);
        int expectedSize = 8;
        int actualSize = sentence.getAllElements().size();
        //then
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void should_parse_the_sentencePart() {
        //given
        Parser parser = new Parser();
        String stringSentencePart = "First";
        //when
        SentencePart sentencePart = parser.sentencePartParsing(stringSentencePart);
        int expectedSize = 5;
        int actualSize = sentencePart.getElements().size();
        //then
        Assertions.assertEquals(expectedSize, actualSize);
    }
}