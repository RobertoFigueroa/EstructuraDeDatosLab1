import static org.junit.Assert.*;

public class CarRadioTest {

    @org.junit.Test
    public void getState() {
        Radio radio = new CarRadio();
        radio.toggle();
        assertTrue(radio.getState());

    }

    @org.junit.Test
    public void getFrequency() {
        Radio radio = new CarRadio();
        assertTrue(radio.getFrequency());
    }

    @org.junit.Test
    public void getStation() {
        Radio radio = new CarRadio();
        double expected = radio.getStation();
        radio.changeStation(true);
        double actual = radio.getStation();
        assertEquals(expected,actual,radio.getStation());

    }
}