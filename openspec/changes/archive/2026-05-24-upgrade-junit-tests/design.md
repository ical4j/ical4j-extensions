## Context

The project's test suite is split between ~33 Spock specs under `src/test/groovy` and 3 legacy Java tests under `src/test/java` that still use JUnit 4 APIs (and in two cases the older `junit.framework.Assert`). The build already runs on the JUnit 5 Platform (`useJUnitPlatform()`) and declares `junit-jupiter` 5.14.1, but the legacy tests compile only because `groovy-test` 3.0.25 pulls in `junit:junit:4.13.2` transitively. The versions-catalog key for the Jupiter artifact is misleadingly named `junitVintage`, which suggests the JUnit 4 → 5 Vintage engine is in use when it is not.

Inventory of legacy tests:

| File | APIs used | Notes |
|---|---|---|
| `CalendarBuilderTest.java` | `@RunWith(Parameterized.class)`, `@Before`, `@Test`, `org.junit.Assert` | Single parameter row today (`Bodypart2.ics`, expected valid) |
| `lotus/CharsetTest.java` | `@Test`, `junit.framework.Assert` (JUnit 3) | One test method, no Spock counterpart exists |
| `model/property/CalStartTest.java` | `@Test`, `junit.framework.Assert` (JUnit 3) | Exercises `Factory.createProperty`; sibling `CalStartSpec.groovy` exists but tests the constructor path only — not a duplicate |

## Goals / Non-Goals

**Goals:**
- Eliminate JUnit 4 API usage from project source.
- Eliminate `junit:junit:4.x` from `testCompileClasspath` so the new state is structurally enforced.
- Preserve all existing test coverage (no behavior loss during migration).
- Make the versions-catalog naming honest (`junitJupiter`, not `junitVintage`).
- Leave the suite consistent: one test framework family (Spock-on-Jupiter), one test source directory (`src/test/groovy`).

**Non-Goals:**
- Adding new test cases or expanding parameter coverage beyond what the legacy tests already had.
- Touching the Spock specs that already exist.
- Upgrading Spock, Jupiter, or Groovy versions.
- Reformatting or shortening the long license headers in the migrated files.
- Any change to production code or the published library API.

## Decisions

### Migrate to Spock rather than JUnit 5 Jupiter
The rest of the suite is Spock and the project's test harness (`AbstractExtensionSpec`) is Spock. Adopting Spock here means one framework family across the test tree. Jupiter would have been less rewriting per file but would leave a permanent two-framework split. Rejected.

### Fold `CalStartTest` into `CalStartSpec` rather than create a parallel spec
The existing `CalStartSpec.groovy` already covers the same property class via the constructor path. Adding the Factory case as a second `def` block keeps related coverage co-located. Creating a separate `CalStartFactorySpec.groovy` was considered and rejected as gratuitous fragmentation.

### Express parameterization with Spock `where:` blocks
JUnit 4's `@Parameterized` runner maps cleanly to Spock data tables. The single existing parameter row can be moved verbatim; the `where:` form makes it trivial to add rows later (out of scope here).

### Exclude transitive `junit:junit` on `groovy-test`
After migration nothing in our code uses JUnit 4. Excluding it via `configurations.testImplementation { exclude group: 'junit', module: 'junit' }` (or a per-dependency exclude on `groovy-test`) turns "no JUnit 4" into a structural property: a future test accidentally written against JUnit 4 will fail to compile. Spock 2 is Jupiter-native and does not require `junit:junit` at runtime. Considered alternative: leaving the transitive in place. Rejected because it preserves the failure mode this change is meant to remove.

### Rename catalog key `junitVintage` → `junitJupiter`
The current name actively misleads readers. Renaming is one-line and self-contained. Both the `[versions]` entry and the `version.ref` on the `junit-jupiter` library entry change together.

## Risks / Trade-offs

- **[Risk] Spock 2 or `groovy-test` does in fact need `junit:junit` at runtime in some path we haven't exercised** → Mitigation: the exclude is a single line and isolated to `build.gradle`; revert independently of the test migrations if `./gradlew test` fails. Test-classpath inspection (`./gradlew dependencies --configuration testRuntimeClasspath | grep junit:junit`) and a full test run will catch this before the change merges.
- **[Risk] Catalog rename breaks other consumers of the version ref** → Mitigation: ref is only used by the `junit-jupiter` library entry in this repo; grep confirms no other usage. A repo-wide grep for `junitVintage` is part of the task list.
- **[Trade-off] Coverage of `CalStartTest`/`CharsetTest`/`CalendarBuilderTest` becomes implicit in Spock specs rather than visible as standalone Java classes** → Acceptable: behavior coverage is preserved; the change reduces total test source by removing duplicated harness scaffolding.

## Migration Plan

1. Rename the versions-catalog key and run `./gradlew test` to confirm the rename alone is harmless.
2. Add the Factory case to `CalStartSpec.groovy`; delete `CalStartTest.java`; run tests.
3. Create `lotus/CharsetSpec.groovy`; delete `CharsetTest.java`; run tests.
4. Create `CalendarBuilderSpec.groovy` with `where:` parameterization; delete `CalendarBuilderTest.java`; run tests.
5. Add the `junit:junit` exclusion in `build.gradle`; confirm via `./gradlew dependencies --configuration testCompileClasspath | grep "junit:junit"` returning nothing; run tests.

Rollback: each step is a separate commit; revert in reverse order if needed.
