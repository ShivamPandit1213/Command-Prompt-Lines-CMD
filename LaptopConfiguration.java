Identify ports are available in my system:
Method 1: Command Prompt (Fastest) -> cmd [If it returns nothing: The port is available and safe to use.]: netstat -ano | findstr :9222
Method 2: Resource Monitor (Visual GUI) -> Press Windows Key + R -> Type resmon into the box and press Enter -> Click on the Network tab then expand the Listening Ports -> Any port not on this list between 1024 and 65535 is generally free to use.

Pro-Tip for your Framework ->
    import java.net.ServerSocket;
    public int getFreePort() throws Exception {
        // Opening a socket on port 0 tells Windows to automatically assign the next available free port
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        }
    }
