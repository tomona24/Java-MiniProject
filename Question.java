import java.io.File;
import java.util.Scanner;

public class Question {
    private String cityName;
    private String[] answer;
    private String[] lettersList;
    private static int counter;
    private static int correctNum;

//    MakeList wholeList = new MakeList();

    // constructor
    public Question() {
//      setCity(wholeList.cityList);
        this.cityName = "vancouver";
        setLettersList(this.cityName);
        this.answer = new String[this.cityName.length()];
        this.counter = 0;
    }

    // setter
//    private void setCity(String[] Arr) {
//        this.city = Arr[wholeList.getLineCounter()];
//    }

    private void setLettersList(String cityName) {
        this.lettersList = new String[cityName.length()];
        for (int i = 0; i < cityName.length(); i++) {
            lettersList[i] = String.valueOf(cityName.charAt(i));
        }
    }

    private void setAnswer(String letter, int num) {
        this.answer[num] = letter;
    }

    // getter
    public String getCity() {
        return cityName;
    }

    public String[] getLettersList() {
        return lettersList;
    }

    public String[] getAnswer() {
        return answer;
    }

    // method
    public void showHiddenQuiz() {
        for (int i = 0; i < getCity().length(); i++) {
            if (getAnswer()[i] == null) {
                System.out.print("_");
            } else {
                System.out.print(getAnswer()[i]);
            }
        }
        System.out.println();
    }

    public void changeAnswer(String letter) {
        for (int k = 0; k < getLettersList().length; k++) {
            if (getLettersList()[k].equals(letter)) {
                setAnswer(letter, k);
            }
        }
    }

    public void askAnswer() {
        while (counter < 10) {
            if (correctNum == getCity().length()) {
                break;
            }
            showHiddenQuiz();
            changeAnswer(inputLetter());
            counter++;
            correctCheck();
        }
        if (correctNum == getCity().length()) {
            gameClear();
        } else {
            gameOver();

        }
    }

    public void correctCheck() {
        this.correctNum = 0;
        for (int p = 0; p < getAnswer().length; p++) {
            if (answer[p] != null) {
                correctNum++;
            }
        }
    }

    public void gameOver() {
        System.out.println("You lose!");
        System.out.println("The correct word is '" + getCity() + "' !");

    }

    public void gameClear() {
        System.out.println("You win!");
        System.out.println("You have guessed '" + getCity() + "' correctly!");

    }

    public String inputLetter() {
        String letter = "";
        do {
            if (letter.length() > 1) {
                System.out.println("Please type just 1 letter!");
            }
            Scanner in = new Scanner(System.in);
            System.out.println("Guess a letter.");
            letter = in.nextLine();
        } while (letter.length() != 1);
        return letter;
    }
}
