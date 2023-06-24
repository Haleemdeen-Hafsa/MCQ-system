import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MCQ {
    static int score=0;
    public static void main(String[] args) throws IOException {
        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        File file = new File("src/mcqTest/");
        File[] files = file.listFiles();

        for (File f : files) {
            System.out.println(f.getName().replace(".csv", ""));

        }

        System.out.println("Choose your MCQ question set. The options are: ");
        String choice = sc.next() + ".csv";

        System.out.println("You choose" + choice + "file");
        File f = new File("src/mcqTest/" + choice);

        Scanner q1 = new Scanner(f);
        while (q1.hasNextLine()) {
            String line = q1.nextLine();
            String line_array[] = new String[6];
            line_array = line.split(",");
            System.out.println(line_array[0]);
            System.out.println("a.)" + line_array[1]);
            System.out.println("b.)" + line_array[2]);
            System.out.println("c.)" + line_array[3]);
            System.out.println("d.)" + line_array[4]);
            String correctAnswer = line_array[5].trim();

            Scanner sc1=new Scanner(System.in);
            if (sc1.hasNext()) {
                String userAnswer = sc1.next();
                System.out.println("Your Answer is" + userAnswer);
                if (userAnswer.equals(correctAnswer)) {
                    System.out.println("Correct");
                    score += 10;
                } else {
                    System.out.println("Wrong");
                    System.out.println("The correct answer is" + correctAnswer);
                }
            }
        }
        System.out.print("Your score is " + score + "% out of 100% for a total of 10 questions");
    }
}