import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Puzzling {
  public static void main(String[] args) {
    Random r = new Random();
    ArrayList<Character> alphabet = new ArrayList<Character>();
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      alphabet.add(ch);
    }
    System.out.println(alphabet.size());

    int randomVal = r.nextInt(26);
    System.out.println(alphabet);
    Collections.shuffle(alphabet);
    System.out.println(alphabet);
    System.out.println(alphabet.get(randomVal));
    System.out.println(randomVal);
  }
}