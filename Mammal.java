public class Mammal implements Attackable {
  protected String species;
  protected int health;

  public Mammal(String species, int health) {
    this.species = species;
    this.health = health;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
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

  public void attack(Attackable target) {
    // targets health
    int targetsHealth = target.getHealth();
    // Decrement health
    targetsHealth -= 5;
    target.setHealth(targetsHealth);
  }
}