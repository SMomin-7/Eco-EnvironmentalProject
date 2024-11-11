public class MoistureController extends Thread {
  private double optMoistMin;
  public double currentMoist;
  private double SprinkSpeed;
  private double SprinkDiag;
  public boolean SprinklerOn = false;
  public boolean bool = true;

  /**
   *
   * @param optMoistMin To get the optimum moisture
   * @param initMoist   To get initial moisture
   * @param SprinkSpeed to get sprinkler speed
   * @param SprinkDiag  gets value to change moisture rate
   */
  public void addData(double optMoistMin, double initMoist, double SprinkSpeed, double SprinkDiag) {
    this.optMoistMin = optMoistMin;
    this.currentMoist = initMoist;
    this.SprinkSpeed = SprinkSpeed;
    this.SprinkDiag = SprinkDiag * 1000.0;
  }

  /**
   *
   * @param delta gets value to update the moisture in soil
   */
  public synchronized void changeMoist(double delta) {
    currentMoist += delta;
  }

  public void run() {
    while (bool) {
      this.setPriority(10);
      if (currentMoist < optMoistMin) {
        SprinklerOn = true;
        try {
          Thread.sleep(Math.round(SprinkDiag));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        changeMoist(SprinkSpeed / (60.0 / (SprinkDiag / 1000.0)));
      } else {
        SprinklerOn = false;
      }
    }
  }

  public void kill() {
    bool = false;
  }
}
