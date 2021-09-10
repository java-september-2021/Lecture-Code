public class Barrel implements Attackable {
  private String name;
  private int health;

  public Barrel(String name) {
    this.name = name;
    this.health = 50;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }
}