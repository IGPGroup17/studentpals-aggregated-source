package com.igp.studentservice

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent}
import com.igp.studentservice.service.{StudentService, StudentServiceImpl}
import com.igp.studentservice.util.{EnvironmentLogger, ResponseEntity}

/**
 * Trying scala for the handy pattern matching. Sorry if it's confusing you should never need to touch this class
 * anyways.
 */
class Handler extends RequestHandler[APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent] {

  override def handleRequest(event: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent = {
    EnvironmentLogger.log(event, context)

    routeRequest(event, context, new StudentServiceImpl).toApiGatewayProxyResponseEvent
  }

  def routeRequest(event: APIGatewayProxyRequestEvent, context: Context, service: StudentService): ResponseEntity[_] = event.getResource match {
    case "/students/basic/{id}" if event.getHttpMethod.equals("GET") => service.getBasicStudent(event, context)
    case "/students/create" if event.getHttpMethod.equals("POST") => service.createStudent(event, context)
    case "/students/delete/{id}" if event.getHttpMethod.equals("DELETE") => service.deleteStudent(event, context)
    case "/students/detailed/{id}" if event.getHttpMethod.equals("GET") => service.getDetailedStudent(event, context)
    case "/students/uni/{id}" if event.getHttpMethod.equals("GET") => service.getUniStudent(event, context)
    case "/students/update/{id}" if event.getHttpMethod.equals("POST") => service.updateStudent(event, context)
    case _ => ResponseEntity.notFound()
  }
}