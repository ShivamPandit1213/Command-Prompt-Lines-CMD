CommandLines.java = CMD + Java + Copilot + Git + Maven + Appium + Jenkins + Cypress + Playwright + Cucumber + mysql
# CommandLines

CMD + Java + Copilot + Git + Maven + Appium + Jenkins + Cypress + Playwright + Cucumber + MySQL

Every tool section opens the same way: **install**, **verify the installed
version**, then **open / launch** it.

## Table of Contents

- [Open Applications](#open-applications)
- [Open Any Custom App](#open-any-custom-app)
- [CMD (Windows Command Prompt)](#cmd-windows-command-prompt)
  - [Install CMD](#install-cmd)
  - [Open Applications from CMD](#open-applications-from-cmd)
  - [CMD Essentials](#cmd-essentials)
- [Maven](#maven)
  - [Install Maven](#install-maven)
  - [Maven CLI Options](#maven-cli-options)
- [Git](#git)
  - [Install Git](#install-git)
  - [Git Commands](#git-commands)
- [Jenkins](#jenkins)
  - [Install Jenkins](#install-jenkins)
  - [Jenkins CLI](#jenkins-cli)
  - [Common CI shell steps](#common-ci-shell-steps)
- [Java](#java)
  - [Install Java](#install-java)
  - [Java Commands (JDK tools)](#java-commands-jdk-tools)
- [Playwright](#playwright)
  - [Install Playwright](#install-playwright)
  - [Open Playwright](#open-playwright)
  - [Core Commands](#core-commands)
  - [Filtering Tests](#filtering-tests)
  - [Debugging and Execution](#debugging-and-execution)
  - [Trace Viewer](#trace-viewer)
- [Cucumber](#cucumber)
  - [Install Cucumber](#install-cucumber)
  - [Cucumber-JVM](#cucumber-jvm)
  - [Cucumber-JS](#cucumber-js)
- [Everyday Commands](#everyday-commands)

## Open Applications

One line per tool — how to actually launch it once it is installed.

| Tool | Open with |
|---|---|
| CMD | `start cmd`, or `Win + R` then `cmd` |
| Windows Terminal | `wt` |
| Maven | No app to open — `mvn -V <goal>` prints the version as a build starts |
| Git | `git gui` (commit tool), `gitk` (history browser), `git help -w <cmd>` (docs in browser) |
| Jenkins | `java -jar jenkins.war --httpPort=8080`, then `start http://localhost:8080` |
| Java | `jshell` (REPL), `jconsole` (JVM monitoring GUI) |
| Playwright | `npx playwright test --ui` — see [Open Playwright](#open-playwright) for the full list |
| Cucumber (JVM) | No app — `start target\report.html` opens the generated report |
| Cucumber (JS) | `start report.html`, after running with `--format html:report.html` |
| VS Code | `code .` opens the current folder |
| **Any custom app** | `start "" "C:\Path\To\app.exe"` — see [Open Any Custom App](#open-any-custom-app) |

`jconsole` ships with the JDK. VisualVM was removed from the JDK in Java 9 and
is now a separate download, so `jvisualvm` will not resolve on a modern install.

## Open Any Custom App

For an app that is not on `PATH` and has no registered short name.

| Command | Purpose |
|---|---|
| `start "" "C:\Program Files\MyApp\app.exe"` | Launch by full path — quotes are required if the path has spaces |
| `start "" "C:\MyApp\app.exe" arg1 arg2` | Launch with arguments |
| `start "" /d "C:\workdir" "C:\MyApp\app.exe"` | Launch with a specific working directory |
| `"C:\MyApp\app.exe"` | Run directly — the app is tied to this window and blocks it |
| `start "" "C:\Users\me\Desktop\MyApp.lnk"` | Launch through a shortcut file |
| `start "" "C:\docs\notes.pdf"` | Open any file with its registered default app |
| `where app.exe` | Check whether the app resolves on `PATH` at all |
| `set PATH=%PATH%;C:\MyApp` | Add its folder to `PATH` for this session only |
| `doskey myapp="C:\MyApp\app.exe" $*` | Make a short alias for this session (`$*` forwards arguments) |
| `runas /user:Administrator "C:\MyApp\app.exe"` | Launch as another user |
| `powershell -c "Get-StartApps"` | List Store/UWP apps and their package family names |
| `start shell:AppsFolder\<PackageFamilyName>!App` | Launch a Store/UWP app, which has no exe path |

**The empty `""` is not a typo.** `start` treats a leading quoted argument as
the window title, so `start "C:\My App\app.exe"` opens a console titled with
that path instead of launching anything. The empty string absorbs the title
slot.

To make a custom app permanently callable by name, put a one-line
`myapp.bat` containing `@"C:\MyApp\app.exe" %*` into any folder already on
`PATH`. That is safer than editing `PATH` itself — `setx PATH "%PATH%;C:\MyApp"`
flattens the user and system paths into one value and truncates at 1024
characters, which is a common way to wreck a working environment. Use
`sysdm.cpl` → Environment Variables if you do need to edit `PATH`.

## CMD (Windows Command Prompt)

### Install CMD

| Step | Command |
|---|---|
| Install | Built into Windows — `C:\Windows\System32\cmd.exe`, nothing to install |
| Verify version | `ver` |
| Open | `Win + R` then `cmd`, or `start cmd` from another shell |

Use `start powershell` or `wt` (Windows Terminal) if you want the newer shells
instead.

### Open Applications from CMD

| Command | Purpose |
|---|---|
| `start <app>` | Launch an app or file with its default handler |
| `start "" "C:\Path\To\app.exe"` | Launch an exe by full path (the empty `""` is the window title) |
| `start .` | Open the current folder in File Explorer |
| `explorer <path>` | Open a specific folder in File Explorer |
| `start <file>` | Open a file in whatever app is registered for it |
| `start notepad <file>` | Open a file in Notepad |
| `start chrome <url>` | Open Chrome, optionally at a URL |
| `start msedge <url>` | Open Edge |
| `start firefox <url>` | Open Firefox |
| `start http://localhost:8080` | Open a URL in the default browser (e.g. the Jenkins dashboard) |
| `start /wait <app>` | Launch and block until the app exits |
| `start /b <cmd>` | Run in the background, without opening a new window |
| `start /max <app>` / `start /min <app>` | Launch maximized or minimized |
| `code .` | Open the current folder in VS Code |
| `taskmgr` | Task Manager |
| `mstsc` | Remote Desktop Connection |
| `control` | Control Panel |
| `services.msc` | Services console (useful for a Jenkins Windows service) |
| `sysdm.cpl` | System Properties — where `JAVA_HOME` and `PATH` are set |

`start` hands off to the shell and returns immediately, so the terminal stays
usable. Running `app.exe` directly instead ties the app to that window.

### CMD Essentials

| Command | Purpose |
|---|---|
| `cd <path>` | Change directory; `cd ..` goes up one level |
| `cd /d D:\projects` | Change directory *and* drive in one step |
| `dir` | List the contents of the current folder |
| `where <cmd>` | Show which executable a command resolves to |
| `echo %PATH%` | Print an environment variable |
| `set VAR=value` | Set a variable for this session only |
| `setx VAR "value"` | Set a variable permanently (new windows only) |
| `tasklist` | List running processes |
| `taskkill /IM <name>.exe /F` | Force-kill a process by name |
| `netstat -ano \| findstr :8080` | Find what is holding a port |
| `cls` | Clear the screen |
| `type <file>` | Print a file's contents |
| `<cmd> > out.txt` | Redirect output to a file (`>>` appends) |
| `<cmd> 2>&1` | Merge error output into standard output |

## Maven

### Install Maven

| Step | Command |
|---|---|
| Install (macOS) | `brew install maven` |
| Install (Debian/Ubuntu) | `sudo apt install maven` |
| Install (Windows) | `choco install maven` or `winget install Apache.Maven` |
| Verify version | `mvn -v` |
| Open | No interactive shell — `mvn -V <goal>` prints the version as a build starts |

`mvn -v` also prints the JDK and OS Maven is running against, which is usually
the thing that is actually wrong.

### Maven CLI Options

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

## Git

### Install Git

| Step | Command |
|---|---|
| Install (macOS) | `brew install git` |
| Install (Debian/Ubuntu) | `sudo apt install git` |
| Install (Windows) | `winget install Git.Git` or `choco install git` |
| Verify version | `git --version` |
| Open | `git gui` (commit tool) or `gitk` (history browser), both bundled |

### Git Commands

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

## Jenkins

Jenkins is mostly UI-driven; command-line access is via the CLI jar or REST API.

### Install Jenkins

| Step | Command |
|---|---|
| Install (macOS) | `brew install jenkins-lts` |
| Install (Debian/Ubuntu) | `sudo apt install jenkins` |
| Install (Windows) | `choco install jenkins`, or download `jenkins.war` |
| Verify version | `java -jar jenkins-cli.jar -s <URL> version` |
| Open | `java -jar jenkins.war --httpPort=8080`, then `start http://localhost:8080` |

On first launch the unlock key is printed to the console and written to
`<JENKINS_HOME>/secrets/initialAdminPassword`. Download the CLI jar from
`<URL>/jnlpJars/jenkins-cli.jar` once the server is up.

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

## Java

### Install Java

| Step | Command |
|---|---|
| Install (macOS) | `brew install openjdk@21` |
| Install (Debian/Ubuntu) | `sudo apt install openjdk-21-jdk` |
| Install (Windows) | `winget install EclipseAdoptium.Temurin.21.JDK` |
| Verify version | `java -version` and `javac -version` |
| Open | `jshell` — the interactive Java REPL |

If `java -version` works but `javac -version` does not, you have a JRE rather
than a JDK, or `JAVA_HOME` points at the wrong install.

### Java Commands (JDK tools)

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

### Install Playwright

| Step | Command |
|---|---|
| Install (new project) | `npm init playwright@latest` |
| Install (existing project) | `npm i -D @playwright/test` then `npx playwright install` |
| Verify version | `npx playwright --version` |
| Open | `npx playwright test --ui`, or `npx playwright open <url>` |

On Linux and CI use `npx playwright install --with-deps` so the OS-level
libraries land too.

### Open Playwright

Everything Playwright can open, in one place.

| Command | Opens |
|---|---|
| `npx playwright test --ui` | UI mode — watch mode, time travel, DOM snapshots |
| `npx playwright test --ui-port=<n>` | UI mode on a fixed port |
| `npx playwright test --headed` | The test run in a visible browser window |
| `npx playwright test --debug` | The Playwright Inspector, stepping through the test |
| `npx playwright test <file>:<line> --debug` | The Inspector on one specific test |
| `set PWDEBUG=1 && npx playwright test` | Same as `--debug`, via env var (CMD syntax) |
| `npx playwright open <url>` | A page in a Playwright-controlled browser |
| `npx playwright open --device="iPhone 15" <url>` | The same page with a device emulated |
| `npx playwright cr <url>` | Shorthand for opening in Chromium (`ff` Firefox, `wk` WebKit) |
| `npx playwright codegen <url>` | The recorder, generating test code as you click |
| `npx playwright codegen --device="Pixel 7" <url>` | The recorder in device emulation |
| `npx playwright codegen --save-storage=auth.json <url>` | The recorder, saving the login state on exit |
| `npx playwright show-report` | The HTML report from the last run |
| `npx playwright show-report <dir>` | A report from a specific folder |
| `start http://localhost:9323` | The report server directly (its default port) |
| `npx playwright show-trace <file.zip>` | The Trace Viewer on a recorded trace |
| `npx playwright show-trace` | An empty Trace Viewer to drop a file into |

Traces only exist if the run recorded them — `--trace=on` locally, or
`--trace=on-first-retry` in CI.

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

### Install Cucumber

| Step | Command |
|---|---|
| Install (JVM) | Add `io.cucumber:cucumber-java` and `cucumber-testng` to `pom.xml`, then `mvn clean install` |
| Install (Node) | `npm i -D @cucumber/cucumber` |
| Verify version (JVM) | `mvn dependency:tree -Dincludes=io.cucumber` |
| Verify version (Node) | `npx cucumber-js --version` |
| Open | No UI — `--dry-run` is the closest thing to a smoke check of the wiring |

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
