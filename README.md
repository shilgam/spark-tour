# scala-tour

## Prerequisites

1. Docker and docker-compose installed

## Usage

1. Clone the repo

1. Build docker image

        docker-compose build

1. Generate first Scala skeleton project

        docker-compose run --rm app mvn archetype:generate -B \
          -DarchetypeGroupId=net.alchim31.maven -DarchetypeArtifactId=scala-archetype-simple -DarchetypeVersion=1.7 \
          -DgroupId=com.company -DartifactId=demo-app -Dversion=0.1-SNAPSHOT -Dpackage=com.company

## Additional info

* Scala with Maven: https://docs.scala-lang.org/tutorials/scala-with-maven.html
