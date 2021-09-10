public abstract class Human {
  private String intelligence;
  private boolean bipedal;
  private boolean breathe;

  public Human(String intelligence, boolean bipedal, boolean breathe) {
    this.intelligence = intelligence;
    this.bipedal = bipedal;
    this.breathe = breathe;
  }

  public abstract void sleep();

  public abstract void eat();
}