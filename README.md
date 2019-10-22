# scala-tour

## Prerequisites

1. Docker and docker-compose installed

## Usage

1. Clone the repo

1. Build docker image

        docker-compose build

1. Run bash interactive session

        docker-compose run --rm app bash


### Run test suite

1. Run unit tests:

        docker-compose run --rm app sbt test

## Additional info

* [A Scala linter](https://atom.io/packages/linter-scalastyle) for Atom Linter using scalastyle
