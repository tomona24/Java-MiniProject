import java.util.Scanner;

public class InputsAndCheck {
    private String[] answer;

    InputsAndCheck(){
    }

    public void setAnswer(Question lettersList) {

//        this.answer = ;
    }

    public String callInput(){
    Scanner in = new Scanner(System.in);
    System.out.println("Guess a letter.");
    String letter = in.nextLine();
    return letter;
}
}
