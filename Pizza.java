import java.util.ArrayList;
import java.util.Arrays;

public class Pizza {
  // Things pizzas have
  private String name;
  private String[] toppings;
  private char size;
  private int slices;
  private String type;
  private static int numberOfPizzas;

  public Pizza(String name, String[] toppings, char size, String type) {
    this.name = name;
    this.toppings = toppings;
    this.size = size;
    this.type = type;
    this.slices = 10;
    numberOfPizzas++;
  }

  public Pizza(String name, char size, String type) {
    this.name = name;
    this.toppings = new String[] { "Cheese", "Pepperonoi", "Spinach" };
    this.size = size;
    this.type = type;
    this.slices = 10;
    numberOfPizzas++;
  }

  // Setters
  public void setName(String name) {
    if (name.equals("")) {
      System.out.println("Name must be present!");
      return;
    }
    this.name = name;
  }

  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setSize(char size) {
    this.size = size;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public String[] getToppings() {
    return this.toppings;
  }

  public char getSize() {
    return this.size;
  }

  public int getSlices() {
    return this.slices;
  }

  public String getType() {
    return this.type;
  }

  public static int getNumOfPizzas() {
    return numberOfPizzas;
  }

  // Things you can do
  // Eat() eat a slice of the pizza
  // display() does a system out println of the descriptors to the terminal
  // Cook the pizza (bake) get that sucker ready for primetime!

  public static String advertise() {
    return "Welcome to Matts Pizzeria, completely not mafia owned wink wink";
  }

  public String displayPizza() {
    return String.format("This is a %s, with %s toppings %d slices", this.name, Arrays.toString(this.toppings),
        this.slices);
  }

  public void pizzaFight(Pizza otherPizza) {
    int numOfSlices = otherPizza.getSlices();
    numOfSlices -= 1;
    otherPizza.setSlices(numOfSlices);

    System.out.println(this.name + " just kerplowed " + otherPizza.getName() + " and " + otherPizza.getName()
        + " now only has " + otherPizza.getSlices());
  }
}