import java.util.Scanner;
public class  Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Radio radio = new CarRadio();
        radio.toggle();
        while(radio.getState()==true) {
            System.out.println("Menu: \n 1.Prender/Apagar \n 2.Cambiar frecuencia \n 3.Avanzar dial \n 4.Retroceder dial \n 5.Guarda emisora \n 6.Cambiar dial con boton");
            System.out.print("Ingrese una opcion -------> ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1: //prender el radio
                    radio.toggle();
                    break;
                case 2: //cambiar frecuencia
                    radio.changeFrequency();
                    break;
                case 3: //avanzar dial
                    radio.changeStation(true);
                    break;
                case 4: //retroceder dial
                    radio.changeStation(false);
                    break;
                case 5: //guardar emisora
                    System.out.print("Ingrese un numero (del 1 al 12)  para guardar la emisora: --- >");
                    int num = sc.nextInt();
                    try {
                        radio.saveStation(num);
                        System.out.println("Guardada con exito!");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Numero fuera de rango, intente de nuevo!");
                    }
                    break;
                case 6: //cambiar con boton el dial
                    System.out.println("Ingrese el numero del boton :  ");
                    int btn = sc.nextInt();
                    try{
                        radio.changeStationButton(btn);
                        System.out.println();
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Numero fuera de rango!");
                    }

                break;
                default:
                    System.out.println("Ingrese un numero dentro del rango de opciones");
                    break;
            }
            String frequency;
            if(radio.getFrequency()==true){
                frequency = "FM";
            }
            else{
                frequency = "AM";
            }
            if (!radio.getState()) {
                System.out.println(" ___________________________________________________________");
                System.out.println("|   Off                                                    |");
                System.out.println(" ___________________________________________________________");
            } else {
                System.out.println(" ___________________________________________________________");
                System.out.println("   On                                                    ");
                System.out.println("|   " + frequency + "                            |");
                System.out.println("|   " + radio.getStation() + "                                                   |");
                System.out.println(" ___________________________________________________________");
            }
            System.out.println("1 2 3 4 5 6 7 8 9 10 11 12");
        }
        }
    }