public class Driver {
    public static void main(String[] args) {

//        MakeList a = new MakeList();
//        System.out.println(a.getCityList());
//        System.out.println(a.getLineCounter());

        MakeList a = new MakeList();
        System.out.println(a.getCityName());;

        Question c = new Question();

        System.out.println(c.getCity());
        System.out.println(c.getLettersList().length);
        System.out.println(c.getLettersList()[0]);
        c.showHiddenQuiz();

    }
}
