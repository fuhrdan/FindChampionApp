import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindChampionApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Find Champion Visualizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Input Panel
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(0, 2));

            JLabel lblNodes = new JLabel("Number of Nodes:");
            JTextField txtNodes = new JTextField();

            JLabel lblEdges = new JLabel("Edges (e.g., 0->1, 1->2):");
            JTextField txtEdges = new JTextField();

            inputPanel.add(lblNodes);
            inputPanel.add(txtNodes);
            inputPanel.add(lblEdges);
            inputPanel.add(txtEdges);

            frame.add(inputPanel, BorderLayout.NORTH);

            // Output Panel
            JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(outputArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Process Button
            JButton btnProcess = new JButton("Find Champion");
            frame.add(btnProcess, BorderLayout.SOUTH);

            btnProcess.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Parse input
                        int n = Integer.parseInt(txtNodes.getText());
                        String edgesText = txtEdges.getText();
                        String[] edgesArray = edgesText.split(",");
                        int[][] edges = new int[edgesArray.length][2];

                        for (int i = 0; i < edgesArray.length; i++) {
                            String[] nodes = edgesArray[i].trim().split("->");
                            edges[i][0] = Integer.parseInt(nodes[0]);
                            edges[i][1] = Integer.parseInt(nodes[1]);
                        }

                        // Find the champion
                        int champion = findChampion(n, edges);
                        String result = (champion == -1)
                                ? "No Champion found."
                                : "Champion: Node " + champion;

                        // Display results
                        outputArea.setText("Nodes: " + n + "\n");
                        outputArea.append("Edges:\n");
                        for (int[] edge : edges) {
                            outputArea.append(edge[0] + " -> " + edge[1] + "\n");
                        }
                        outputArea.append("\nResult:\n" + result);

                    } catch (Exception ex) {
                        outputArea.setText("Error: Invalid input. Please try again.");
                    }
                }
            });

            frame.setVisible(true);
        });
    }

    public static int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (int[] edge : edges) {
            indeg[edge[1]]++;
        }

        int champion = -1;
        int zeroIndegreeCount = 0;

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                zeroIndegreeCount++;
                champion = i;
            }
        }

        return zeroIndegreeCount == 1 ? champion : -1;
    }
}
