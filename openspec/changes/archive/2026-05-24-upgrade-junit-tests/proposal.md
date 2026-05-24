## Why

Three Java test files still use JUnit 4 (and even `junit.framework.Assert` from JUnit 3), while the rest of the suite — and the build's `useJUnitPlatform()` configuration — has moved to Spock 2 on the JUnit 5 Platform. JUnit 4 only stays on the classpath as a transitive dependency of `groovy-test`, which masks the inconsistency and risks new tests being written against the deprecated APIs. The versions catalog compounds the confusion: the key `junitVintage` actually points at `junit-jupiter`, not the Vintage engine.

## What Changes

- Rewrite the three remaining JUnit 4 Java tests as Spock specs and delete the Java files:
  - `CalStartTest.java` → folded into existing `CalStartSpec.groovy` as an additional `def` block covering the `Factory.createProperty` path
  - `lotus/CharsetTest.java` → new `lotus/CharsetSpec.groovy`
  - `CalendarBuilderTest.java` → new `CalendarBuilderSpec.groovy` with parameterization expressed via Spock's `where:` block
- Rename the versions catalog key `junitVintage` → `junitJupiter` so it matches the artifact it pins.
- Exclude the transitive `junit:junit:4.13.2` brought in by `groovy-test`, asserting structurally that no JUnit 4 remains on the test classpath.
- **BREAKING (internal-only):** the three deleted Java test classes will no longer exist. The library's published API is untouched; only the test sources change.

## Capabilities

### New Capabilities
- `test-infrastructure`: Codifies the rules the test suite must follow — runs on the JUnit 5 Platform, written exclusively as Spock specs, with no JUnit 4 APIs on the test classpath.

### Modified Capabilities
<!-- None — no library/product requirements change; the same library behaviors are validated by Spock specs instead of JUnit 4 tests. -->


## Impact

- **Code:** `src/test/java/net/fortuna/ical4j/extensions/CalendarBuilderTest.java`, `.../lotus/CharsetTest.java`, `.../model/property/CalStartTest.java` (deleted); new/edited Spock specs in the parallel `src/test/groovy` tree.
- **Build:** `build.gradle` (exclusion on `groovy-test`); `gradle/libs.versions.toml` (rename key).
- **Dependencies:** `junit:junit:4.13.2` removed from `testCompileClasspath`. Spock, Jupiter, and platform launcher unchanged.
- **APIs:** none. No production code or published API surface is affected.
- **Risk:** low. If Spock 2 or `groovy-test` turns out to need JUnit 4 at runtime, the exclusion can be reverted independently of the test migrations.
