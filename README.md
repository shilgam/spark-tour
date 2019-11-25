# spark-tour

[![Build Status](https://travis-ci.com/shilgam/spark-tour.svg?branch=master)](https://travis-ci.com/shilgam/spark-tour)

## Prerequisites

1. Docker and docker-compose installed

## Usage

1. Clone the repo

1. Build docker image

        docker-compose build

1. Run app

        docker-compose run --rm app sbt run


### Run test suite

1. Run tests

        docker-compose run --rm app sbt test


### Debug

1.  Run `spark-shell`

        docker-compose run --rm app sbt console

1. View launched Spark Web UI: http://localhost:4040
