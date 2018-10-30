FROM airhacks/glassfish
COPY ./target/ProyectoTickets.war ${DEPLOYMENT_DIR}
