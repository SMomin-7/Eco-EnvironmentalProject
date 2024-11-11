import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @since 1.6
 * @author Shaim_Momin
 * @version 1.0
 */
public class SimulationView extends JFrame {

  private JButton TControls;
  private JButton MControls;
  private JButton HControls;
  public Container homeScreen;

  private JLabel optTempLabel;
  private JTextField optTempTF;
  private JLabel initTempLabel;
  private JTextField initTempTF;
  private JLabel ACSpeedLabel;
  private JTextField ACSpeedTF;
  private JLabel FurnaceSpeedLabel;
  private JTextField FurnaceSpeedTF;
  private JLabel ExtTempLabel;
  private JTextField ExtTempTF;
  private JLabel TDiagLabel;
  private JTextField TDiagTF;
  public int controlPanelButton = 1;

  private JLabel optMoistLabel1;
  private JTextField optMoistTF1;
  private JLabel optMoistLabel2;
  private JTextField optMoistTF2;
  private JLabel initMoistLabel;
  private JTextField initMoistTF;
  private JLabel sprinklerSpeedLabel;
  private JTextField sprinklerSpeedTF;
  private JLabel MDiagLabel;
  private JTextField MDiagTF;
  private JLabel ExtMoistLabel;
  private JTextField ExtMoistTF;

  private JLabel optHumidLabel1;
  private JTextField optHumidTF1;
  private JLabel optHumidLabel2;
  private JTextField optHumidTF2;
  private JLabel initHumidLabel;
  private JTextField initHumidTF;
  private JLabel HumidifierSpeedLabel;
  private JTextField HumidifierSpeedTF;
  private JLabel HDiagLabel;
  private JTextField HDiagTF;
  private JLabel ExtHumidLabel;
  private JTextField ExtHumidTF;
  private JButton StartButton;
  private JButton StopButton;

  private JSlider MoistSlide;
  private JSlider HumidSlide;

  // Simulation Environment Visuals:
  private JLabel simLabel;
  private JLabel TempLabel;
  private JButton TempButton;
  private JLabel MoistLabel;
  private JButton MoistButton;
  private JLabel HumidLabel;
  private JButton HumidButton;
  private JLabel ACStat;
  private JLabel FurnaceStat;
  private JLabel SprinklerStat;
  private JLabel HumidifierStat;

