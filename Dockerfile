FROM hseeberger/scala-sbt:11.0.4_1.3.2_2.13.1
ENV  PATH="$PATH:/usr/share/scala/bin/"

ARG APP_DIR=/usr/src/app
WORKDIR $APP_DIR
