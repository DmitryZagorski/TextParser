import business_logic.Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger Log = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {

        Log.info("Start of program");;
        Logic logic = new Logic();

        System.out.println("Original text: " + "\n");
        logic.printTextFromFile();
        System.out.println("\n" + "Text with replaced letters in words: " + "\n");
        logic.printTextWithReplacedLettersInWords();
        Log.info("Finish of program");
    }
}
