package DataProvider;

import Comman.Constant;
import Comman.HttpConnection;
import Comman.ServiceUrl;

/**
 * Created by Murtuza on 5/1/2016.
 */
public class SecurityDataProvider {

    public static void Init(Runnable callback,String abc) {
        // Run callback callback.run();
        System.out.println(abc);
        HttpConnection.Connect(ServiceUrl.Init,1000,"", Constant.MethodName);
    }
}