  /**
   * SimulationView constructor to create JFrame
   */
  public SimulationView() {
    super();
    super.setSize(1200, 600);
    setLocationRelativeTo(rootPane);

    TControls = new JButton("Temp Ctrls");
    MControls = new JButton("Moisture Ctrls");
    HControls = new JButton("Humidity Ctrls");
    StartButton = new JButton("Start Simulation");
    StopButton = new JButton("Stop Simulation");

    TControls.setBounds(37, 20, 150, 25);
    MControls.setBounds(225, 20, 150, 25);
    HControls.setBounds(413, 20, 150, 25);
    StartButton.setBounds(37, 330, 215, 25);
    StopButton.setBounds(318, 330, 215, 25);

    TControls.setBackground(Color.ORANGE);
    MControls.setBackground(Color.LIGHT_GRAY);
    HControls.setBackground(Color.LIGHT_GRAY);
    StartButton.setBackground(Color.GREEN);
    StopButton.setBackground(Color.RED);

    TControls.setForeground(Color.BLACK);
    MControls.setForeground(Color.BLACK);
    HControls.setForeground(Color.BLACK);
    StopButton.setForeground(Color.BLACK);

    simLabel = new JLabel("Simulation Environment");
    simLabel.setBounds(800, 35, 200, 25);
    simLabel.setBackground(Color.BLACK);
    simLabel.setForeground(Color.PINK);

    TempLabel = new JLabel("Current Greenhouse Temperature: -- °C");
    TempLabel.setBounds(750, 75, 300, 25);
    TempLabel.setForeground(Color.WHITE);

    MoistSlide = new JSlider();
    MoistSlide.setBounds(725, 155, 300, 25);
    MoistSlide.setFocusable(false);
    MoistSlide.setBackground(Color.DARK_GRAY);

    HumidSlide = new JSlider();
    HumidSlide.setBounds(725, 235, 300, 25);
    HumidSlide.setFocusable(false);
    HumidSlide.setBackground(Color.DARK_GRAY);

    TempButton = new JButton();
    TempButton.setBounds(698, 75, 25, 25);
    TempButton.setBackground(Color.GREEN);

    MoistLabel = new JLabel("Current Soil Saturation: -- %");
    MoistLabel.setBounds(750, 115, 300, 25);
    MoistLabel.setForeground(Color.WHITE);

    MoistButton = new JButton();
    MoistButton.setBounds(698, 115, 25, 25);
    MoistButton.setBackground(Color.GREEN);

    HumidLabel = new JLabel("Current Humidity: -- %");
    HumidLabel.setBounds(750, 195, 300, 25);
    HumidLabel.setForeground(Color.WHITE);

    HumidButton = new JButton();
    HumidButton.setBounds(698, 195, 25, 25);
    HumidButton.setBackground(Color.GREEN);

    ACStat = new JLabel("Air Conditioning Status: ");
    ACStat.setBounds(750, 275, 300, 25);
    ACStat.setForeground(Color.WHITE);

    FurnaceStat = new JLabel("Furnace Status: ");
    FurnaceStat.setBounds(750, 315, 300, 25);
    FurnaceStat.setForeground(Color.WHITE);

    SprinklerStat = new JLabel("Sprinkler Status: ");
    SprinklerStat.setBounds(750, 355, 300, 25);
    SprinklerStat.setForeground(Color.WHITE);

    HumidifierStat = new JLabel("Humidifier Status: ");
    HumidifierStat.setBounds(750, 395, 300, 25);
    HumidifierStat.setForeground(Color.WHITE);

    optTempLabel = new JLabel("Enter Optimal Temperature (°C):");
    optTempLabel.setBounds(37, 70, 350, 25);
    optTempLabel.setForeground(Color.WHITE);

    initTempLabel = new JLabel("Enter Initial Temperature (°C):");
    initTempLabel.setBounds(37, 110, 350, 25);
    initTempLabel.setForeground(Color.WHITE);

    ACSpeedLabel = new JLabel("Enter AC Cooling Rate (°C/min):");
    ACSpeedLabel.setBounds(37, 150, 350, 25);
    ACSpeedLabel.setForeground(Color.WHITE);

    FurnaceSpeedLabel = new JLabel("Enter Furnace Heating Rate (°C/min):");
    FurnaceSpeedLabel.setBounds(37, 190, 350, 25);
    FurnaceSpeedLabel.setForeground(Color.WHITE);

    ExtTempLabel = new JLabel("Enter External Temp Influence (°C/min):");
    ExtTempLabel.setBounds(37, 230, 350, 25);
    ExtTempLabel.setForeground(Color.WHITE);

    TDiagLabel = new JLabel("Enter Temp Controller Update Rate (sec)):");
    TDiagLabel.setBounds(37, 270, 350, 25);
    TDiagLabel.setForeground(Color.WHITE);

    optTempTF = new JTextField(20);
    optTempTF.setBounds(327, 70, 165, 25);
    initTempTF = new JTextField(20);
    initTempTF.setBounds(327, 110, 165, 25);
    ACSpeedTF = new JTextField(20);
    ACSpeedTF.setBounds(327, 150, 165, 25);

    FurnaceSpeedTF = new JTextField(20);
    FurnaceSpeedTF.setBounds(327, 190, 165, 25);

    ExtTempTF = new JTextField(20);
    ExtTempTF.setBounds(327, 230, 165, 25);

    TDiagTF = new JTextField(20);
    TDiagTF.setBounds(327, 270, 165, 25);

    optMoistLabel1 = new JLabel("Enter End of Optimal Moisture Range(%):");
    optMoistLabel1.setBounds(37, 70, 350, 25);
    optMoistLabel1.setForeground(Color.WHITE);
    optMoistLabel1.setVisible(false);

    optMoistLabel2 = new JLabel("Enter Start of Optimal Moisture Range(%):");
    optMoistLabel2.setBounds(37, 110, 350, 25);
    optMoistLabel2.setForeground(Color.WHITE);
    optMoistLabel2.setVisible(false);

    initMoistLabel = new JLabel("Enter Initial Moisture Level(%): ");
    initMoistLabel.setBounds(37, 150, 350, 25);
    initMoistLabel.setForeground(Color.WHITE);
    initMoistLabel.setVisible(false);

    sprinklerSpeedLabel = new JLabel("Enter Sprinkler Saturation Rate(%/min):");
    sprinklerSpeedLabel.setBounds(37, 190, 350, 25);
    sprinklerSpeedLabel.setForeground(Color.WHITE);
    sprinklerSpeedLabel.setVisible(false);

    MDiagLabel = new JLabel("Enter Moisture Controller Update Rate (sec)):");
    MDiagLabel.setBounds(37, 230, 350, 25);
    MDiagLabel.setForeground(Color.WHITE);
    MDiagLabel.setVisible(false);

    ExtMoistLabel = new JLabel("Enter external impact on moisture(%/min)");
    ExtMoistLabel.setBounds(37, 270, 350, 25);
    ExtMoistLabel.setForeground(Color.WHITE);
    ExtMoistLabel.setVisible(false);

    optMoistTF1 = new JTextField(20);
    optMoistTF1.setBounds(327, 70, 165, 25);
    optMoistTF1.setVisible(false);

    optMoistTF2 = new JTextField(20);
    optMoistTF2.setBounds(327, 110, 165, 25);
    optMoistTF2.setVisible(false);

    initMoistTF = new JTextField(20);
    initMoistTF.setBounds(327, 150, 165, 25);
    initMoistTF.setVisible(false);

    sprinklerSpeedTF = new JTextField(20);
    sprinklerSpeedTF.setBounds(327, 190, 165, 25);
    sprinklerSpeedTF.setVisible(false);

    MDiagTF = new JTextField(20);
    MDiagTF.setBounds(327, 230, 165, 25);
    MDiagTF.setVisible(false);

    ExtMoistTF = new JTextField(20);
    ExtMoistTF.setBounds(327, 270, 165, 25);
    ExtMoistTF.setVisible(false);

    optHumidLabel1 = new JLabel("Enter End of Optimal Humidity Range(%):");
    optHumidLabel1.setBounds(37, 70, 350, 25);
    optHumidLabel1.setForeground(Color.WHITE);
    optHumidLabel1.setVisible(false);

    optHumidLabel2 = new JLabel("Enter Start of Optimal Humidity Range(%):");
    optHumidLabel2.setBounds(37, 110, 350, 25);
    optHumidLabel2.setForeground(Color.WHITE);
    optHumidLabel2.setVisible(false);

    initHumidLabel = new JLabel("Enter Initial Humidity Level(%): ");
    initHumidLabel.setBounds(37, 150, 350, 25);
    initHumidLabel.setForeground(Color.WHITE);
    initHumidLabel.setVisible(false);

    HumidifierSpeedLabel = new JLabel("Enter Humidifying Rate(%/min):");
    HumidifierSpeedLabel.setBounds(37, 190, 350, 25);
    HumidifierSpeedLabel.setForeground(Color.WHITE);
    HumidifierSpeedLabel.setVisible(false);

    HDiagLabel = new JLabel("Enter Humidity Controller Update Rate (sec)):");
    HDiagLabel.setBounds(37, 230, 350, 25);
    HDiagLabel.setForeground(Color.WHITE);
    HDiagLabel.setVisible(false);

    ExtHumidLabel = new JLabel("Enter external impact on humidity(%/min)");
    ExtHumidLabel.setBounds(37, 270, 350, 25);
    ExtHumidLabel.setForeground(Color.WHITE);
    ExtHumidLabel.setVisible(false);

    optHumidTF1 = new JTextField(20);
    optHumidTF1.setBounds(327, 70, 165, 25);
    optHumidTF1.setVisible(false);

    optHumidTF2 = new JTextField(20);
    optHumidTF2.setBounds(327, 110, 165, 25);
    optHumidTF2.setVisible(false);

    initHumidTF = new JTextField(20);
    initHumidTF.setBounds(327, 150, 165, 25);
    initHumidTF.setVisible(false);

    HumidifierSpeedTF = new JTextField(20);
    HumidifierSpeedTF.setBounds(327, 190, 165, 25);
    HumidifierSpeedTF.setVisible(false);

    HDiagTF = new JTextField(20);
    HDiagTF.setBounds(327, 230, 165, 25);
    HDiagTF.setVisible(false);

    ExtHumidTF = new JTextField(20);
    ExtHumidTF.setBounds(327, 270, 165, 25);
    ExtHumidTF.setVisible(false);
    homeScreen = getContentPane();
    homeScreen.setLayout(null);
    homeScreen.setSize(1200, 600);
    homeScreen.add(HControls);
    homeScreen.add(MControls);
    homeScreen.add(TControls);
    homeScreen.add(simLabel);
    homeScreen.add(optTempLabel);
    homeScreen.add(initTempLabel);
    homeScreen.add(ACSpeedLabel);
    homeScreen.add(optTempTF);
    homeScreen.add(initTempTF);
    homeScreen.add(ACSpeedTF);
    homeScreen.add(FurnaceSpeedTF);
    homeScreen.add(FurnaceSpeedLabel);
    homeScreen.add(ExtTempTF);
    homeScreen.add(ExtTempLabel);
    homeScreen.add(TDiagLabel);
    homeScreen.add(TDiagTF);
    homeScreen.add(TempLabel);
    homeScreen.add(TempButton);
    homeScreen.add(MoistLabel);
    homeScreen.add(MoistButton);
    homeScreen.add(HumidLabel);
    homeScreen.add(HumidButton);
    homeScreen.add(ACStat);
    homeScreen.add(FurnaceStat);
    homeScreen.add(SprinklerStat);
    homeScreen.add(HumidifierStat);
    homeScreen.add(optMoistLabel1);
    homeScreen.add(optMoistTF1);
    homeScreen.add(optMoistLabel2);
    homeScreen.add(optMoistTF2);
    homeScreen.add(initMoistLabel);
    homeScreen.add(initMoistTF);
    homeScreen.add(sprinklerSpeedLabel);
    homeScreen.add(sprinklerSpeedTF);
    homeScreen.add(MDiagLabel);
    homeScreen.add(MDiagTF);
    homeScreen.add(StartButton);
    homeScreen.add(StopButton);
    homeScreen.add(optHumidLabel1);
    homeScreen.add(optHumidTF1);
    homeScreen.add(optHumidLabel2);
    homeScreen.add(optHumidTF2);
    homeScreen.add(initHumidLabel);
    homeScreen.add(initHumidTF);
    homeScreen.add(HumidifierSpeedLabel);
    homeScreen.add(HumidifierSpeedTF);
    homeScreen.add(HDiagLabel);
    homeScreen.add(HDiagTF);
    homeScreen.add(ExtHumidLabel);
    homeScreen.add(ExtHumidTF);
    homeScreen.add(ExtMoistLabel);
    homeScreen.add(ExtMoistTF);
    homeScreen.add(MoistSlide);
    homeScreen.add(HumidSlide);
    StopButton.setFocusable(false);
    StartButton.setFocusable(false);
    HControls.setFocusable(false);
    MControls.setFocusable(false);
    TControls.setFocusable(false);
    homeScreen.setBackground(Color.BLACK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    homeScreen.setVisible(true);
    super.setVisible(true);

  }

  /**
   * Method to invoke the buttons
   * 
   * @param TControls - temperature controls
   * @param MControls - Moisture control
   * @param HControls - heat control
   * @param start     - start button
   * @param stop      - end button
   *
   *
   */
  public void addCalculateListener(ActionListener TControls, ActionListener MControls, ActionListener HControls,
      ActionListener start, ActionListener stop) {
    this.TControls.addActionListener(TControls);
    this.MControls.addActionListener(MControls);
    this.HControls.addActionListener(HControls);
    this.StartButton.addActionListener(start);
    this.StopButton.addActionListener(stop);
  }

  /**
   *
   * @return optimal temp
   */
  public double getOptimalAT() {
    return Double.parseDouble(optTempTF.getText());
  }

  /**
   *
   * @return initial temp
   */
  public double getInitAT() {
    return Double.parseDouble(initTempTF.getText());
  }

  /**
   *
   * @return AC cool rate
   */
  public double getACSpeed() {
    return Double.parseDouble(ACSpeedTF.getText());
  }

  /**
   *
   * @return Furnace Heat Rate
   */
  public double getFurnaceSpeed() {
    return Double.parseDouble(FurnaceSpeedTF.getText());
  }

  /**
   *
   * @return External temp impact
   */
  public double getExtTempImpact() {
    return Double.parseDouble(ExtTempTF.getText());
  }

  /**
   *
   * @return temperatue update rate
   */
  public double getTempDiagRate() {
    return Double.parseDouble(TDiagTF.getText());
  }

  /**
   *
   * @return Humidify update rate
   */
  public double getHumidDiagRate() {
    return Double.parseDouble(HDiagTF.getText());
  }

  /**
   *
   * @return external humidity effect
   */
  public double getExtHumidImpact() {
    return Double.parseDouble(ExtHumidTF.getText());
  }

  /**
   *
   * @return optimum humidity
   */
  public double getoptHumidMin() {
    return Double.parseDouble(optHumidTF2.getText());
  }

  /**
   *
   * @return initial humidity
   */
  public double getinitHumid() {
    return Double.parseDouble(initHumidTF.getText());
  }

  /**
   *
   * @return humidifying speed
   */
  public double getHumidSpeed() {
    return Double.parseDouble(HumidifierSpeedTF.getText());
  }

  /**
   *
   * @return Maximum humidity range
   */
  public double getMaxHumid() {
    return Double.parseDouble(optHumidTF1.getText());
  }

  /**
   *
   * @return Moisturizing rate of soil
   */

  public double getMoistDiagRate() {
    return Double.parseDouble(MDiagTF.getText());
  }

  /**
   *
   * @return external moisture effects
   */
  public double getExtMoistImpact() {
    return Double.parseDouble(ExtMoistTF.getText());
  }

  /**
   *
   * @return optimum Moisture range
   */
  public double getoptMoistMin() {
    return Double.parseDouble(optMoistTF2.getText());
  }

  /**
   *
   * @return initial moisture in soil
   */
  public double getinitMoist() {
    return Double.parseDouble(initMoistTF.getText());
  }

  /**
   *
   * @return Moisturizing speed
   */
  public double getMoistSpeed() {
    return Double.parseDouble(sprinklerSpeedTF.getText());
  }

  /**
   *
   * @return Maximum moisture in soil
   */
  public double getMaxMoist() {
    return Double.parseDouble(optMoistTF1.getText());
  }

  /**
   * @apiNote Changes color of the panes
   */

  public void changeColor() {
    if (controlPanelButton == 1) {
      TControls.setBackground(Color.ORANGE);
      MControls.setBackground(Color.LIGHT_GRAY);
      HControls.setBackground(Color.LIGHT_GRAY);
    } else if (controlPanelButton == 2) {
      TControls.setBackground(Color.LIGHT_GRAY);
      MControls.setBackground(Color.ORANGE);
      HControls.setBackground(Color.LIGHT_GRAY);
    } else if (controlPanelButton == 3) {
      TControls.setBackground(Color.LIGHT_GRAY);
      MControls.setBackground(Color.LIGHT_GRAY);
      HControls.setBackground(Color.ORANGE);
    }
  }

  /**
   *
   * @param currentTemp sets current temperature
   */
  public void setTemp(double currentTemp) {
    double temp = Math.round(currentTemp * 100.0) / 100.0;
    if (temp >= getOptimalAT() + 7 || temp < getOptimalAT() - 7) {
      TempButton.setBackground(Color.RED);
    } else if (temp <= getOptimalAT() + 3 && temp >= getOptimalAT() - 3) {
      TempButton.setBackground(Color.GREEN);
    } else {
      TempButton.setBackground(Color.YELLOW);
    }
    TempLabel.setText("Current Greenhouse Temperature (°C): " + temp);
  }

  /**
   *
   * @param currentHumid sets current humidity
   */
  public void setHumid(double currentHumid) {
    double humid = Math.round(currentHumid * 100.0) / 100.0;
    HumidSlide.setValue((int) humid);
    if (humid > getMaxHumid() + 7 || humid < getoptHumidMin() - 7) {
      HumidButton.setBackground(Color.RED);
    } else if (humid <= getMaxHumid() && humid >= getoptHumidMin()) {
      HumidButton.setBackground(Color.GREEN);
    } else {
      HumidButton.setBackground(Color.YELLOW);
    }
    HumidLabel.setText("Current Humidity(%): " + humid);
  }

  /**
   *
   * @param currentMoist set current moisture
   */
  public void setMoist(double currentMoist) {
    double moist = Math.round(currentMoist * 100.0) / 100.0;
    MoistSlide.setValue((int) moist);
    if (moist > getMaxMoist() + 7 || moist < getoptMoistMin() - 7) {
      MoistButton.setBackground(Color.RED);
    } else if (moist <= getMaxMoist() && moist >= getoptMoistMin()) {
      MoistButton.setBackground(Color.GREEN);
    } else {
      MoistButton.setBackground(Color.YELLOW);
    }
    MoistLabel.setText("Current Soil Saturation%): " + moist);
  }

  /**
   *
   * @param B to check if AC is ON/OFF
   */
  public void ACOn(boolean B) {
    if (B) {
      ACStat.setText("Air Conditioning Status: Running");
    } else {
      ACStat.setText("Air Conditioning Status: Off");
    }
  }

  /**
   *
   * @param B to check if Furnace is ON/OFF
   */
  public void FurnaceOn(boolean B) {
    if (B) {
      FurnaceStat.setText("Furnace Status: Running");
    } else {
      FurnaceStat.setText("Furnace Status: Off");
    }
  }

  /**
   *
   * @param B to check if Humidifier is ON/OFF
   */
  public void HumidifierOn(boolean B) {
    if (B) {
      HumidifierStat.setText("Humidifier Status: Running");
    } else {
      HumidifierStat.setText("Humidifier Status: Off");
    }
  }

  /**
   *
   * @param B to check if Sprinkler is ON/OFF
   */
  public void SprinklerOn(boolean B) {
    if (B) {
      SprinklerStat.setText("Sprinkler Status: Running");
    } else {
      SprinklerStat.setText("Sprinkler Status: Off");
    }
  }

  /**
   * Method to Cover panes accordingly
   */
  public void hideControlPanel() {
    if (optTempLabel.isVisible()) {
      optTempLabel.setVisible(false);
      optTempTF.setVisible(false);
      initTempLabel.setVisible(false);
      initTempTF.setVisible(false);
      ACSpeedLabel.setVisible(false);
      ACSpeedTF.setVisible(false);
      FurnaceSpeedLabel.setVisible(false);
      FurnaceSpeedTF.setVisible(false);
      ExtTempLabel.setVisible(false);
      ExtTempTF.setVisible(false);
      TDiagLabel.setVisible(false);
      TDiagTF.setVisible(false);
    } else if (optMoistTF1.isVisible()) {

      optMoistLabel1.setVisible(false);
      optMoistTF1.setVisible(false);
      optMoistLabel2.setVisible(false);
      optMoistTF2.setVisible(false);
      initMoistLabel.setVisible(false);
      initMoistTF.setVisible(false);
      sprinklerSpeedLabel.setVisible(false);
      sprinklerSpeedTF.setVisible(false);
      MDiagLabel.setVisible(false);
      MDiagTF.setVisible(false);
      ExtMoistLabel.setVisible(false);
      ExtMoistTF.setVisible(false);
    } else if (optHumidTF1.isVisible()) {

      optHumidLabel1.setVisible(false);
      optHumidTF1.setVisible(false);
      optHumidLabel2.setVisible(false);
      optHumidTF2.setVisible(false);
      initHumidLabel.setVisible(false);
      initHumidTF.setVisible(false);
      HumidifierSpeedLabel.setVisible(false);
      HumidifierSpeedTF.setVisible(false);
      HDiagLabel.setVisible(false);
      HDiagTF.setVisible(false);
      ExtHumidLabel.setVisible(false);
      ExtHumidLabel.setVisible(false);
    }
  }

  /**
   * Method to Show panes accordingly
   */
  public void displayControlPanel() {
    if (controlPanelButton == 1) {
      optTempLabel.setVisible(true);
      optTempTF.setVisible(true);
      initTempLabel.setVisible(true);
      initTempTF.setVisible(true);
      ACSpeedLabel.setVisible(true);
      ACSpeedTF.setVisible(true);
      FurnaceSpeedLabel.setVisible(true);
      FurnaceSpeedTF.setVisible(true);
      ExtTempLabel.setVisible(true);
      ExtTempTF.setVisible(true);
      TDiagLabel.setVisible(true);
      TDiagTF.setVisible(true);
    } else if (controlPanelButton == 2) {
      optMoistLabel1.setVisible(true);
      optMoistTF1.setVisible(true);
      optMoistLabel2.setVisible(true);
      optMoistTF2.setVisible(true);
      initMoistLabel.setVisible(true);
      initMoistTF.setVisible(true);
      sprinklerSpeedLabel.setVisible(true);
      sprinklerSpeedTF.setVisible(true);
      MDiagLabel.setVisible(true);
      MDiagTF.setVisible(true);
      ExtMoistLabel.setVisible(true);
      ExtMoistTF.setVisible(true);
    } else if (controlPanelButton == 3) {
      optHumidLabel1.setVisible(true);
      optHumidTF1.setVisible(true);
      optHumidLabel2.setVisible(true);
      optHumidTF2.setVisible(true);
      initHumidLabel.setVisible(true);
      initHumidTF.setVisible(true);
      HumidifierSpeedLabel.setVisible(true);
      HumidifierSpeedTF.setVisible(true);
      HDiagLabel.setVisible(true);
      HDiagTF.setVisible(true);
      ExtHumidLabel.setVisible(true);
      ExtHumidTF.setVisible(true);
    }
  }
}
