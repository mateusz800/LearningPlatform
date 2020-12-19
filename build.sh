#!/bin/bash

echo -e "\n Building Account Servcie"
cd accountService && ./gradlew build && cd ..
echo -e "\n Building API Gateway"
cd apiGateway && ./gradlew build && cd ..