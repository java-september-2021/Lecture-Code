public class Animal {
  private String type;
  private int strength;
  private int speed;
  private String color;
  private int health = 100;

  public Animal(String type, int strength, int speed, String color) {
    this.type = type;
    this.strength = strength;
    this.speed = speed;
    this.color = color;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHealth() {
    return this.health;
  }

  public String getType() {
    return this.type;
  }

  // Animal Object can Interact and "attack" another Animal Object
  public void battle(Animal target, String powerMove) {
    // Define the logic of how the animal attacks
    int damage;
    if (powerMove.equals("fireball")) {
      // if(powerMove == "fireball")
      damage = 3;
    } else if (powerMove.equals("axe kick")) {
      damage = 4;
    } else if (powerMove.equals("knockout blow")) {
      damage = 5;
    } else {
      System.out.println("Move Not Recognized");
      return;
    }

    // multiply strength X damage
    int effectiveDamage = this.strength * damage;

    // Reduce the targets health by effective damage
    int targetsHealth = target.getHealth();
    targetsHealth -= effectiveDamage;
    target.setHealth(targetsHealth);

    // print to the console what just happened, use formatted string
    System.out.printf("%s attacks %s for %d health points \n", this.type, target.getType(), effectiveDamage);

  }

}