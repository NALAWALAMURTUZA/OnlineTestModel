package Comman;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;

/**
 * Created by Murtuza on 5/1/2016.
 */



public class  HttpConnection  {

    public static String HttpConnect(String Url,int ConnectionTimeOut,String InputString,String Method)
    {
        String responseText = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost(Method);
            httppostreq.setHeader("Accept", "application/json");
            httppostreq.setHeader("Content-type", "application/json");
            httppostreq.setEntity(new StringEntity(InputString, "UTF-8"));
            HttpResponse httpresponse = httpclient.execute(httppostreq);
            try {
                responseText = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
            } catch (NullPointerException np) {

            }
        }
        catch (ClientProtocolException e1)
        {
        // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (IOException e1)
        {
        // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (NullPointerException np) {
        }
        return responseText;
    }


    public static String HttpsConnect(String Url,int ConnectionTimeOut,String InputString,String Method)
    {
        StringBuilder OutputString = new StringBuilder();
        try {
            KeyStore keyStore = new KeyStore().getKey();
            String algorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
            tmf.init(keyStore);

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);
            URL url = new URL(Url);
            HttpsURLConnection connect = (HttpsURLConnection)url.openConnection();
            connect.setSSLSocketFactory(context.getSocketFactory());
            InputStream in = connect.getInputStream();
            String UrlParamiter = InputString;
            connect.setRequestMethod(Method);
            connect.setRequestProperty("USER-AGENTS","Mozilla/5.0");
            connect.setRequestProperty("ACCEPT-LANGUAGE","en-US,en;0.5");
            connect.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connect.getOutputStream());
            dataOutputStream.writeBytes(UrlParamiter);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responsecode = connect.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String line = "";
            while((line = bufferedReader.readLine())!= null)
            {
                OutputString.append(line);
            }
            bufferedReader.close();
            System.out.println(OutputString.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return OutputString.toString();
    }
}

