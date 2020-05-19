import org.junit.Test;

import java.time.format.SignStyle;

import static org.junit.Assert.*;

public class RouteGraphTest {

    @Test
    public void add() {
        RouteGraph<String> graph = new RouteGraph<>();

        // Test add
        graph.add("Antigua");
        graph.add("Mixco");
        graph.add("Guatemala");
        graph.add("San Cris");
        graph.add("Zona 7");
        graph.add("Cayala");

        System.out.print(graph.relations.get("Antigua").index + "\n"); // Verificando que sea el index

        // Verificando edges
        graph.addEdge("Antigua", "Mixco", 10);
        graph.addEdge("Antigua", "Cayala", 15);
        graph.addEdge("Mixco", "Cayala", 10);
        graph.addEdge("Mixco", "San Cris", 5);
        graph.addEdge("Cayala", "Guatemala", 5);
        graph.addEdge("Guatemala", "Antigua", 20);
        graph.addEdge("Guatemala", "Zona 7", 5);
        graph.addEdge("Zona 7", "San Cris", 5);
        graph.addEdge("Zona 7", "Cayala", 8);
        graph.addEdge("San Cris", "Zona 7", 5);

        graph.makeAdjacentMatrix();
        // Observando la matriz
        System.out.println(graph.showMatrix(0));
        System.out.println("\n");

        graph.addEdge("Zona 7", "San Cris", 100);
        boolean flag = graph.removeEdge("Zona 7", "Cayala");
        System.out.println(flag);
        graph.makeAdjacentMatrix();
        System.out.println(graph.showMatrix(0));
        System.out.println("\n");

        graph.addEdge("Zona 7", "Cayala", 8);
        graph.makeAdjacentMatrix();
        graph.floydAlgorithm();

        System.out.println(graph.showMatrix(1));
        System.out.println("\n");

        System.out.println(graph.getRoute("Antigua", "Zona 7"));
        graph.findMiddle();
        System.out.println(graph.findMiddle());

    }
}