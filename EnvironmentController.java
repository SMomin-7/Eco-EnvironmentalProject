import java.awt.event.*;

/**
 * @since 1.6
 * @author Shaim Momin
 * @version 1.0
 */
public class EnvironmentController {
  private SimulationView view;
  public TempController modelTemp;
  public HumidityController modelHumid;
  public MoistureController modelMoist;
  public double currentTemp;
  public double currentHumid;
  public double currentMoist;
  public NaturalMoistEffects nature3;
  public NaturalHumidEffects nature2;
  public NaturalTempEffects nature1;

  // The View and model are instantiated here
  /**
   * This is the controller constructor
   *
   * @param view       is the GUI
   * @param modelTemp  is the temperature model
   * @param modelHumid is humidity model
   * @param modelMoist is Sprinkler model
   */
  public EnvironmentController(SimulationView view, TempController modelTemp, HumidityController modelHumid,
      MoistureController modelMoist) {
    this.view = view;
    this.modelTemp = modelTemp;
    this.modelHumid = modelHumid;
    this.modelMoist = modelMoist;
    view.addCalculateListener(new TControls(), new MControls(), new HControls(), new Start(), new Stop());
  }

  /**
   * Action listener for temperature button
   */
  class TControls implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      view.controlPanelButton = 1;
      view.changeColor();
      view.hideControlPanel();
      view.displayControlPanel();
    }
  }

  /**
   * Action listener for Moisture button
   */
  class MControls implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      view.controlPanelButton = 2;
      view.changeColor();
      view.hideControlPanel();
      view.displayControlPanel();
    }
  }

  /**
   * Action listener for Humidity button
   */
  class HControls implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      view.controlPanelButton = 3;
      view.changeColor();
      view.hideControlPanel();
      view.displayControlPanel();
    }
  }

  /**
   * Action listener for start button to start the controller
   */
  class Start implements ActionListener {
    /**
     *
     * @param e the event to be processed after start
     */
    public void actionPerformed(ActionEvent e) {
      modelTemp.addData(view.getOptimalAT(), view.getInitAT(), view.getACSpeed(), view.getFurnaceSpeed(),
          view.getExtTempImpact(), view.getTempDiagRate());
      currentTemp = modelTemp.currentTemp;
      modelHumid.addData(view.getoptHumidMin(), view.getinitHumid(), view.getHumidSpeed(), view.getHumidDiagRate());
      currentHumid = modelHumid.currentHumid;
      modelMoist.addData(view.getoptMoistMin(), view.getinitMoist(), view.getMoistSpeed(), view.getMoistDiagRate());
      currentMoist = modelMoist.currentMoist;
      modelTemp.setPriority(10);
      modelTemp.start();
      modelHumid.start();
      modelMoist.start();
      nature3 = new NaturalMoistEffects();
      nature3.setPriority(1);
      nature3.start();
      nature2 = new NaturalHumidEffects();
      nature2.setPriority(1);
      nature2.start();
      nature1 = new NaturalTempEffects();
      nature1.setPriority(1);
      nature1.start();
    }
  }

  class Stop implements ActionListener {
    /**
     *
     * @param e the event to be processed after stop which is end the program by
     *          ending threads
     */
    public void actionPerformed(ActionEvent e) {
      nature3.kill();
      nature2.kill();
      nature1.kill();
      modelTemp.kill();
      modelHumid.kill();
      modelMoist.kill();
    }
  }

  class NaturalTempEffects extends Thread {
    boolean flag1 = true;

    public void run() {
      while (flag1) {
        if (modelTemp.ACOn) {
          view.ACOn(true);
        } else {
          view.ACOn(false);
        }
        if (modelTemp.furnaceOn) {
          view.FurnaceOn(true);
        } else {
          view.FurnaceOn(false);
        }
        this.setPriority(1);
        if (currentTemp != modelTemp.currentTemp) {
          currentTemp = modelTemp.currentTemp;
          view.setTemp(currentTemp);
        }
        try {
          Thread.sleep(Math.round(view.getTempDiagRate() * 1000.0));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        modelTemp.changeTemp(view.getExtTempImpact() / (60.0 / (view.getTempDiagRate())));
      }
    }

    public void kill() {
      flag1 = false;
    }
  }

  class NaturalHumidEffects extends Thread {
    boolean flag2 = true;

    public void run() {
      while (flag2) {
        if (modelHumid.humidifierOn) {
          view.HumidifierOn(true);
        } else {
          view.HumidifierOn(false);
        }
        this.setPriority(1);
        if (currentHumid != modelHumid.currentHumid) {
          currentHumid = modelHumid.currentHumid;
          view.setHumid(currentHumid);
        }
        try {
          Thread.sleep(Math.round(view.getHumidDiagRate() * 1000.0));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        modelHumid.changeHumid(view.getExtHumidImpact() / (60.0 / (view.getHumidDiagRate())));
      }
    }

    public void kill() {
      flag2 = false;
    }
  }

  class NaturalMoistEffects extends Thread {
    boolean flag3 = true;

    public void run() {
      while (flag3) {
        if (modelMoist.SprinklerOn) {
          view.SprinklerOn(true);
        } else {
          view.SprinklerOn(false);
        }
        this.setPriority(1);
        if (currentMoist != modelMoist.currentMoist) {
          currentMoist = modelMoist.currentMoist;
          view.setMoist(currentMoist);
        }
        try {
          Thread.sleep(Math.round(view.getMoistDiagRate() * 1000.0));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        modelMoist.changeMoist(view.getExtMoistImpact() / (60.0 / (view.getMoistDiagRate())));
      }
    }

    public void kill() {
      flag3 = false;
    }
  }

  /**
   *
   * @param args are the parameters of main method
   */
  public static void main(String[] args) {
    SimulationView view = new SimulationView();
    TempController modelTemp = new TempController();
    HumidityController modelHumid = new HumidityController();
    MoistureController modelMoist = new MoistureController();
    EnvironmentController controller = new EnvironmentController(view, modelTemp, modelHumid, modelMoist);
  }
}
