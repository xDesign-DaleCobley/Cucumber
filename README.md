# Cucumber

This project contains boilerplate code and configuration for using Cucumber with Spring.

# JUnit

Ideally use the JUnit5 setup to benefit from JUnit5's features, but a JUnit4 example is included as well.

## Local Setup

* **Build**: `./gradlew build`
* **Run tests**: `./gradlew check`
* **Run only tests with tag**: `./gradlew check -Dcucumber.filter.tags="@NoName"`