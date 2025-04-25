package websockets.server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import websockets.model.Node;

import java.net.InetSocketAddress;

/**
 * It listens for incoming connections and forwards messages for processing. Acts like a server
 */
public class NodeServer extends WebSocketServer {
    private final int port;
    private final Node node;

    public NodeServer(int port, Node node) {
        super(new InetSocketAddress(port));
        this.port = port;
        this.node = node;
    }

    @Override
    public void onStart() {
        System.out.println("The communication has started on port " + port);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("[" + port + "] Connection opened.");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("[" + port + "] Connection closed.");
    }

    // this method is responsible for forwarding the message received for processing
    @Override
    public void onMessage(WebSocket conn, String message) {
        node.handleMessage(message);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println(e.getMessage());
    }
}
