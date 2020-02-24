import java.io.File;
import java.util.Scanner;

public class Question {
    private String cityName;
    private String[] answer;
    private String[] lettersList;
    private static int correctNum;
    private String wrongLetters;

    // constructor
    public Question() {
        this.cityName = new MakeList().getCityName();
        setLettersList(this.cityName);
        this.answer = new String[this.cityName.length()];
        this.wrongLetters = "";
    }

    // setter
    private void setLettersList(String cityName) {
        this.lettersList = new String[cityName.length()];
        for (int i = 0; i < cityName.length(); i++) {
            lettersList[i] = String.valueOf(cityName.charAt(i));
        }
    }

    private void setAnswer(String letter, int num) {
        this.answer[num] = letter;
    }

    private void setWrongLetters(String letter) {
        if (this.wrongLetters.indexOf(letter) == -1) {
            this.wrongLetters += letter + " ";
        }
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

    public String getWrongLetters() {
        return wrongLetters;
    }

    public int getAmountOfWrong() {
        int amount = 0;
        for (int i = 0; i < getWrongLetters().length(); i++) {
            if (getWrongLetters().length() > 0) {
                amount++;
            }
        }
        return amount;
    }


    public int getCorrectNum() {
        return correctNum;
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
        int num = 0;
        for (int k = 0; k < getLettersList().length; k++) {
            if (getLettersList()[k].equals(letter)) {
                setAnswer(letter, k);
                num++;
            }
        }
        if (num == 0) {
            setWrongLetters(letter);
        }
    }

    public void askAnswer() {
        while (getWrongLetters().length() / 2 < 10) {
            if (getCorrectNum() == getCity().length()) {
                break;
            }
            changeAnswer(inputLetter());
            correctCheck();
            System.out.print("You are guessing : ");
            showHiddenQuiz();
            System.out.println("You have guessed (" + getAmountOfWrong() / 2 + ") wrong letters : " + getWrongLetters());


        }
        if (getCorrectNum() == getCity().length()) {
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
            System.out.print("Guess a letter : ");
            letter = in.nextLine();
        } while (letter.length() != 1);
        return letter;
    }
}
