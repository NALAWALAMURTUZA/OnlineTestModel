package DataProvider;

import Comman.Constant;
import Comman.HttpConnection;
import Comman.ServiceUrl;

/**
 * Created by Murtuza on 5/1/2016.
 */
public class SecurityDataProvider {

    public static void init()
    {
        HttpConnection.Connect(new ServiceUrl().Login,10,"", new Constant().MethodName);
    }
}
