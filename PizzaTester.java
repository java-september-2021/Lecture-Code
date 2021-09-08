import java.util.Arrays;

public class PizzaTester {
  public static void main(String[] args) {
    String[] toppings = { "Cheese", "Sauce", "Pepperoni" };

    Pizza cheese = new Pizza("Cheese Pizza!", toppings, 'S', "pan");
    Pizza meatLover = new Pizza("Meat Lovers", 'L', "New York");
    System.out.println(cheese.getName());
    cheese.setName("");
    System.out.println(cheese.getName());
    System.out.println(Pizza.getNumOfPizzas());
    System.out.println(Pizza.advertise());
    System.out.println(cheese.displayPizza());
    System.out.println(meatLover.getSlices());
    cheese.pizzaFight(meatLover);
    System.out.println(meatLover.getSlices());
  }

}