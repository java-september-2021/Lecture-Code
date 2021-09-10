public class AnimalController {
  public static void main(String[] args) {
    Animal dragon = new Animal("Dragon", 10, 4, "Blue");

    Animal unicorn = new Animal("Unicorn", 20, 3, "Pink");

    System.out.println(unicorn.getHealth());
    dragon.battle(unicorn, "fireball");
    System.out.println(unicorn.getHealth());

    System.out.println(dragon.getHealth());
    unicorn.battle(dragon, "axe kick");
    System.out.println(dragon.getHealth());
  }
}