import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeList {
    public static int lineCounter = 0;
    public String[] cityList;
    private Scanner in;
    private String cityName;

    // constructor
    public MakeList() {
        setCityList();
        setCityName(lineCounter);
    }


    // Setter
    private void setCityList () {
        try {
            File f = new File("cities.txt");
            this.in = new Scanner(f);
            while (in.hasNextLine()) {
                lineCounter++;
            }
            this.cityList = new String[lineCounter];
            int counter = 0;
            while (in.hasNextLine()) {
                this.cityList[counter] = in.nextLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setCityName (int lineCounter) {
            int line = (int) Math.random() * lineCounter;
            this.cityName = this.cityList[line];
        }

    // Getter
    public String[] getCityList() {
        return cityList;
    }
    public int getLineCounter() {
        return lineCounter;
    }
    public String getCityName() {return cityName;}
}
