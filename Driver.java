import com.sun.tools.javac.comp.Check;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Question c = new Question();
        System.out.println("Here's a question!");
        c.showHiddenQuiz();
        c.askAnswer();
    }
}
