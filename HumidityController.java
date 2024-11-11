public class HumidityController extends Thread {
  private double optHumidMin;
  public double currentHumid;
  private double HumidSpeed;
  private double HumidDiag;
  public boolean humidifierOn = false;
  public boolean bool1 = true;

  /**
   *
   * @param optHumidMin gets optimum humidity
   * @param initHumid   gets initial humidity
   * @param HumidSpeed  gets humidifying rate
   * @param HumidDiag   gets value to update humidity
   */
  public void addData(double optHumidMin, double initHumid, double HumidSpeed, double HumidDiag) {
    this.optHumidMin = optHumidMin;
    this.currentHumid = initHumid;
    this.HumidSpeed = HumidSpeed;
    this.HumidDiag = HumidDiag * 1000.0;
  }

  /**
   *
   * @param delta to change the humidity
   */
  public synchronized void changeHumid(double delta) {
    currentHumid += delta;
  }

  public void run() {
    while (bool1) {
      this.setPriority(10);
      if (currentHumid < optHumidMin) {
        humidifierOn = true;
        try {
          Thread.sleep(Math.round(HumidDiag));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        changeHumid(HumidSpeed / (60.0 / (HumidDiag / 1000.0)));
      } else {
        humidifierOn = false;
      }
    }
  }

  public void kill() {
    bool1 = false;
  }
}
