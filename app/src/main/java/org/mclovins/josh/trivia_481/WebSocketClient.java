package org.mclovins.josh.trivia_481;

import org.greenrobot.eventbus.EventBus;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by Josh on 2/1/18.
 */

public class WebSocketClient {

    // Not really happy with this code, probably definitely a better way to do this.

    private static OkHttpClient client = new OkHttpClient();
    private static WebSocket ws;

    /*
    public static synchronized WebSocket getSocket(){
        return ws;
    }

    public static synchronized OkHttpClient getClient() {
        return client;
    }

    public static synchronized void setSocket(WebSocket socket){
        WebSocketClient.ws = socket;
    }

    public static synchronized void setClient(OkHttpClient client) {
        WebSocketClient.client = client;
    }*/

    static void Connect() {

        Request request = new Request.Builder().url("ws://139.84.74.104:5000").build();
        ws = client.newWebSocket(request, new WebSocketListenerInterface());
        //client.dispatcher().executorService().shutdown();
    }

    static void Send(String message) {
        ws.send(message);
    }

    static void Disconnect() {
        ws.close(1000, "Goodbye !");
    }


    private static class WebSocketListenerInterface extends WebSocketListener {
        private static final int NORMAL_CLOSURE_STATUS = 1000;

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !");
        }

        @Override
        public void onMessage(WebSocket webSocket, final String text) {


        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {

        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(NORMAL_CLOSURE_STATUS, null);

        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {

        }
    }
}


