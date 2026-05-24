# test-infrastructure Specification

## Purpose
TBD - created by archiving change upgrade-junit-tests. Update Purpose after archive.
## Requirements
### Requirement: Tests run on the JUnit 5 Platform
The build SHALL execute the test suite using `useJUnitPlatform()` so that Spock 2 specs and any future Jupiter tests run through a single test engine.

#### Scenario: Gradle runs tests through the JUnit Platform
- **WHEN** a developer runs `./gradlew test`
- **THEN** test execution is dispatched through the JUnit Platform launcher and Spock specs are discovered and executed without an additional engine being declared

### Requirement: Test source is written exclusively as Spock specs
All project test classes SHALL be Spock specifications under `src/test/groovy`. The project MUST NOT contain Java test classes that depend on JUnit 4 (`org.junit.*`) or JUnit 3 (`junit.framework.*`) APIs.

#### Scenario: Repository contains no JUnit 4 or JUnit 3 imports
- **WHEN** the repository is searched with `grep -rE "^import (org\.junit\.[A-Z]|junit\.framework\.)" src/test`
- **THEN** the search returns no matches

#### Scenario: New behavior coverage is added as a Spock spec
- **WHEN** a contributor adds a new test for library behavior
- **THEN** the test is placed under `src/test/groovy` as a `*Spec.groovy` extending `spock.lang.Specification` (or an existing project base spec)

### Requirement: JUnit 4 is absent from the test classpath
The `testCompileClasspath` and `testRuntimeClasspath` configurations SHALL NOT resolve `junit:junit`. Any transitive dependency that would bring it in MUST be excluded at the dependency declaration.

#### Scenario: Dependency report shows no junit:junit
- **WHEN** a developer runs `./gradlew dependencies --configuration testCompileClasspath`
- **THEN** no line matching `junit:junit:` appears in the output

#### Scenario: Dependency report for runtime classpath shows no junit:junit
- **WHEN** a developer runs `./gradlew dependencies --configuration testRuntimeClasspath`
- **THEN** no line matching `junit:junit:` appears in the output

### Requirement: Versions catalog keys match the artifact they pin
Keys in `gradle/libs.versions.toml` SHALL name the artifact they actually reference. The version pin for `org.junit.jupiter:junit-jupiter` MUST be referenced by a key whose name reflects Jupiter (e.g., `junitJupiter`), not the JUnit 4 Vintage engine.

#### Scenario: Catalog key reflects Jupiter, not Vintage
- **WHEN** a contributor reads `gradle/libs.versions.toml`
- **THEN** the version backing the `junit-jupiter` library entry is declared under a key whose name indicates Jupiter, and no key named `junitVintage` exists unless the Vintage engine is actually a dependency

