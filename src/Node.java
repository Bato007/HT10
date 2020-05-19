/**
 * Brandon Hernandez 19376
 * @since 17/05/2020
 * @version 18/05/2020
 * @name Node.java
 *
 * Se encarga de representar a un nodo
 * @param <V> es el tipo del valor que el nodo guardara
 */
public class Node<V> {

    // Atributos del nodo
    protected V value;
    protected Integer index;

    /**
     * Constructor del nodo, sabe su posicion y valor
     * @pos hay un nuevo nodo
     * @param value es el valor que se le de al nodo
     * @param index es la posicion en la que se encuentra
     */
    public Node(V value, Integer index){
        this.value = value;
        this.index = index;
    }

    /**
     * Se encarga de dar el indice del nodo en la matriz
     * @return el index'
     */
    public Integer getIndex() {
        return index;
    }
}
