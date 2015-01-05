import java.io.IOException;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.obex.*;

public class ObexPutClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        String serverURL;
        if ((args != null) && (args.length > 0)) {
            serverURL = args[0];
        } else {
            String[] searchArgs = null;
            // Connect to OBEXPutServer from examples
            // searchArgs = new String[] { "11111111111111111111111111111123" };
            ServicesSearch.main(searchArgs);
            if (ServicesSearch.serviceFound.size() == 0) {
                System.out.println("OBEX service not found");
                return;
            }
            // Select the first service found
            serverURL = (String)ServicesSearch.serviceFound.elementAt(0);
        }

        System.out.println("Connecting to " + serverURL);

        ClientSession clientSession = (ClientSession) Connector.open(serverURL);
        HeaderSet hsConnectReply = clientSession.connect(null);
        if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
            System.out.println("Failed to connect");
            return;
        }

        HeaderSet hsOperation = clientSession.createHeaderSet();
        hsOperation.setHeader(HeaderSet.NAME, "Hello.txt");
        hsOperation.setHeader(HeaderSet.TYPE, "text");

        //Create PUT Operation
        Operation putOperation = clientSession.put(hsOperation);

        // Send some text to server
        byte data[] = "Hello world!".getBytes("iso-8859-1");
        OutputStream os = putOperation.openOutputStream();
        os.write(data);
        os.close();

        putOperation.close();

        clientSession.disconnect(null);

        clientSession.close();
    }
}