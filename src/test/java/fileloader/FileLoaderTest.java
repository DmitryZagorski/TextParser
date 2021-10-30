package fileloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileLoaderTest {

    @Test
    void should_read_text_from_file() {
        //given
        FileLoader fileLoader = new FileLoader();
        StringBuilder stringBuilder = new StringBuilder();
        //when
        String stringText = fileLoader.readFile();
        stringBuilder.append(stringText);
        int originLength = 105;
        //then
        Assertions.assertEquals(originLength, stringBuilder.length());
    }
}