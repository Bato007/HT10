import java.util.*;
/**
 * Brandon Hernandez 19376
 * @since 17/05/2020
 * @version 17/05/2020
 * @name RouteGraph.java
 *
 * Se encarga de administrar a los nodos y aristas
 * @param <V> tipo de los nodos
 * @param <E> tipo del peso
 */
public class RouteGraph<V, E> implements Graph<V, E> {

    protected E[][] adjacentMatrix;
    protected Integer index = 0; // Cantidad de nodos
    protected Map<V,  Node<V>> relations; // Saber las relaciones entre nodos
    protected ArrayList<Edge<V,E>> edges;

    /**
     * Constructor del grafo
     * @pos esta construido el grafo e
     * inicializados sus atributos
     */
    public RouteGraph(){
        relations = new Hashtable<>();
        edges = new ArrayList<>();
    }

    /**
     * Se encarga de agregar un nodo al grafo
     * @pre el grafo tiene n valores
     * @pos el grafo tiene n +1 valores si no esta repetido
     * @param newNode es el valor que se le quiere agregar al nodo
     */
    public void add(V newNode){
        // Verificando si ya se encuentra en el dic, el valor ingresado
        if (relations.containsKey(newNode)) return;
        relations.put(newNode, new Node<V>(newNode, index));
        index++;
    }

    /**
     * Se encarga de agregar una relacion entre dos nodos
     * @param origin el nodo de origen
     * @param destination el nodo de destino
     * @param weight el peso entre los nodos
     * @return true si se agrego, false si no existen los nodos
     */
    public boolean addEdge(V origin, V destination, E weight) {
        Edge<V, E> newroad;

        // Verificando que
        if(!(relations.containsKey(origin) && relations.containsKey(destination)))
            return false;
        else{
            newroad = new Edge<>(origin, destination, weight);
            return true;
        }

    }



}
