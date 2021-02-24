import json
import boto3
import requests
from requests_aws4auth import AWS4Auth
import base64

# Authentication stuff
region = 'eu-west-1'
service = 'es'
credentials = boto3.Session().get_credentials()
auth = AWS4Auth(credentials.access_key, credentials.secret_key, region, service, session_token=credentials.token)

# Building the URL
host = 'https://search-event-service-fyrtpugn2ktogtbm47a7vugeu4.eu-west-1.es.amazonaws.com'  # Link to ElasticSearch instance for events
kine_index = 'lambda-kine-index'
kine_type = 'lambda-kine-type'
url = host + '/' + kine_index + '/' + kine_type + '/'

headers = {"content", "application/json"}


def lambda_handler(event, context):
    """
    This Lambda function is responsible for taking a Kinesis stream of data, and putting it in the ElasticSearch Service.

    This function is internal, and shouldn't be accessed on the outside!

    This function triggers automatically upon a change to the "events" document in DynamoDB.
    """

    count = 0
    for record in event['Records']:
        id = record['eventID']
        timestamp = record['kinesis']['approximateArrivalTimestamp']

        # Kinesis data is base64-encoded, so decode here
        message = base64.b64decode(record['kinesis']['data'])

        # Create the JSON document
        document = {"id": id, "timestamp": timestamp, "message": message}
        # Index the document
        r = requests.put(url + id, auth=auth, json=document, headers=headers)
        count += 1
    return 'Processed ' + str(count) + ' items.'
