#!/bin/bash

echo -e "\n Building Account Service"
cd accountService && ./gradlew build && cd ..
echo -e "\n Building API Gateway"
cd apiGateway && ./gradlew build && cd ..
echo -e "\n Building Service Discovery"
cd serviceDiscovery && ./gradlew build && cd ..