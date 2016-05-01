package Comman;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Murtuza on 5/1/2016.
 */



public class  HttpConnection {

    public static String Connect(String Url,int ConnectionTimeOut,String InputString,String Method)
    {
        StringBuilder OutputString = new StringBuilder();
        try {
            URL url = new URL("");
            HttpsURLConnection connect = (HttpsURLConnection)url.openConnection();
            String UrlParamiter = "";
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
        }
        return OutputString.toString();
    }
}

