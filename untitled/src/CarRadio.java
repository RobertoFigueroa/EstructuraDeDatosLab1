
import java.lang.reflect.Array;

public class CarRadio {
    private boolean isOn;
    private boolean isFM;
    private double currentStationFM;
    private double currentStationAM;
    private double[] savedStationsFM;
    private double[] savedStationsAM;
    private double minFM = 87.9;
    private double maxFM = 107.9;
    private double minAM = 530;
    private double maxAM = 1610;

    //Constructor
    public CarRadio(){
        this.isOn=false;
        this.isFM=true;
        this.currentStationFM=87.9;
        this.currentStationAM=530;
        }
    }
