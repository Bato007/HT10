/**
 * Brandon Hernandez 19376
 * @since 17/05/2020
 * @version 18/05/2020
 * @name Edje.java
 *
 * Se encarga de representar a una arista
 * @param <V> es el tipo de los nodos
 */
public class Edge<V>{

    // Atributos de la arista
    protected V origin, destination;
    protected Integer weight;

    /**
     * Se encarga de crear una relacin entre dos nodos
     * @pre no hay relacion entre ellos
     * @pos hay relacion entre estos nodos
     * @param origin es donde viene
     * @param destination a donde se dirige
     * @param weight es el peso que hay entre estos dos nodos
     */
    public Edge(V origin, V destination, Integer weight){
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Verifica si estos las aristas son iguales
     * @pos se sabe si son iguale so no
     * @param other es la otra arista que se compara
     * @return si son iguales o no
     */
    public Boolean equals(Edge<V> other) {
        return this.origin.equals(other.origin) && this.destination.equals(other.destination);
    }

    /**
     * Setter del peso
     * @pos weight tiene un nuevo peso
     * @param newWeight es el nuevo valor del weight
     */
    public void setWeight(Integer newWeight){
        this.weight = newWeight;
    }

}
