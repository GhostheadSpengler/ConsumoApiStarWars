import java.util.Scanner;

public class PruebasRandom {

    public static void main(String[] args) {
        Scanner variable = new Scanner(System.in);
        int saldo = 0;
        int intentos = 0;
        double deposito=0;

        for (int i = 0; i <= 3; i++) {


            System.out.println("Menu Random\n");

            System.out.println("""
                    SELECCIONA LA ACCION A REALIZAR DEL MENU:
                    1. Consulta Saldo\n 2.Deposito\n 3. Retiro\n""");

            int menu = variable.nextInt();

            if (menu == 1) {
                System.out.println("Tu saldo es de: $800");
            } else if (menu == 2) {
                System.out.println("Ingresa la cantidad que deseas depositar:");
                double dinero = variable.nextInt();
                deposito=+ dinero;
                System.out.println("Tu saldo depositado es de:" + deposito + 5);

            } else {
                System.out.println("Fin del Programa");
            }

        }
        System.out.println("Maximo de veces alcanzado");
    }
}

