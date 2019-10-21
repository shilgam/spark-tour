FROM hseeberger/scala-sbt:8u151-2.12.4-1.1.0

ARG APP_PATH=/usr/src/app/scalatesttutorial
WORKDIR $APP_PATH

# install dependencies
COPY ./build.sbt ./
RUN sbt update

# copy source files
COPY ./src ./src

# build for release
CMD sbt run
