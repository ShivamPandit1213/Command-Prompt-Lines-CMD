CommandLines.java = CMD + Java + Copilot + Git + Maven + Appium + Jenkins + Cypress + Playwright + Cucumber + mysql
# CommandLines

CMD + Java + Copilot + Git + Maven + Appium + Jenkins + Cypress + Playwright + Cucumber + MySQL

## Table of Contents

- [Maven CLI Options](#maven-cli-options)
- [Git Commands](#git-commands)
- [Jenkins Commands](#jenkins-commands)
  - [Jenkins CLI](#jenkins-cli)
  - [Common CI shell steps](#common-ci-shell-steps)
- [Java Commands (JDK tools)](#java-commands-jdk-tools)
- [Playwright](#playwright)
  - [Core Commands](#core-commands)
  - [Filtering Tests](#filtering-tests)
  - [Debugging and Execution](#debugging-and-execution)
  - [Trace Viewer](#trace-viewer)
- [Cucumber](#cucumber)
  - [Cucumber-JVM](#cucumber-jvm)
  - [Cucumber-JS](#cucumber-js)
- [Everyday Commands](#everyday-commands)

## Maven CLI Options

| Command | Purpose |
|---|---|
| `-am, --also-make` | Also build the projects that your selected projects depend on |
| `-amd, --also-make-dependents` | Also build the projects that depend on your selected projects |
| `-B, --batch-mode` | Run non-interactively (for CI); turns off colored output |
| `-b, --builder <arg>` | Pick which build strategy to use, by id |
| `-C, --strict-checksums` | Fail the build on a checksum mismatch |
| `-c, --lax-checksums` | Only warn on a checksum mismatch |
| `--color <arg>` | Set output color mode: `auto`, `always`, or `never` |
| `-cpu, --check-plugin-updates` | Does nothing — kept only for backward compatibility |
| `-D, --define <arg>` | Set a user property, e.g. `-Dkey=value` |
| `-e, --errors` | Show full error messages when something fails |
| `-emp, --encrypt-master-password <arg>` | Encrypt the master security password |
| `-ep, --encrypt-password <arg>` | Encrypt a server password |
| `-f, --file <arg>` | Use a different POM file or directory instead of the default |
| `-fae, --fail-at-end` | Keep building unaffected modules, report failures at the end |
| `-ff, --fail-fast` | Stop as soon as the first module fails |
| `-fn, --fail-never` | Never fail the build, whatever the result |
| `-gs, --global-settings <arg>` | Use a different global settings file |
| `-gt, --global-toolchains <arg>` | Use a different global toolchains file |
| `-h, --help` | Show help |
| `-itr, --ignore-transitive-repositories` | Ignore remote repositories pulled in by transitive dependencies |
| `-l, --log-file <arg>` | Write all build output to a log file; turns off colored output |
| `-llr, --legacy-local-repository` | Unsupported — using it makes Maven fail |
| `-N, --non-recursive` | Build only this project, skip its sub-projects |
| `-npr, --no-plugin-registry` | Does nothing — kept only for backward compatibility |
| `-npu, --no-plugin-updates` | Does nothing — kept only for backward compatibility |
| `-nsu, --no-snapshot-updates` | Don't check for updated SNAPSHOT versions |
| `-ntp, --no-transfer-progress` | Hide download/upload progress output |
| `-o, --offline` | Build offline, using only the local repository |
| `-P, --activate-profiles <arg>` | Turn on specific profiles (comma-separated) |
| `-pl, --projects <arg>` | Build only the listed modules, by `[groupId]:artifactId` or relative path |
| `-q, --quiet` | Show errors only |
| `--raw-streams` | Ignored (a Maven 4 option) |
| `-rf, --resume-from <arg>` | Restart a multi-module build from a given project |
| `-s, --settings <arg>` | Use a different user settings file |
| `-t, --toolchains <arg>` | Use a different user toolchains file |
| `-T, --threads <arg>` | Build in parallel, e.g. `4` threads or `2C` (2 × CPU cores) |
| `-U, --update-snapshots` | Force a re-check for updated snapshots and missing releases |
| `-up, --update-plugins` | Does nothing — kept only for backward compatibility |
| `-v, --version` | Show version and exit |
| `-V, --show-version` | Show version and keep building |

## Git Commands

| Command | Purpose |
|---|---|
| `git init` | Create a new repository in the current folder |
| `git clone <url>` | Copy a remote repository to your machine |
| `git status` | Show changed, staged, and untracked files |
| `git add <file>` | Stage a file for the next commit (`git add .` for all) |
| `git commit -m "msg"` | Save staged changes with a message |
| `git commit -am "msg"` | Stage all tracked changes and commit in one step |
| `git log --oneline` | Show commit history, one line each |
| `git diff` | Show unstaged changes; `git diff --staged` for staged |
| `git branch` | List branches; `git branch <name>` to create one |
| `git checkout <branch>` | Switch to a branch (or `git switch <branch>`) |
| `git checkout -b <branch>` | Create a branch and switch to it |
| `git merge <branch>` | Merge another branch into the current one |
| `git rebase <branch>` | Reapply your commits on top of another branch |
| `git pull` | Fetch and merge changes from the remote |
| `git push` | Send your commits to the remote |
| `git push -u origin <branch>` | Push a new branch and set it to track the remote |
| `git remote -v` | List configured remotes |
| `git fetch` | Download remote changes without merging |
| `git stash` | Shelve uncommitted changes; `git stash pop` to restore |
| `git reset <file>` | Unstage a file (keeps changes) |
| `git reset --hard <commit>` | Discard everything back to a commit (destructive) |
| `git revert <commit>` | Create a new commit that undoes a past one |
| `git tag <name>` | Mark a commit (e.g. a release version) |
| `git cherry-pick <commit>` | Apply a single commit from elsewhere |
| `git restore <file>` | Discard changes in a file (newer alternative to checkout) |

## Jenkins Commands

Jenkins is mostly UI-driven; command-line access is via the CLI jar or REST API.

### Jenkins CLI

Invoke with `java -jar jenkins-cli.jar -s <URL>`.

| Command | Purpose |
|---|---|
| `help` | List available CLI commands |
| `version` | Show the Jenkins version |
| `list-jobs` | List all jobs |
| `build <job>` | Trigger a job build |
| `build <job> -f -v` | Trigger a build, follow it, and stream console output |
| `build <job> -p KEY=VALUE` | Trigger a parameterized build |
| `console <job>` | Print a job's console output |
| `get-job <job>` | Export a job's `config.xml` |
| `create-job <job>` | Create a job from a piped `config.xml` |
| `update-job <job>` | Update a job's config from piped XML |
| `delete-job <job>` | Delete a job |
| `disable-job <job>` / `enable-job <job>` | Disable or enable a job |
| `safe-restart` | Restart Jenkins after builds finish |
| `restart` | Restart Jenkins immediately |
| `reload-configuration` | Reload config from disk |
| `who-am-i` | Show your credentials and permissions |
| `install-plugin <name>` | Install a plugin |

### Common CI shell steps

What a pipeline usually runs.

| Command | Purpose |
|---|---|
| `mvn clean package` | Build and package a Maven project |
| `mvn test` | Run tests in a build stage |
| `git pull` | Pull latest code at the start of a job |
| `docker build -t <img> .` | Build a Docker image in a pipeline |

## Java Commands (JDK tools)

| Command | Purpose |
|---|---|
| `java <MainClass>` | Run a compiled class with a `main` method |
| `java -jar app.jar` | Run an executable JAR |
| `java Main.java` | Compile and run a single source file directly (Java 11+) |
| `java -version` | Show the installed Java version |
| `java -cp <path> <Class>` | Run with a specific classpath |
| `java -D<key>=<value> ...` | Pass a system property to the program |
| `java -Xmx512m ...` | Set max heap size (memory) |
| `javac <File>.java` | Compile a source file to `.class` bytecode |
| `javac -d out src/*.java` | Compile into an output directory |
| `javac -cp <path> <File>.java` | Compile against a classpath |
| `jar cf app.jar *.class` | Create a JAR from class files |
| `jar cfe app.jar Main *.class` | Create an executable JAR with a main class (entry point) |
| `jar tf app.jar` | List the contents of a JAR |
| `jar xf app.jar` | Extract a JAR |
| `javadoc <File>.java` | Generate HTML API documentation |
| `jshell` | Open the interactive Java REPL |
| `jps` | List running Java processes |
| `jstack <pid>` | Print a thread dump for a running process |
| `keytool -list -keystore <file>` | Manage keys/certificates (SSL testing) |

## Playwright

### Core Commands

| Command | Purpose |
|---|---|
| `npx playwright test` | Run all tests in the project |
| `npx playwright test <file>` | Run one spec file, e.g. `tests/login.spec.ts` |
| `npx playwright test <file>:<line>` | Run the single test at that line number |
| `npx playwright show-report` | Open the HTML report from the last run |
| `npx playwright codegen <url>` | Record browser actions and generate test code |
| `npx playwright install` | Download the browser binaries |
| `npx playwright install chromium` | Download one browser only |
| `npx playwright install --with-deps` | Install browsers plus OS-level dependencies (Linux/CI) |
| `npx playwright install-deps` | Install only the OS dependencies |
| `npm init playwright@latest` | Scaffold a new Playwright project |
| `npx playwright --version` | Print the installed version |

### Filtering Tests

| Command | Purpose |
|---|---|
| `--grep <pattern>`, `-g` | Run only tests whose title matches, e.g. `-g @smoke` |
| `--grep-invert <pattern>` | Run everything except matches |
| `--project=<name>` | Run one project or browser, e.g. `--project=chromium` |
| `--only-changed` | Run only tests affected by uncommitted git changes |
| `--last-failed` | Re-run only the tests that failed last time |
| `--shard=<n>/<total>` | Split the suite across machines, e.g. `--shard=1/4` |

### Debugging and Execution

| Command | Purpose |
|---|---|
| `--ui` | Open interactive UI mode with time-travel and DOM snapshots |
| `--headed` | Show the browser window instead of running headless |
| `--debug` | Launch the Playwright Inspector and step through |
| `--trace=on` | Record a trace for every test (`on-first-retry` is the usual CI setting) |
| `--workers=<n>` | Set parallel worker count; `--workers=1` forces serial |
| `--repeat-each=<n>` | Run each test N times, useful for hunting flaky tests |
| `--retries=<n>` | Retry failed tests N times |
| `--max-failures=<n>`, `-x` | Stop after N failures (`-x` stops at the first) |
| `--timeout=<ms>` | Override the per-test timeout |
| `--reporter=<name>` | Choose reporter: `list`, `line`, `dot`, `html`, `json`, `junit` |
| `--update-snapshots`, `-u` | Regenerate visual and snapshot baselines |
| `--list` | List matching tests without running them |
| `--config=<file>`, `-c` | Use a specific config file |

### Trace Viewer

| Command | Purpose |
|---|---|
| `npx playwright show-trace <file.zip>` | Open a recorded trace |
| `npx playwright show-trace` | Open the trace viewer and drop a file in |
| `npx playwright open <url>` | Open a page in a Playwright-controlled browser |

## Cucumber

### Cucumber-JVM

For Maven + TestNG. Cucumber-JVM has no CLI of its own in a Maven project —
drive it through Maven and system properties.

| Command | Purpose |
|---|---|
| `mvn test` | Run all features via your runner class |
| `mvn test -Dcucumber.filter.tags="@smoke"` | Run scenarios with one tag |
| `mvn test -Dcucumber.filter.tags="@smoke and not @wip"` | Combine tags with `and`, `or`, `not` |
| `mvn test -Dcucumber.filter.name="login"` | Filter by scenario name |
| `mvn test -Dcucumber.features=<path>` | Run one feature file |
| `mvn test -Dcucumber.plugin="pretty,html:target/report.html"` | Set reporters |
| `mvn test -Dcucumber.glue=<package>` | Point at the step-definition package |
| `mvn test -Dcucumber.execution.dry-run=true` | Check step bindings without executing |
| `mvn test -Dcucumber.publish.quiet=true` | Suppress the publish-report banner |
| `mvn test -Dtest=<RunnerClass>` | Run a specific TestNG runner class |

The dry run is the fastest way to find missing step definitions. It prints
snippets for anything unmatched.

### Cucumber-JS

For Node.

| Command | Purpose |
|---|---|
| `npx cucumber-js` | Run all features |
| `npx cucumber-js <file>` | Run one feature file |
| `npx cucumber-js --tags "@smoke"` | Filter by tag |
| `npx cucumber-js --tags "@smoke and not @wip"` | Combined tag expression |
| `npx cucumber-js --name "login"` | Filter by scenario name |
| `npx cucumber-js --dry-run` | Validate step bindings without running |
| `npx cucumber-js --format html:report.html` | Choose output format |
| `npx cucumber-js --parallel <n>` | Run N scenarios concurrently |
| `npx cucumber-js --retry <n>` | Retry failing scenarios |
| `npx cucumber-js --fail-fast` | Stop on first failure |
| `npx cucumber-js --require <path>` | Load support and step files |

## Everyday Commands

```bash
# Writing tests: fast loop, one browser, interactive
npx playwright test --project=chromium --ui

# Quick tagged check on the Java suite
mvn test -Dcucumber.filter.tags="@smoke"

# When a step mysteriously does not fire
mvn test -Dcucumber.execution.dry-run=true
```
