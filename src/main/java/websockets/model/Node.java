package websockets.model;

import websockets.client.NodeClient;
import websockets.server.NodeServer;

import java.net.URI;
import java.sql.SQLOutput;

/**
 * A class meant to represent a  node in the ring network.
 * Since a node can be both a server and a client it contains references to NodeClient and NodeServer to create the circular communication.
 */
public class Node {
    private final int currentPort;
    private final String nextHost;
    private final int nextPort;
    private final boolean isInitiator;
    private NodeClient client;
    private NodeServer server;

    public Node(int ownPort, String nextHost, int nextPort, boolean isInitiator) {
        this.currentPort = ownPort;
        this.nextHost = nextHost;
        this.nextPort = nextPort;
        this.isInitiator = isInitiator;
    }

    public boolean isInitiator() {
        return isInitiator;
    }

    public void start() {
        server = new NodeServer(currentPort, this);
        server.start();
    }

    public void connect() throws Exception {
        client = new NodeClient(new URI("ws://" + nextHost + ":" + nextPort), this);
        client.connectBlocking();
    }


    public void handleMessage(String message) {
        try {
            int value = Integer.parseInt(message);
            System.out.println("[" + currentPort + "] Received: " + value);

            if (value >= 100) {
                System.out.println("[" + currentPort + "] Final value reached. Stopping.");
                return;
            }

            int nextValue = value + 1;
            Thread.sleep(200);
            client.send(String.valueOf(nextValue));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
