Structure:- Maven — Project Structure
    jobApply_Naukri/
├── pom.xml                    # MANDATORY — defines the whole project
├── src/
│   ├── main/
│   │   ├── java/              # application source code
│   │   └── resources/         # config files, .properties, etc.
│   └── test/
│       ├── java/              # test code (e.g. Selenium tests)
│       └── resources/         # test data, testng.xml, etc.
└── target/                    # GENERATED build output — wiped by `clean`
    
2. What is actually mandatory
File / folder	Required?	Notes
pom.xml	Mandatory	The only strictly required file. No pom = no build.
src/main/java	Conventional	Needed to have any code to compile.
src/main/resources	Optional	Only if the app needs config/resource files.
src/test/java	Conventional	Needed for mvn test to run tests.
src/test/resources	Optional	Only if tests need data files.
target/	Generated	Created by Maven; never edit or commit it.
~/.m2/repository	Generated	Local dependency cache; lives outside the project.

3. Build lifecycle (flow)
Phases run in order, and each phase runs all earlier phases first. So mvn install silently runs everything from validate down to install.
    validate   ──►  check the project is correct
    compile    ──►  compile source from src/main/java
    test       ──►  run unit tests from src/test/java
    package    ──►  build the jar / war into target/
    verify     ──►  run integration checks
    install    ──►  copy the jar into ~/.m2/repository
    deploy     ──►  push the jar to a remote repository
clean is a separate lifecycle that deletes the target/ folder. That is why you run both together:
    mvn clean install
= wipe target/, then run validate → compile → test → package → verify → install.

4. Which files feed which phase
    pom.xml          ──►  read first, governs the entire run
    src/main/java    ──►  compile
    src/test/java    ──►  test
    package          ──►  writes jar  →  target/
    install          ──►  copies jar  →  ~/.m2/repository

5. Common commands
Command	What it does
    mvn -version	    Verify Maven + Java setup
    mvn compile	        Compile src/main/java
    mvn test	        Compile and run tests
    mvn package	        Build the jar/war into target/
    mvn install	        Build + copy jar into local ~/.m2 repo
    mvn clean	        Delete the target/ folder
    mvn clean install	Clean, then full build up to install
    
6. .gitignore reminder
The target/ folder is generated and should never be committed. Make sure your .gitignore contains at least:
    target/
    
```mermaid
flowchart TB
    subgraph root["project-root/"]
        direction TB
        pom["pom.xml — Required: defines the whole project"]:::req
        subgraph src["src/"]
            direction TB
            subgraph main["main/"]
                direction TB
                mjava["java/ — application source code (required)"]:::req
                mres["resources/ — config, .properties files (optional)"]:::opt
            end
            subgraph test["test/"]
                direction TB
                tjava["java/ — test code, e.g. Selenium tests (optional)"]:::opt
                tres["resources/ — test data, testng.xml (optional)"]:::opt
            end
        end
        target["target/ — Auto-generated build output: never create or commit"]:::build
        gi[".gitignore — recommended, list target/ here (optional)"]:::opt
    end
```
Flow:
  ```mermaid
flowchart LR
    A["validate<br/>Check project is correct"] --> B["compile<br/>Compile source code"]
    B --> C["test<br/>Run unit tests"]
    C --> D["package<br/>Build jar / war"]
    D --> E["verify<br/>Run integration checks"]
    E --> F["install<br/>Copy to local repo"]
    F --> G["deploy<br/>Push to remote repo"]

    classDef phase fill:#e8f1fb,stroke:#5b9bd5,color:#1f4e78
    class A,B,C,D,E,F,G phase
```
Strictly mandatory (Maven fails without it):
pom.xml — this is the only file Maven absolutely requires. No POM, no project (that's the exact "there is no POM in this directory" error you hit earlier). It defines your coordinates, dependencies, plugins, and build config.
src/main/java/ — you need source code somewhere for there to be anything to build. Technically Maven won't error on an empty project, but for a real build this is the required home for your .java files.

Convention (expected by default, but optional):
src/main/resources/ — only needed if you have config/properties files.
src/test/java/ and src/test/resources/ — only needed if you have tests. In your jobApply_Naukri project your Selenium tests live here.

Auto-generated (you never create these):
target/ — Maven creates it during the build and clean deletes it. This is the folder that caused your OneDrive lock problem.
.m2/repository — not in the project at all; it's your global local repo at C:\Users\shiva\.m2\ where dependencies and installed artifacts are cached.

How this maps to the flow: each lifecycle phase reads from the mandatory locations and writes to target/:

compile reads src/main/java/ → writes compiled classes to target/classes/
test reads src/test/java/ → compiles to target/test-classes/, runs them
package bundles target/classes/ → produces the jar in target/
install copies that jar → into .m2/repository

So pom.xml tells Maven the rules, src/ holds what you wrote, and target/ holds everything Maven produced. That's the entire contract — nothing else in the tree is required for Maven to run.
