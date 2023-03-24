import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TurnosMedicos {
    public static void main(String[] args) {
        Queue<String> turnos = new LinkedList<>(); 
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;
        String afiliacion;
        String condicionEspecial;

        while (true) {
            System.out.println("Bienvenido a la EPS");
            System.out.println("Ingrese su información personal");
            System.out.print("Nombre y apellidos: ");
            nombre = sc.nextLine();
            System.out.print("Edad: ");
            edad = Integer.parseInt(sc.nextLine());
            System.out.print("Afiliación (POS/PC): ");
            afiliacion = sc.nextLine();
            System.out.print("Condición especial (embarazo/limitación motriz): ");
            condicionEspecial = sc.nextLine();
            if (edad >= 60 || edad < 12 || condicionEspecial.equalsIgnoreCase("embarazo") ||
                    condicionEspecial.equalsIgnoreCase("limitación motriz") || afiliacion.equalsIgnoreCase("PC")) {
                turnos.add("P " + nombre); 
                System.out.println("Se le ha asignado un turno prioritario. Su número de turno es: P" + turnos.size());
            } else {
                turnos.add("T " + nombre); 
                System.out.println("Se le ha asignado un turno regular. Su número de turno es: T" + turnos.size());
            }
            try {
                Thread.sleep(5000);
                if (!turnos.isEmpty()) {
                    String siguientePaciente = turnos.remove();
                    System.out.println("Siguiente paciente en la cola: " + siguientePaciente);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
