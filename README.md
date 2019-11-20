# spark-tour

[![Build Status](https://travis-ci.com/shilgam/spark-tour.svg?branch=master)](https://travis-ci.com/shilgam/spark-tour)

## Prerequisites

1. Docker and docker-compose installed

## Usage

1. Clone the repo

1. Build docker image

        docker-compose build

1. Run Scala interactive shell session

        docker-compose run --rm app sbt console


### Run test suite

1. Run tests:

        docker-compose run --rm app sbt test
