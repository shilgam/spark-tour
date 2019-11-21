FROM vletal/scala-sbt:scala-2.11.11-sbt-0.13.16-python-3

ARG APP_PATH=/usr/src/app/
WORKDIR $APP_PATH

# install dependencies
COPY ./build.sbt ./
RUN sbt update

# copy source files
COPY ./src ./src

# build for release
CMD sbt run
