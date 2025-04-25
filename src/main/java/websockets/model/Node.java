package websockets.model;

import websockets.client.NodeClient;
import websockets.server.NodeServer;

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
        // TODO implement
    }

    public void connect() throws Exception {
        // TODO implement
    }


    public void handleMessage(String message) {
        // TODO implement
    }

}
