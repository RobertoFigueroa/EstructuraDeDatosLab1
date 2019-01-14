
import java.lang.reflect.Array;

public class CarRadio implements Radio {
    private boolean isOn;
    private boolean isFM;
    private double currentStationFM;
    private double currentStationAM;
    private double[] savedStationsFM;
    private double[] savedStationsAM;
    public static final double minFM = 87.9;
    public static final double maxFM = 107.9;
    public static final double minAM = 530;
    public static final double maxAM = 1610;
    public static final double fmIncrease=0.2;
    public static final double amIncrease=10;

    //Constructor
    public CarRadio() {
        this.isOn = false;
        this.isFM = true;
        this.currentStationFM = 87.9;
        this.currentStationAM = 530;
        this.savedStationsFM= new double[12];
        this.savedStationsAM= new double[12];
    }

    @Override
    public void toggle() {
        this.isOn=!isOn;
    }

    @Override
    public boolean getState() {
        return this.isOn;
    }

    @Override
    public void changeFrequency() {
        this.isFM=!isFM;
    }

    @Override
    public void changeStation(boolean up) {
        if (up && isFM){
            this.currentStationFM=this.currentStationFM+fmIncrease;
        }
        else if (!up && isFM){
            this.currentStationFM=this.currentStationFM-fmIncrease;
        }
        else if (up && !isFM){
            this.currentStationAM=this.currentStationAM+amIncrease;
        }
        else if (!up && !isFM){
            this.currentStationAM=this.currentStationAM-amIncrease;
        }

    }

    @Override
    public boolean getFrequency() {
        return this.isFM;
    }

    @Override
    public void saveStation(int numButton) {
        if (isFM){
            savedStationsFM[numButton]=currentStationFM;
        }
        else{
            savedStationsAM[numButton]=currentStationAM;
        }
    }

    @Override
    public void changeStationButton(int numButton) {

    }

    @Override
    public double getStation() {
        if (isFM){
            return currentStationFM;
        }
        else{
            return currentStationAM;
        }
    }
}