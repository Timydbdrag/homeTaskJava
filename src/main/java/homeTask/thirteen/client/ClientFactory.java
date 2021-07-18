package homeTask.thirteen.client;

import homeTask.thirteen.impl.WikiApiRestClient;
import homeTask.thirteen.impl.WikiApiRestClientImpl;

public class ClientFactory {

    public ClientFactory() {
    }

    public static ClientFactory newInstance() {
        return new ClientFactory();
    }

    public WikiApiRestClient newRestClient() {
        return new WikiApiRestClientImpl();
    }

}
