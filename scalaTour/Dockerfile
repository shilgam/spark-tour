FROM hseeberger/scala-sbt:8u212_1.2.8_2.12.8

ARG APP_PATH=/usr/src/app/scalaTour
WORKDIR $APP_PATH

# install dependencies
COPY ./build.sbt ./
RUN sbt update

# copy source files
COPY ./src ./src

# build for release
CMD sbt run
