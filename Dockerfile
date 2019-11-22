FROM spikerlabs/scala-sbt:scala-2.11.12-sbt-1.2.6

ARG APP_PATH=/usr/src/app/
WORKDIR $APP_PATH

# install dependencies
COPY ./build.sbt ./
RUN sbt update

# copy source files
COPY ./src ./src

# build for release
CMD sbt run
