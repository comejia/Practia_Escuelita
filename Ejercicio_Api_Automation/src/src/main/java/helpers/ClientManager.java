/*
LINKS UTILES

Crear el certificado en formato PKCS12 en base al .crt y .key
https://stackoverflow.com/questions/38250271/creating-a-jks-from-a-crt-and-key-file-is-that-possible

Ejemplo de test unitario que utiliza 2 way ssl
http://massapi.com/source/apache/19/65/1965512834/dist/cxf/3.0.0-milestone1/apache-cxf-3.0.0-milestone1-src.zip/apache-cxf-3.0.0-milestone1-src.zip.unzip/apache-cxf-3.0.0-milestone1-src/systests/jaxrs/src/test/java/org/apache/cxf/systest/jaxrs/security/JAXRS20HttpsBookTest.java.html#64

Ayuda para armar el SSLContext
https://stackoverflow.com/questions/1666052/java-https-client-certificate-authentication

 */
package helpers;


import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.security.KeyStore;

public class ClientManager {

    public static Client getClient() {
        try {
            ClientBuilder builder = ClientBuilder.newBuilder();

            SSLContext sslContext = getClientSSLContext();
            builder.sslContext(sslContext);
            builder.hostnameVerifier(getHostnameVerifier());


            return builder.build();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private static SSLContext getClientSSLContext() throws FileNotFoundException {
        String keyPassphrase = "practia$$123";

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("./input/staging.dev.env.pfx"), keyPassphrase.toCharArray());

            SSLContext sslContext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, keyPassphrase.toCharArray())
                    .build();

            return sslContext;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return null;
        }

    }

    private static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };

        return hostnameVerifier;
    }
}
