
import networkx as nx
graph = nx.DiGraph()


def add(node):
    graph.add_node(node)

def addEdge(origin, destination, path_weight):
    graph.add_edge(origin, destination, weight = path_weight)

def floydAlgorithm():
    