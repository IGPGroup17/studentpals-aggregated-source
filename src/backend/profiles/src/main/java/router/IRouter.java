package router;

import com.amazonaws.services.lambda.runtime.Context;
import service.IService;

public interface IRouter<I, O, S extends IService> {

    O routeRequest(I event, Context context, S service);
}
