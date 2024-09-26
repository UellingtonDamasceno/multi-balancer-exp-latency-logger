FROM openjdk:17.0.2-slim AS builder
LABEL maintainder="UDamasceno <udamasceno@ecomp.uefs.br>"

WORKDIR /opt

RUN apt-get update -y && apt-get upgrade -y && apt-get autoremove -y\ 
  && apt-get install wget -y\
  && wget https://github.com/UellingtonDamasceno/multi-balancer-exp-latency-logger/archive/refs/tags/latest.zip\
  && apt-get install unzip -y\
  && unzip latest.zip\
  && rm latest.zip\
  && mv multi-balancer-exp-latency-logger-latest mlb\
  && cd mlb\
  && apt-get install maven -y\
  && mvn clean install \
  && apt-get purge maven -y\
  && apt-get autoremove -y\
  && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

FROM openjdk:17.0.2-slim AS mlb-logger-api
WORKDIR /opt

# RUN apt-get update && \
#   apt-get install -y --no-install-recommends \
#   bash \
#   tcpdump \
#   iperf \
#   busybox \
#   iproute2 \
#   iputils-ping && \
#   apt-get clean && \
#   rm -rf /var/lib/apt/lists/*

LABEL maintainder="UDamasceno <udamasceno@ecomp.uefs.br>"
COPY --from=builder /opt/mlb/target/experiments-latency-logger-0.0.1-SNAPSHOT.jar  /opt/logger.jar
ENTRYPOINT ["java", "-jar", "logger.jar"]