
import java.lang.reflect.Array;

public class CarRadio implements Radio {
    private boolean isOn;
    private boolean isFM;
    private double currentStationFM;
    private double currentStationAM;
    private double[] savedStationsFM;
    private double[] savedStationsAM;
    private static final double minFM = 87.9;
    private static final double maxFM = 107.9;
    private static final double minAM = 530;
    private static final double maxAM = 1610;
    private static final double fmIncrease=0.2;
    private static final double amIncrease=10;

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
            if (currentStationFM> maxFM){
                this.currentStationFM=minFM;
            }
        }
        else if (!up && isFM){
            this.currentStationFM=this.currentStationFM-fmIncrease;
            if (this.currentStationFM< minFM){
                this.currentStationFM=maxFM;
            }
        }
        else if (up && !isFM){
            this.currentStationAM=this.currentStationAM+amIncrease;
            if (this.currentStationAM> maxAM){
                this.currentStationAM=minAM;
            }
        }
        else{
            this.currentStationAM=this.currentStationAM-amIncrease;
            if (this.currentStationAM < minAM){
                this.currentStationAM=maxAM;
            }
        }

    }

    @Override
    public boolean getFrequency() {
        return this.isFM;
    }

    @Override
    public void saveStation(int numButton) {
        if (isFM){
            savedStationsFM[numButton-1]=currentStationFM;
        }
        else{
            savedStationsAM[numButton-1]=currentStationAM;
        }
    }

    @Override
    public void changeStationButton(int numButton) {
        if (isFM){
            this.currentStationFM=savedStationsFM[numButton-1];
        }
        else{
            this.currentStationAM=savedStationsAM[numButton-1];
        }
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