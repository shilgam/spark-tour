# scala-tour

[![Build Status](https://travis-ci.com/shilgam/scala-tour.svg?branch=master)](https://travis-ci.com/shilgam/scala-tour)

## Prerequisites

1. Docker and docker-compose installed

## Usage

1. Clone the repo

1. Build docker image

        docker-compose build

1. Run Scala interactive shell session

        docker-compose run --rm app sbt console


### Run test suite

- all tests

      docker-compose run --rm app sbt test

- specific test

      # 1) run sbt shell
      docker-compose run --rm app sbt console

      # 2) run specific test by class name
      testOnly BasicExampleSpec

## Additional info

* [A Scala linter](https://atom.io/packages/linter-scalastyle) for Atom Linter using scalastyle
* [Scalafmt code formatter](https://scalameta.org/scalafmt/)
