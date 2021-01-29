package service

import (
	"github.com/aws/aws-lambda-go/events"
	"studentpals/email-service/http"
)

func StudentAuthRequest(event events.APIGatewayProxyRequest) (string, http.Status, error) {

	return "", http.Status{}, nil
}
