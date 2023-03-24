import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Parqueadero {

    static int contador = 0;

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Stack<Vehiculo> dosRuedas = new Stack<Vehiculo>();
        Stack<Vehiculo> cuatroRuedas = new Stack<Vehiculo>();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("1. Ingreso de vehículo");
            System.out.println("2. Visualizar tabla actualizada con la información ingresada e incluya el valor a pagar");
            System.out.println("3. Visualizar en una lista los vehículos de 2 ruedas e incluir el valor a pagar en total");
            System.out.println("4. Visualizar en una lista los vehículos de 4 ruedas e incluir el valor a pagar en total");
            System.out.println("5. Cantidad de vehículos en parqueadero y valor total a pagar");
            System.out.println("6. Eliminar algún vehículo");
            System.out.println("7. Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la placa del vehículo: ");
                    String placa = sc.next();
                    System.out.println("Ingrese el tipo de vehículo (B: bicicleta, M: motocicleta, C: carro): ");
                    char tipo = sc.next().charAt(0);
                    System.out.println("Ingrese la hora de ingreso (formato 24 horas): ");
                    int hora = sc.nextInt();
                    Vehiculo vehiculo = new Vehiculo(++contador, placa, tipo, hora);
                    vehiculos.add(vehiculo);
                    if (tipo == 'B' || tipo == 'M') {
                        dosRuedas.push(vehiculo);
                    } else {
                        cuatroRuedas.push(vehiculo);
                    }
                    break;
                case 2:
                    System.out.println("Vehículos en el parqueadero:");
                    System.out.println("Numero | Placa | Tipo | Hora de ingreso | Valor a pagar");
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v.toString());
                    }
                    break;
                case 3:
                    System.out.println("Vehículos de 2 ruedas en el parqueadero:");
                    System.out.println("Numero | Placa | Tipo | Hora de ingreso | Valor a pagar");
                    int total2Ruedas = 0;
                    while (!dosRuedas.isEmpty()) {
                        Vehiculo v = dosRuedas.pop();
                        System.out.println(v.toString());
                        total2Ruedas += v.calcularValor();
                    }
                    System.out.println("Valor total a pagar por vehículos de 2 ruedas: " + total2Ruedas);
                    break;
                case 4:
                    System.out.println("Vehículos de 4 ruedas en el parqueadero:");
                    System.out.println("Numero | Placa | Tipo | Hora de ingreso | Valor a pagar");
                    int total4Ruedas = 0;
                    while (!cuatroRuedas.isEmpty()) {
                        Vehiculo v = cuatroRuedas.pop();
                        System.out.println(v.toString());
                        total4Ruedas += v.calcularValor();
                    }
                    System.out.println("Valor total a pagar por vehículos de 4 ruedas: " + total4Ruedas);
break;
case 5:
int totalVehiculos = vehiculos.size();
int totalPagar = 0;
for (Vehiculo v : vehiculos) {
totalPagar += v.calcularValor();
}
System.out.println("Cantidad de vehículos en el parqueadero: " + totalVehiculos);
System.out.println("Valor total a pagar por todos los vehículos: " + totalPagar);
break;
case 6:
System.out.println("Ingrese el número del vehículo que desea eliminar: ");
int num = sc.nextInt();
for (int i = 0; i < vehiculos.size(); i++) {
if (vehiculos.get(i).getNumero() == num) {
Vehiculo v = vehiculos.remove(i);
if (v.getTipo() == 'B' || v.getTipo() == 'M') {
dosRuedas.remove(v);
} else {
cuatroRuedas.remove(v);
}
System.out.println("El vehículo con número " + num + " ha sido eliminado.");
break;
}
}
break;
case 7:
System.out.println("Saliendo del programa...");
break;
default:
System.out.println("Opción inválida, intente nuevamente.");
break;
}
} while (opcion != 7);
    }
}
class Vehiculo {
private int numero;
private String placa;
private char tipo;
private int horaIngreso;
public Vehiculo(int numero, String placa, char tipo, int horaIngreso) {
    this.numero = numero;
    this.placa = placa;
    this.tipo = tipo;
    this.horaIngreso = horaIngreso;
}

public int getNumero() {
    return numero;
}

public String getPlaca() {
    return placa;
}

public char getTipo() {
    return tipo;
}

public int getHoraIngreso() {
    return horaIngreso;
}

public int calcularValor() {
    int valorMinuto = 0;
    if (tipo == 'B' || tipo == 'C') {
        valorMinuto = 20000;
    } else if (tipo == 'M') {
        valorMinuto = 30000;
    }
    int tiempo = Parqueadero.contadorHora - horaIngreso;
    int valorPagar = valorMinuto * tiempo;
    return valorPagar;
}

public String toString() {
    int valorPagar = calcularValor();
    String tipoString = "";
    switch (tipo) {
        case 'B':
            tipoString = "Bicicleta";
            break;
        case 'M':
            tipoString = "Motocicleta";
            break;
        case 'C':
            tipoString = "Carro";
            break;
        default:
            tipoString = "Tipo inválido";
            break;
    }
    return numero + " | " + placa + " | " + tipoString + " | " + horaIngreso + " | " + valorPagar;
}
}