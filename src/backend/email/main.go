package main

import (
	"context"
	"github.com/aws/aws-lambda-go/events"
	"github.com/aws/aws-lambda-go/lambda"
	"studentpals/email-service/http"
	"studentpals/email-service/service"
)

var headers = map[string]string {
	"Content-Type": "application/json",
	"X-Custom-Header": "application/json",
}

//goland:noinspection GoNilness
func HandleRequest(context context.Context, event events.APIGatewayProxyRequest) (events.APIGatewayProxyResponse, error) {
	go LogEnvironment(event)

	var response string
	var httpStatus http.Status
	var err error

	switch event.Resource {

	case "": response, httpStatus, err = service.StudentAuthRequest(event)
	default: response, httpStatus, err = "Resource not Found :/", http.NOT_FOUND, nil
	}

	return events.APIGatewayProxyResponse{
		StatusCode:        httpStatus.Code,
		Headers:           headers,
		MultiValueHeaders: nil,
		Body:              response,
		IsBase64Encoded:   false,
	}, err
}

func LogEnvironment(event events.APIGatewayProxyRequest) {

}


func main() {
	lambda.Start(HandleRequest)
}
