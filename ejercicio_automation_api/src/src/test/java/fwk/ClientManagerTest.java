package fwk;

import helpers.ClientManager;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;

public class ClientManagerTest {


    @Test
    public void test_getClient() {
        Client result = ClientManager.getClient();

        Assert.assertNotNull(result);
    }

}

