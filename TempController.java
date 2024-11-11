public class TempController extends Thread{
  private double optTemp;
  private double ACSpeed;
  private double FurnaceSpeed;
  private double ExtImpact;
  private double DiagRate;
  public double currentTemp;
  public boolean ACOn = false;
  public boolean furnaceOn = false;
  public boolean bool2 = true;

  /**
   *
   * @param optTemp reads optimum temperature
   * @param initTemp reads initial temperature
   * @param ACSpeed reads AC cool speed
   * @param FurnaceSpeed reads Furnace heat speed
   * @param ExtImpact reads external temperature
   * @param DiagRate reads value to upgrade the temperature
   */
  public void addData(double optTemp, double initTemp, double ACSpeed, double FurnaceSpeed, double ExtImpact, double DiagRate) {
      this.optTemp = optTemp;
      this.ACSpeed = ACSpeed;
      this.FurnaceSpeed = FurnaceSpeed;
      this.ExtImpact = ExtImpact;
      this.DiagRate = DiagRate*1000.0;
      currentTemp = initTemp;
  }

  /**
   *
   * @param deltaTemp to change the current temp value
   */
  public synchronized void changeTemp(double deltaTemp) {
      currentTemp+=deltaTemp;
  }

  /**
   * Thread run function for body
   */
  public void run() {
      while(bool2) {
          this.setPriority(10);
          if (currentTemp>(optTemp+3.0)) {
              ACOn = true;
              furnaceOn= false;
              try {
                  Thread.sleep(Math.round(DiagRate));
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              changeTemp(ACSpeed/(60.0/(DiagRate/1000.0)));
          } else if (currentTemp<(optTemp-3.0)) {
              ACOn = false;
              furnaceOn= true;
              try {
                  Thread.sleep(Math.round(DiagRate));
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              changeTemp(FurnaceSpeed/(60.0/(DiagRate/1000.0)));
          } else if (optTemp-3.0<=currentTemp && currentTemp<=optTemp+3.0) {
              ACOn = false;
              furnaceOn= false;
          }
      }
  }

  /**
   * kill method to shut the thread.
   */
  public void kill() {
      bool2=false;
  }
}
