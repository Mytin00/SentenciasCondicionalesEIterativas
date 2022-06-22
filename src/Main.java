import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcionMenuPrincipal=0;

        while (opcionMenuPrincipal < 5){
            // menu
            opcionMenuPrincipal=menuEjercicios();
            //lo que devuelve del menu lo pasa al metodo que ejecuta las funciones elegidas
            opcionComparar(opcionMenuPrincipal);
        } ;

    }

    public static String evaluaNota(int nota){

        if (nota <=5){
            return "Desaprobado";
        } else if (nota>5 && nota <9) { // el segundo if es para el promedio mayor a 5 pero menor 9
            return "Aprobado";
        } else {
            return "Felicitaciones!! Promocionado!!!"; // si tiene promedio igual o mayor a 9
        }

    }

    // metodo Menu
    public static int menuEjercicios () {

        //permite interactuar con la consola de usuario
        Scanner miScanner = new Scanner(System.in);

        System.out.println("##############################################");
        System.out.println("Opciones de Ejercicios a ejecutar:");
        System.out.println("##############################################");

        System.out.println("1) Comparar 2 numeros ");
        System.out.println("2) Carrito de compra ");
        System.out.println("3) Notas de Alumnos ");
        System.out.println("4) Grafico Asteriscos");
        System.out.println("5) Salir del menu ");
        System.out.println("##############################################");

        System.out.println("Ingrese un opcion:");
        int nroEjercicio = miScanner.nextInt();

        return nroEjercicio;
    }
     public static void  opcionComparar(int opcion){
         switch (opcion) {
             case 1: {
                opcionComparaNumeros();
                break;
             }
             case 2: {
                 opcionCarrito();
                 break;
             }
             case 3: {
                 opcionAlumnos();
                 break;
             }
             case 4: {
                 opcionGraficoAsteriscos();
                 break;
             }
             case 5: {
                 System.out.println("Ud. decicio Salir del Menu!!");
                 break;
             }
             default: {
                 System.out.println("Ud. ingreso una opcion no valida, Reintente nuevamente!!");
                break;
             }
         }
         System.out.println("#########################################");
         System.out.println("");
         return;
     }

     public static void opcionComparaNumeros(){

         //permite interactuar con la consola de usuario
         Scanner miScanner = new Scanner(System.in);

         System.out.println("Ingrese un numero");
         int primerNumero = miScanner.nextInt();
         System.out.println("Ingrese otro numero");
         int segundoNumero = miScanner.nextInt();

         if (primerNumero > segundoNumero) {
             System.out.println("El mayor valor es:" + primerNumero);
         } else if (segundoNumero > primerNumero){
             System.out.println("El mayor valor es:"+ segundoNumero);
         } else {
             System.out.println("Ambos numeros son iguales");
         }
        return;
     }
     public static void opcionCarrito(){

        Scanner miScanner = new Scanner(System.in);
        System.out.println("Ingrese nombre de producto!");
        String nombreProducto = miScanner.nextLine();
        System.out.println("Ingrese Precio de producto!");
        double precioProducto = miScanner.nextDouble();

        boolean cierreTransaccion= true;

        do {

            System.out.println("Ingrese Metodo de Pago");
            System.out.println("1) Contado - 15% Dto");
            System.out.println("2) Debito ");
            System.out.println("3) Tarjeta - 10% Recargo");

            int metodoPago = miScanner.nextInt();

            System.out.println("Resumen Operacion");
            System.out.println("Producto: " + nombreProducto);

            switch (metodoPago) {
                case 1: {
                    System.out.println("Precio Abonar:" + precioProducto * .85);
                    cierreTransaccion = false;
                    break;
                }
                case 2: {
                    System.out.println("Precio Abonar:" + precioProducto);
                    cierreTransaccion = false;
                    break;
                }
                case 3: {
                    System.out.println("Precio Abonar:" + precioProducto * 1.1);
                    cierreTransaccion = false;
                    break;
                }
                default: {
                    System.out.println("No ha ingresado una opcion valida!");
                }
            }
        }while (cierreTransaccion);

     }
     public static void opcionAlumnos(){
         //permite interactuar con la consola de usuario
         Scanner miScanner = new Scanner(System.in);

         System.out.println("Ingrese nombre de alumno:");
         String nombreAlumno = miScanner.nextLine();

         int promedioNotas=0; // variable para guardar promedio que usare para definir si aprobo o no
         int cantidadNotasRequeridas=5; // la cantidad de notas que quiero q ingrese
         int cantidadNotasValidas=1; // acumulare los ingresos validos dentro del while
         int totalNotas=0; // variable donde acumulo las notas ingresadas

         //aca controlo que solo ingresen la cantidad de notas que defini en la variable cantidadNotasIngresadas
         while (cantidadNotasValidas <= cantidadNotasRequeridas) {

             System.out.println("Ingrese Nota Nro:" + cantidadNotasValidas);
             int ingresoNota = miScanner.nextInt();
             // aca valido q la nota no sea superior a 10
             if (ingresoNota <= 10) {
                 totalNotas = totalNotas + ingresoNota;
                 cantidadNotasValidas++;
             } else {
                 System.out.println("################");
                 System.out.println(" ERROR!! Ingrese un valor valido del 1 al 10 SOLAMENTE!!");
                 System.out.println("################");
             }
         }

         // la variable promedioNota la saco sumando las notas y diviendo por 3 que son las notas ingresadas
         promedioNotas = totalNotas/cantidadNotasRequeridas;

         System.out.println("#########################################################");
         System.out.println("Alumno: " + nombreAlumno);
         System.out.println("Promedio: " + promedioNotas);
         System.out.println("#########################################################");

         System.out.println( evaluaNota(promedioNotas));

     }
     public static void opcionGraficoAsteriscos() {

         String caracterAsterisco = "*";

         for (int i = 0; i < 7; i++) {
             System.out.println(caracterAsterisco);
             caracterAsterisco = caracterAsterisco + "*";
         }

         System.out.println("////////////////////");

         for (int j = 0; j < 7; j++) {
             caracterAsterisco = "";
             int maxChars = 7 - j;

             for (int k = 0; k < maxChars; k++) {
                 caracterAsterisco = caracterAsterisco + "*";
             }
             System.out.println(caracterAsterisco);
         }
         System.out.println("////////////////////");
         ;


         for (int j = 1; j < 8; j++) {
             int maxChars= 7 - j;
             caracterAsterisco = "";

             for (int i = 0; i < maxChars; i++) {
               caracterAsterisco=caracterAsterisco+" ";
             }

             for (int i = 0; i < j ; i++) {
                caracterAsterisco=caracterAsterisco+"*";
             }
             System.out.println(caracterAsterisco);

         }

    }
}
