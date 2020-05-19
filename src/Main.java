import java.io.*;
import java.util.Scanner;
/**
 * Brandon Hernandez 19376
 * @since 17/05/2020
 * @version 18/05/2020
 * @name Main.java
 *
 * Se encarga de ejecutar el programa
 */
public class Main{

    // Arranque del programa 
    public static void main(String[] args){
        Graph<String> graph = new RouteGraph<>();
        Scanner input = new Scanner(System.in);

        boolean flag = false;
        String[] aux;
        String read, option;

        System.out.println("| Se ingresaran  las siguientes relaciones:");
        // Lee el archivo .txt
        try{
            FileReader file = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(file);
            while ((read = buffer.readLine()) != null){
                aux = read.split(" ");

                aux[0] = aux[0].toUpperCase();
                aux[1] = aux[1].toUpperCase();
                graph.add(aux[0]);
                graph.add(aux[1]);

                // Mostrando los datos ingresados a la base de datos
                System.out.println("| Origen: " + aux[0] + " Destino: " + aux[1] + " Distancia: " + aux[2] );

                graph.addEdge(aux[0], aux[1], Integer.parseInt(aux[2]));
                flag = true;
            }

        } catch (Exception e){
            System.out.println("| Un error inesperado ha ocurrido");
        }


        // Realizando las opciones que desea el usuario hasta que se aburra
        if(flag){
            do{

                System.out.println("|\n| Matriz de adyacencia: ");
                graph.makeAdjacentMatrix();
                System.out.print(graph.showMatrix(0));
                graph.floydAlgorithm();

                System.out.println("|\n|\tIdentificador de Centros de Salud");
                System.out.println("| 1. Buscar ruta mas corta");
                System.out.println("| 2. Buscar centro de salud centrico");
                System.out.println("| 3. Modificar rutas");
                System.out.println("| 4. Salir del programa");
                System.out.print("| Ingrese la opcion que desea realizar: ");
                option = input.nextLine();

                // Realizando la opcion que desea el usuario
                switch (option){


                    case "1":
                        aux = askCity(false);
                        System.out.println("| "+ graph.getRoute(aux[0], aux[1]));
                        break;

                    // Mostrar centro del grafo
                    case "2":
                        System.out.println("| El centro del grafo es: " + graph.findMiddle());
                        break;

                    // Interrupcion o conexion entre ciudades
                    case "3":
                        System.out.println("| 1. Interrupcion entre ciudades");
                        System.out.println("| 2. Conexion entre ciudades");
                        System.out.print("| Ingrese la opcion que desea realizar: ");
                        option = input.nextLine();

                        // Realizando otra opcion del usuario
                        switch (option){

                            // Eliminar relaciones
                            case "1":
                                aux = askCity(false);
                                flag = graph.removeEdge(aux[0], aux[1]);
                                if ((flag)) { // Se pudo agregar
                                    System.out.println("| Se ha eliminado correctamente");
                                } else {    // No se pudo agregar
                                    System.out.println("|\n| Algo ha salido mal");
                                }
                                break;

                            // Agregar relaciones
                            case "2":
                                aux = askCity(true);
                                flag = graph.addEdge(aux[0], aux[1], Integer.parseInt(aux[2]));
                                if ((flag)) { // Se pudo agregar
                                    System.out.println("| Se ha agregado correctamente");
                                } else {    // No se pudo agregar
                                    System.out.println("|\n| Algo ha salido mal");
                                }
                                break;

                            default:
                                System.out.println("|\n| Opcion invalida");
                                break;
                        }

                        break;

                    // Salida y error
                    case "4":
                        System.out.println("|\n| Ha salido del programa");
                        break;
                    default:
                        System.out.println("|\n| Opcion invalida");
                        break;
                }

            }while(!option.equals("4"));
        }

    }

    /**
     * Consigue los valores de la ciudad
     * @pos se cuenta con las ciudades ingresadas por el usuario
     * @param flag para saber si se pide el peso
     * @return un array con los valores de la ciudad
     */
    private static String[] askCity(Boolean flag) {
        Scanner input = new Scanner(System.in);
        String[] ciudades = (!flag) ? new String[2] : new String[3];

        // Consiguiendo los nombres de las ciudades
        System.out.print("|\n| Ingrese la primera ciudad: ");
        ciudades[0] = input.nextLine().toUpperCase();
        System.out.print("| Ingrese la segunda ciudad: ");
        ciudades[1] = input.nextLine().toUpperCase();

        // Consiguiendo la distancia entre ellas
        if(flag){
            while (true) {

                // Verificando que sea numero
                try {
                    System.out.print("| Ingrese la distancia que las separa: ");
                    ciudades[2] = input.nextLine();
                    Integer.parseInt(ciudades[2]);
                    break;
                }catch (Exception e){
                    System.out.println("| Ingrese una distancia validad ");
                }
            }
        }

        return ciudades;
    }

}