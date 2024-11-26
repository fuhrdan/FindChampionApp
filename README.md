# FindChampionApp

FindChampionApp is a Java Swing application that visually demonstrates the **Find Champion** algorithm. This algorithm identifies a "champion" node in a directed graph, where the champion is the only node with an in-degree of 0. The application allows users to input graph data, processes the algorithm, and displays the results.

---

## Features

- Input the number of nodes and edges in a graph.
- Visualize the graph edges in the output.
- Identify the "champion" node (or return "No Champion" if none exist).
- Simple and intuitive user interface built with Java Swing.

---

## Algorithm

### Find Champion Logic

The algorithm works as follows:
1. Compute the in-degree for each node.
2. Identify nodes with an in-degree of 0.
3. If exactly one node has an in-degree of 0, that node is the champion. Otherwise, no champion exists.

### Time Complexity
- **O(n + e):** Where `n` is the number of nodes and `e` is the number of edges.

### Space Complexity
- **O(n):** Space used to store the in-degree array.

---

## Example

### Input:
- **Nodes:** `5`
- **Edges:** `0->1, 1->2, 2->3`

### Output:
