package com.epam.textparser.business_logic;

import com.epam.textparser.models.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogicTest {

    @Test
    void replaceLettersInWords() {
        //given
        Parser parser = new Parser();
        Logic logic = new Logic();
        String s = "My first sentence!";
        Text text = parser.textParsing(s);
        //when
        logic.replaceLettersInWords(text);
        String expectedFirstWord = "yM";
        String actualFirstWord = text.getAllElements().get(0).getAllElements().get(0).getAllElements().get(0).buildOriginalString();
        //then
        Assertions.assertEquals(expectedFirstWord, actualFirstWord);
    }

  /*  @Test
    void replaceElements() {
        //given
        Parser parser = new Parser();
        Logic logic = new Logic();
        String s = "Sentence";
        SentencePart sentencePart = parser.sentencePartParsing(s);
        //when
        logic.replaceElements(sentencePart);
        String expectedWord = "eentancS";
        String actualWord = sentencePart.buildOriginalString();
        //then
        Assertions.assertEquals(expectedWord, actualWord);
       // Assertions.assertTrue(expectedWord.equals(actualWord));
    }
   */
}