## 1. Catalog rename

- [x] 1.1 In `gradle/libs.versions.toml`, rename the `[versions]` key `junitVintage` to `junitJupiter` and update the `version.ref` on the `junit-jupiter` library entry to match
- [x] 1.2 `grep -r junitVintage` across the repo to confirm no other references remain
- [x] 1.3 Run `./gradlew test` to confirm the rename is harmless on its own

## 2. Migrate `CalStartTest`

- [x] 2.1 In `src/test/groovy/net/fortuna/ical4j/extensions/model/property/CalStartSpec.groovy`, add a second `def` block exercising `new CalStart.Factory().createProperty(new ParameterList(), '20081030T193000Z')` and asserting the result is non-null
- [x] 2.2 Delete `src/test/java/net/fortuna/ical4j/extensions/model/property/CalStartTest.java`
- [x] 2.3 Run `./gradlew test --tests "*CalStartSpec*"` and confirm both feature methods pass

## 3. Migrate `CharsetTest`

- [x] 3.1 Create `src/test/groovy/net/fortuna/ical4j/extensions/lotus/CharsetSpec.groovy` with a single feature method covering `new Charset.Factory().createProperty(null, 'UTF-8') == ImmutableCharset.UTF8`
- [x] 3.2 Delete `src/test/java/net/fortuna/ical4j/extensions/lotus/CharsetTest.java`
- [x] 3.3 Run `./gradlew test --tests "*CharsetSpec*"` and confirm it passes

## 4. Migrate `CalendarBuilderTest`

- [x] 4.1 Create `src/test/groovy/net/fortuna/ical4j/extensions/CalendarBuilderSpec.groovy` extending `AbstractExtensionSpec`, with a `where:`-parameterized feature method that builds the calendar from `filename`, calls `validate()`, and asserts the result matches `expectedValid` (initial data row: `'/samples/Bodypart2.ics' | true`)
- [x] 4.2 Delete `src/test/java/net/fortuna/ical4j/extensions/CalendarBuilderTest.java`
- [x] 4.3 Run `./gradlew test --tests "*CalendarBuilderSpec*"` and confirm it passes
- [x] 4.4 Confirm no files remain under `src/test/java` (the directory may stay empty or be removed)

## 5. Remove JUnit 4 from the test classpath

- [x] 5.1 In `build.gradle`, exclude `group: 'junit', module: 'junit'` from the `groovy-test` testImplementation dependency (or from the `testImplementation` configuration as a whole)
- [x] 5.2 Run `./gradlew dependencies --configuration testCompileClasspath | grep "junit:junit"` and confirm no output
- [x] 5.3 Run `./gradlew dependencies --configuration testRuntimeClasspath | grep "junit:junit"` and confirm no output
- [x] 5.4 Run the full `./gradlew test` and confirm every spec still passes

## 6. Validation

- [x] 6.1 `grep -rE "^import (org\.junit\.[A-Z]|junit\.framework\.)" src/test` returns nothing
- [x] 6.2 `./gradlew clean test jacocoTestReport` completes successfully
- [x] 6.3 `openspec validate upgrade-junit-tests` reports the change as valid
