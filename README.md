CommandLines.java = CMD + Java + Copilot + Git + Maven + Appium + Jenkins + Cypress + Playwright + Cucumber + mysql

LaptopConfiguration.java = Port Configuratio

Options:
 -am,--also-make                         If project list is specified, also build projects required by the list
 -amd,--also-make-dependents             If project list is specified, also build projects that depend on projects on the list
 -B,--batch-mode                         Run in non-interactive (batch) mode (disables output color)
 -b,--builder <arg>                      The id of the build strategy to use
 -C,--strict-checksums                   Fail the build if checksums don't match
 -c,--lax-checksums                      Warn if checksums don't match
    --color <arg>                        Defines the color mode of the output. Supported are 'auto', 'always', 'never'.
 -cpu,--check-plugin-updates             Ineffective, only kept for backward compatibility
 -D,--define <arg>                       Define a user property
 -e,--errors                             Produce execution error messages
 -emp,--encrypt-master-password <arg>    Encrypt master security password
 -ep,--encrypt-password <arg>            Encrypt server password
 -f,--file <arg>                         Force the use of an alternate POM file (or directory with pom.xml)
 -fae,--fail-at-end                      Only fail the build afterwards; allow all non-impacted builds to continue
 -ff,--fail-fast                         Stop at first failure in reactorized builds
 -fn,--fail-never                        NEVER fail the build, regardless of project result
 -gs,--global-settings <arg>             Alternate path for the global settings file
 -gt,--global-toolchains <arg>           Alternate path for the global toolchains file
 -h,--help                               Display help information
 -itr,--ignore-transitive-repositories   If set, Maven will ignore remote repositories introduced by transitive dependencies.
 -l,--log-file <arg>                     Log file where all build output will go (disables output color)
 -llr,--legacy-local-repository          UNSUPPORTED: Use of this option will make Maven invocation fail.
 -N,--non-recursive                      Do not recurse into sub-projects
 -npr,--no-plugin-registry               Ineffective, only kept for backward compatibility
 -npu,--no-plugin-updates                Ineffective, only kept for backward compatibility
 -nsu,--no-snapshot-updates              Suppress SNAPSHOT updates
 -ntp,--no-transfer-progress             Do not display transfer progress when downloading or uploading
 -o,--offline                            Work offline
 -P,--activate-profiles <arg>            Comma-delimited list of profiles to activate
 -pl,--projects <arg>                    Comma-delimited list of specified reactor projects to build instead of all projects. A project can be specified by [groupId]:artifactId or by its relative path
 -q,--quiet                              Quiet output - only show errors
    --raw-streams                        Ignored (Maven4 option)
 -rf,--resume-from <arg>                 Resume reactor from specified project
 -s,--settings <arg>                     Alternate path for the user settings file
 -t,--toolchains <arg>                   Alternate path for the user toolchains file
 -T,--threads <arg>                      Thread count, for instance 4 (int) or 2C/2.5C (int/float) where C is core multiplied
 -U,--update-snapshots                   Forces a check for missing releases and updated snapshots on remote repositories
 -up,--update-plugins                    Ineffective, only kept for backward compatibility
 -v,--version                            Display version information
 -V,--show-version                       Display version information WITHOUT stopping build
 -X,--debug                              Produce execution debug output


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


Here are all three as GitHub-ready command → purpose tables.
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

### Jenkins CLI (`java -jar jenkins-cli.jar -s <URL>`)
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

### Common CI shell steps (what a pipeline usually runs)
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
