FROM hseeberger/scala-sbt:8u222_1.3.3_2.12.10

ARG APP_PATH=/usr/src/app/
WORKDIR $APP_PATH

# install dependencies
COPY ./build.sbt ./
RUN sbt update

# copy source files
COPY ./src ./src

# build for release
CMD sbt run
