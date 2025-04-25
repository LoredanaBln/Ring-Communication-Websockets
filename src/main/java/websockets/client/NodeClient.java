package websockets.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import websockets.model.Node;

import java.net.URI;

/**
 * It connects to the next node in the ring communication.
 * Is responsible for sending messages forward and handling the connection lifecycle.
 */
public class NodeClient extends WebSocketClient {
    private final Node node;

    public NodeClient(URI serverUri, Node node) {
        super(serverUri);
        this.node = node;
    }

    // confirms that the connection for node has been made successfully

    @Override
    public void onOpen(ServerHandshake handshakeData) {
        System.out.println("Connected to node: " + getURI());
        if (node.isInitiator()) {
            this.send("1");
            System.out.println("Sent initial value: 1");
        }
    }

    @Override
    public void onMessage(String message) {
        // no need for an implementation in here
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // no need for an implementation in here
    }

    @Override
    public void onError(Exception ex) {
        System.out.println(ex.getMessage());
    }
}

