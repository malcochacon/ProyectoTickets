#!/bin/sh
mvn clean package && docker build -t gt.com.mc/ProyectoTickets .
docker rm -f ProyectoTickets || true && docker run -d -p 8080:8080 -p 4848:4848 --name ProyectoTickets gt.com.mc/ProyectoTickets 
