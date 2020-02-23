import java.io.File;
import java.util.Scanner;

public class Question {
    private String cityName;
    private String[] lettersList;
    private String[] answer;


//    MakeList wholeList = new MakeList();

    // constructor
    public Question() {
//      setCity(wholeList.cityList);
        this.cityName = "vancouver";
        setLettersList(this.cityName);
        setAnswer(this.cityName);
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


    private void setAnswer(String cityName) {
        this.answer = new String[cityName.length()];
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
        System.out.println("Here's a question!");
        for (int i = 0; i < getCity().length(); i++) {
            if (getAnswer()[i] == null) {
                System.out.print("_");
            } else {
                System.out.print(getAnswer()[i]);
            }
        }
        System.out.println();
        System.out.println("Guess a  letter.");
    }

}
