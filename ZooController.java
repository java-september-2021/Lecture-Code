import java.util.ArrayList;

public class ZooController {
  public static void main(String[] args) {
    Mammal matthew = new Mammal("human", 100);
    Gorilla dk = new Gorilla();

    Barrel b1 = new Barrel("Barrel");

    dk.attack(b1);

    ArrayList<Mammal> myMammals = new ArrayList<Mammal>();
    myMammals.add(matthew);
    myMammals.add(dk);

    for (Mammal m : myMammals) {
      System.out.println(m.getSpecies());
    }
  }
}