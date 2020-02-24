import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MakeList {
    private String[] cityList;
    private String cities;
    private String cityName;

    // constructor
    public MakeList() {
        this.cities = "";
        setCityList();
        setCityName();
    }


    // Setter
    private void setCityList () {
        try {
            String filename = "cities.txt";
            File f = new File(filename);
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                this.cities += in.nextLine() + ",";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.cityList = getCities().split(",");
    }

    private void setCityName () {
        Random rand = new Random();
            int line = rand.nextInt(getCityList().length);
             System.out.println(line);
            this.cityName = this.cityList[line];
        }

    // Getter
    public String[] getCityList() {
        return cityList;
    }
    public String getCityName() {return cityName;}
    public String getCities() {return cities;}
}
