public interface Radio {
        public void toggle();  //enciende el radio
        public boolean getState();  //devuelve el estado del radio, si esta encendido o apagado
        public void changeFrequency();  //cambia la frecuencia de AM a FM y vice versa
        public void changeStation(boolean up);   //cambia la estacion u emisora
        public boolean getFrequency(); //devuelve la frecuencia en la que se encuentra el radio
        public void saveStation(int numButton);  //guarda la estacion en determiado boton
        public void changeStationButton(int numButton);  //cambia la emisora a una que ya este guardada
        public double getStation();   //devuelve la emisora en la que se encuentra el radio
}
