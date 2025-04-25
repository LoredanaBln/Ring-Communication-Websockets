package websockets;

import websockets.model.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] ports = {9001, 9002, 9003};
        String[] hosts = {"127.0.0.2", "127.0.0.3", "127.0.0.1"};

        Node[] nodes = new Node[3];

        for (int i = 0; i < 3; i++) {
            int currentPort = ports[i];
            String nextHost = hosts[(i + 1) % 3];
            int nextPort = ports[(i + 1) % 3];
            boolean isInitiator = (i == 0);

            nodes[i] = new Node(currentPort, nextHost, nextPort, isInitiator);
            nodes[i].start();
        }

        Thread.sleep(2000);

        for (Node node : nodes) {
            node.connect();
        }
    }
}