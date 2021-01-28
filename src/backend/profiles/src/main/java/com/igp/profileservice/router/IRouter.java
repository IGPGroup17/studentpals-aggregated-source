package com.igp.profileservice.router;

import com.amazonaws.services.lambda.runtime.Context;
import com.igp.profileservice.service.IService;

public interface IRouter<I, O, S extends IService> {

    O routeRequest(I event, Context context, S service);
}
