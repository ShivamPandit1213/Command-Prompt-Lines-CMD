CMD
cd /d d:  	for change drive
cd\  		start from c drive
cd.. 		one folder back
dir  		To know file and folder name avilable in current directory
cls  		To clear Command Prompt
C:			To go back to C drive

	mkdir: stands for Make Directory. You use it to create a new, empty folder.  
	rmdir: stands for Remove Directory. You use it to delete an existing folder.  
_________________________________________________________________________
== Java	
For Run Java Program
  Compile Program                   C:\Users\Your Name>javac Main.java
  Run Java Program                  C:\Users\Your Name>java Main -> Hello World

Environment Variables -> System variables -> New:
Variable Name:		JAVA_HOME
Variable Value:		C:\Program Files\Java\jdk-17
System variables -> Path -> Edit -> New: %JAVA_HOME%\bin
______________________________________________________________________________________
== Copilot:
How to Test It: copilot --help
generate commands: copilot suggest "how do I undo my last git commit?"
______________________________________________________________________________________
For	                 Commands	                                     Work
	        	    driverquery	                                    Lists All Installed Drivers	
	            	powershell start cmd -v runAs 	                Run the Command Prompt as an Administrator	
					cd\  											start from c drive
	                chdir or cd	                                    Changes the Current Working Directory to the Specified Directory	
					cd /d d:  										for change drive
	                systeminfo	                                    Shows Your PC's Details	cd.. one folder back
--------------------------------------------------------------------------
change location or set path for apps ex. git: cd C:\Users\shiva\OneDrive\JavaSelenium
one folder back[Git]: cd ..	
Delete the copied .git folder/directory on Windows: rmdir /S /Q .git
Create Folder with a space (requires quotes): mkdir "Eclipse Workspace" -> cd "Eclipse Workspace"
Create Folder with a hyphen/underscore (Recommended for coding environments): mkdir eclipse-workspace -> cd eclipse-workspace
	
Copy data from one folder to another:
Using xcopy (Best for general use): xcopy "C:\path\to\source_folder" "C:\path\to\new_folder" /E /I /H /Y
		/E – Copies all sub-folders, even if they are empty.
		/I – Tells Windows that the destination is a folder (so it automatically creates the new folder if it doesn't exist).
		/H – Copies hidden files and system files, too.
		/Y – Suppresses the "Are you sure you want to overwrite?" prompt if files already exist in the destination.
Using robocopy (Best for large or complex transfers): robocopy "C:\path\to\source_folder" "C:\path\to\new_folder" /E
		/E – Copies all sub-directories, including empty ones. (Robocopy automatically creates the destination folder if it doesn't exist, so you don't need the /I flag like you do with xcopy).

Give folder permission - change access to Administrator[Extenal Drive] -> Run Command Prompt as Administrator
	takeown /F "F:\WindowsApps" /R /D Y
	icacls "F:\WindowsApps" /grant administrators:F /T
✅ What this does:
	takeown changes ownership to the Administrators group (recursively)
	icacls gives Full Control permissions to Administrators
	
	takeown /F "E:\Applications" /R /D Y
	icacls "E:\Applications" /grant administrators:F /T
Explanation:
	takeown — makes the Administrators group the owner of all files and subfolders inside E:\Applications
	icacls — grants that group Full Control
		/R and /T — apply changes recursively through all subfolders	
______________________________________________________________________________________
== Maven Commands
project-folder/
│
├── src/
│   ├── main/                                 # Main application code
│   │   ├── java/                             # Java source code
│   │   │   └── com/example/app/
│   │   │       ├── pages/                    # Page Object Model classes
│   │   │       │   ├── LoginPage.java        # Login page locators & methods
│   │   │       │   ├── DashboardPage.java    # Dashboard page methods
│   │   │       │   └── CheckoutPage.java     # Checkout page methods
│   │   │
│   │   │       ├── utils/                    # Utility/helper classes
│   │   │       │   ├── ConfigReader.java     # Reads config.properties
│   │   │       │   ├── DriverFactory.java    # WebDriver initialization
│   │   │       │   └── TestDataGenerator.java# Dynamic/random data generation
│   │   │
│   │   │       ├── base/                     # Base classes
│   │   │       │   └── BaseTest.java         # Common setup/teardown methods
│   │   │
│   │   │       └── listeners/                # Test listeners
│   │   │           └── TestListener.java     # Screenshot/logging/report hooks
│   │   │
│   │   └── resources/                        # Non-Java files used by main code
│   │       ├── config.properties             # Environment/configuration values
│   │       ├── testdata/                     # Static test data files
│   │       └── log4j2.xml                    # Logging configuration
│   │
│   ├── test/                                 # Test code
│   │   ├── java/                             # Test classes
│   │   │   └── com/example/tests/
│   │   │       ├── login/                    # Login-related test classes
│   │   │       │   └── LoginTest.java
│   │   │       ├── dashboard/
│   │   │       │   └── DashboardTest.java
│   │   │       └── checkout/
│   │   │           └── CheckoutTest.java
│   │   │
│   │   │       └── stepdefinitions/          # If using Cucumber
│   │   │           └── LoginSteps.java
│   │   │
│   │   └── resources/                        # Test resources
│   │       ├── features/                     # Cucumber feature files
│   │       ├── testng.xml                   # TestNG suite file
│   │       └── extent-config.xml             # Extent Report config
│
├── target/                                   # Auto-generated build/output folder
│   ├── surefire-reports/                     # Test execution reports
│   ├── screenshots/                          # Failure screenshots
│   └── logs/                                 # Execution logs
│
├── pom.xml                                   # Maven Project Object Model file
│                                              # Dependencies, plugins, build config
│
├── .gitignore                                # Ignore target/, logs, reports
│
└── README.md                                 # Project documentation/setup guide
Install: apache-maven-3.9.11-bin
	Environment Variables -> System variables -> New:
	Variable Name:		MAVEN_HOME
	Variable Value:		C:\Users\shiva\Maven\bin
	System variables -> Path -> Edit -> New: %MAVEN_HOME%\bin
	
	Check Maven version: 	mvn -version
	Compile the project: 	mvn compile
	mvn clean install -U:	Cleans project, Compiles code, Downloads missing plugins, Runs tests
	Clean the project (delete target folder): 	mvn clean
	Package the project (create JAR/WAR): 	mvn package
	Install project to local repository:	mvn install
	Run tests: 		mvn test
	Clean and build together: 	mvn clean install

Create Maven Project: mvn archetype:generate -DgroupId=com.example.app -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Run the Project
	Compile and run:
		mvn clean compile
		mvn exec:java -Dexec.mainClass="com.example.app.App"
______________________________________________________________________________________
== Appium:
Install:
1.	Download Node.js - https://nodejs.org/en
2.	Download Android Studio
Environment Variables ->
	ANDROID_HOME[Hidden folder]: C:\Users\shiva\AppData\Local\Android\Sdk
	add in path: %ANDROID_HOME%\platform-tools, %ANDROID_HOME%\emulator, %ANDROID_HOME%\cmdline-tools\latest\bin, %ANDROID_HOME%\tools\bin
Verify the Installation: C:\Users\shiva>node -v [v25.9.0]
Verify the Installation: C:\Users\shiva>npm -v [11.12.1]
Install Appium: C:\Users\shiva>npm install -g appium
Install the UiAutomator2 Driver: appium driver install uiautomator2
your-appium-project/
├── pom.xml                 // Your Maven manifest. This downloads the Appium Java Client, TestNG, and any reporting tools.
├── testng.xml              // Your test execution suite. You can define parameters here to run tests on different devices (Android vs. iOS).
│
├── src/main/java/          // Core framework code and Page Objects
│   ├── base/               
│   │   └── BaseTest.java   // The most critical file. It sets up the Appium Server connection, defines "Desired Capabilities" (device info), and initializes the AndroidDriver/IOSDriver.
│   │
│   ├── pages/              
│   │   └── LoginPage.java  // Page Object Model classes. This contains mobile locators (e.g., @AndroidFindBy) and methods to interact with the screen.
│   │
│   └── utils/              
│       └── TestUtils.java  // Helper methods for things like scrolling, swiping, or reading configuration files.
│
├── src/test/java/          // Your actual test scripts
│   └── tests/              
│       └── LoginTest.java  // Test files containing TestNG @Test annotations. They extend BaseTest and call methods from the pages directory.
│
└── src/test/resources/     // Static test data and apps
    ├── apps/               
    │   └── my-app.apk      // The actual application file you are testing (.apk for Android, .app or .ipa for iOS).
    └── config.properties   // A file to store externalized data like deviceName, platformVersion, and Appium server URL so you don't hardcode them.
	
                          abd.exe devices for Command line
                          DesiredCapabilities dc = new DesiredCapabilities();                            Open Appium and Coonect
                          dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, ""Appium"");            For Verify : abd.exe devices
                          dc.setCapability(MobileCapabilityType.PLATEFORM_NAME, ""Android"");            then use Eclipse
                          dc.setCapability(MobileCapabilityType.PLATEFORM_VERSION, ""5.1"");
                          dc.setCapability(MobileCapabilityType.DEVICE_NAME, ""Android"");
                          dc.setCapability(MobileCapabilityType.APP, ""F\\Google Drive\\Trainning Material\\Appium\\APK Files\\IndiaMART.apk"");
Steps to Run:		1. Enter path for platform-tools where adb.exe placed - C:\Users\Shivam Parashar\platform-tools				
					2. Run cmd: adb devices
					List of devices attached
					R5CNC186BEE     device
					3. Run cmd: appium

Extract App .apk File from Mobile device:
To Extract .apk file already installed:
	Step1: To list all package - 
		adb shell pm list packages[Window]
		adb shell pm list packages | grep facebook[Mac]
	Extract only app pakage:
		adb shell pm list packages | findstr facebook
		adb shell pm list packages | findstr supervpn
Initial Package: adb shell pm list packages --user 0 | findstr facebook
To confirm Main app: adb shell cmd package resolve-activity --brief com.facebook.katana
	Resultconsole: priority=0 preferredOrder=0 match=0x108000 specificIndex=-1 isDefault=false com.facebook.katana/.LoginActivity
		options.setAppPackage("com.facebook.katana");
		options.setAppActivity("com.facebook.katana.LoginActivity");
Step2: Execute cmd to see base.apk - adb shell pm path com.android.chrome
Step3: Select only base.apk file from cmd - adb pull /data/app/~~c1VVlQ8lERYnsC2FzjANeQ==/com.facebook.katana-U57f3XcS0LU86s7B6ea7zg==/base.apk
Step4: Appium does not support base.ap so convert it to base.apk via cmd: ren base.ap base.apk
	base.apk store in Folder 'platform-tools' : C:\Users\Shivam Parashar\platform-tools
	______________________________________________________________________________________
To satrt server - 			appium
For app web version - 		appium --allow-cors
To clean aommand prompt - 	cls
______________________________________________________________________________________
== Jenkins

Jenkins - Web
1. Navigate to: cd C:\Users\shiva\OneDrive\Jenkins
2. Execute: java -jar jenkins.war
3. Navigate to: http://localhost:8080/login?from=%2F
4. Enter Secrets-Key: 6fa5fc0d50824f98877f13056bd0f36a

JDK 17[JAVA_HOME: C:\Program Files\Java\jdk-17] issue: "C:\Program Files\Java\jdk-17\bin\java.exe" -jar jenkins.war
	
Jenkins - Manually Start
Jenkins.war path: 	cd C:\Users\Shivam Parashar\OneDrive\Jenkins\
					cd C:\Users\Shivam Parashar\Jenkins
To Start Jenkins: 	java -jar jenkins.war
Pstgre Password : Password 
______________________________________________________________________________________
== Git:																								.git/
project-folder/																						 │
│																									├── HEAD                   # Points to current branch
├── .git/                       # Hidden folder created by Git										├── HEAD                   # Points to current branch
│   │                           # Stores commit history, branches, config							├── config                 # Local Git repository config
│																									├── hooks/                 # Git hooks (pre-commit, pre-push etc.)
├── src/                        # Main source code folder											├── objects/               # Stores commits, blobs, trees
│   ├── main/                   # Main application/framework code									├── refs/
│   ├── test/                   # Test scripts / automation code									│   ├── heads/             # Local branches
│																									│   ├── remotes/           # Remote tracking branches
├── docs/                       # Project documentation												│   └── tags/              # Tags/releases
│   ├── API.md                  # API documentation
│   ├── SETUP.md                # Installation/setup guide
│   └── CONTRIBUTING.md         # Contribution guidelines
│
├── config/                     # Configuration files
│   ├── dev.config              # Development environment config
│   ├── qa.config               # QA environment config
│   └── prod.config             # Production config
│
├── scripts/                    # Utility scripts
│   ├── build.sh                # Build script
│   ├── deploy.sh               # Deployment script
│   └── run-tests.sh            # Execute tests
│
├── reports/                    # Test/build reports
│   ├── html-report/            # HTML reports
│   └── logs/                   # Execution logs
│
├── .gitignore                  # Ignore files/folders from commit
│                               # Example: node_modules/, target/, logs/
│
├── .gitattributes              # Defines line endings / merge strategy
│
├── README.md                   # Project overview/documentation
│
├── LICENSE                     # License information
│
└── Jenkinsfile / .github/ / .gitlab-ci.yml # CI/CD pipeline definitions
	
Workflow (Add → Commit → Push)															
	Install cmd: winget install --id Git.Git -e --source winget									
	Git version: git --version																	
	SetName: C:\Users\shiva>	git config --global user.name "Shivam Parashar"						
	SetEmail: C:\Users\shiva>	git config --global user.email "shivamparashar1213@gmail.com"																	
																								
	cd onedriver -> cd javaselenium -> cd ProjectName											
	Check if .git exists: dir /a  /  dir														
	if .git not exist then run command in cmd: git init											
	warnings: test-output/, *.html, *.xml, *.js														
	in Project Update .gitignore: test-output/														
								  *.html															
								  *.xml																
								  *.js																
																									
	Remove this warning: git config --global core.autocrlf true																							
																									
1. Re-initialize a fresh Git repository: git init
(Pro-Tip for the future: If you ever want to use robocopy but ignore the .git folder, you can add the Exclude Directory flag like this: robocopy "source" "dest" /E /XD .git)
Delete the folder from GitHub AND your local computer:						Scenario B: Delete from GitHub, but KEEP it on your local computer
Remove the folder and its contents: git rm -r name_of_folder				1. Remove the folder from Git's tracking (but leave it on your hard drive): git rm -r --cached name_of_folder
2. Commit the deletion: git commit -m "Deleted name_of_folder"				(The --cached flag tells Git to stop tracking the folder, removing it from the remote repository, but it physically leaves the files on your PC).
3. Push the changes to GitHub: git push origin master						2. Commit the change: git commit -m "Stop tracking name_of_folder"
																			3. Push the changes to GitHub: git push origin master
1. Stage all your copied files: git add .									Important Next Step for Scenario B: If you used the --cached method, the folder is still on your computer. The very next time you run git add ., Git will try to upload it to GitHub all over again!
To prevent this, you must open your .gitignore file and type the name of the folder on a new line (e.g., test-output/). This tells Git to permanently ignore that folder in the future.
2. Create your initial commit: git commit -m "Initial commit for ApplyJob_May8"
3. Create the GitHub repo and push everything (using the GitHub CLI we discussed earlier): gh repo create ApplyJob_May8 --public --source=. --remote=origin --push
(Note: You can change --public to --private if you don't want anyone else to see this code.)
	
New repo for multiple projects in single repo via cmd window on github?
1.	Set Up the Monorepo Locally ->
# 1. Create the main "master" folder for your repo
mkdir my-monorepo
# 2. Navigate into that folder
cd my-monorepo
# 3. Initialize it as a Git repository
git init
# 4. Create separate folders for your different projects
mkdir project-1, mkdir project-2, mkdir project-3
2. Add Files and Commit
Before you push to GitHub, you need to tell Git to track these folders. (Git won't track completely empty folders, so it's a good practice to create a quick file, like a README.md, in the root directory).
# Create a simple README file in the main folder
echo "# My Monorepo" > README.md
# Stage all folders and files
git add .
# Commit them to the local repository
git commit -m "Initial commit with multiple projects"
3. Push the Entire Repo to GitHub ->
gh repo create my-monorepo --public --source=. --remote=origin --push

How to make them different local folder and github repo
•	Git and GitHub don't actually care what the folder is named on your personal computer. Git only cares about the hidden .git tracking folder inside that directory and the remote URL it is connected to on GitHub.
•	You could name your local folder my-messy-code-folder on your laptop, but push it to a pristine, professional GitHub repository named Company-Monorepo.
# You are currently inside C:\Users\You\my-stuff
# You can create a GitHub repo named "awesome-monorepo"
gh repo create awesome-monorepo --public --source=. --remote=origin --push
If you run git clone [https://github.com/YourName/awesome-monorepo](https://github.com/YourName/awesome-monorepo), Git will automatically create a new local folder called awesome-monorepo, not my-stuff.

=========================================================================================================
== Cypress:
project-folder/
│
├── cypress/
│   │
│   ├── e2e/                          # Contains all test/spec files
│   │   ├── login/
│   │   │   └── login.cy.js           # Login-related test cases
│   │   ├── dashboard/
│   │   │   └── dashboard.cy.js       # Dashboard-related test cases
│   │   └── checkout/
│   │       └── checkout.cy.js        # Checkout/payment-related test cases
│   │
│   ├── fixtures/                     # Stores static test data / mock data
│   │   ├── users.json                # User credentials or profile data
│   │   ├── products.json             # Product-related test data
│   │   └── apiResponse.json          # Mock API responses
│   │
│   ├── support/                      # Reusable code / common utilities
│   │   │
│   │   ├── commands/                 # Custom Cypress commands
│   │   │   ├── loginCommands.js      # Reusable login commands
│   │   │   ├── apiCommands.js        # API request helper commands
│   │   │   └── uiCommands.js         # Common UI actions
│   │   │
│   │   ├── pageObjects/              # Page Object Model files
│   │   │   ├── LoginPage.js          # Locators & methods for Login page
│   │   │   ├── DashboardPage.js      # Dashboard page methods
│   │   │   └── CheckoutPage.js       # Checkout page methods
│   │   │
│   │   ├── utils/                    # Helper functions / reusable methods
│   │   │   ├── constants.js          # Common constants / URLs
│   │   │   ├── helpers.js            # Generic helper functions
│   │   │   └── testDataGenerator.js  # Dynamic/random test data creation
│   │   │
│   │   ├── e2e.js                    # Runs before every spec file
│   │   │                             # Import commands and global hooks here
│   │   │
│   │   └── component.js              # Used for component testing setup
│   │
│   ├── downloads/                    # Downloaded files during test execution
│   ├── screenshots/                  # Auto screenshots for failed tests
│   └── videos/                       # Video recording of test execution
│
├── cypress.config.js                 # Cypress configuration file
│                                     # Base URL, timeouts, env variables etc.
│
├── package.json                      # Project dependencies & npm scripts
│
├── node_modules/                     # Installed npm packages
│
├── reports/                          # Stores generated test reports
│   ├── mochawesome-report/           # Mochawesome HTML reports
│   └── junit/                        # JUnit XML reports for Jenkins
│
├── .gitignore                        # Ignore node_modules, reports, videos etc.
│
└── README.md                         # Project documentation / setup guide
	Command to Check Version: npx cypress --version
	Command to Update: npm install -D cypress@latest
______________________________________________________________________________________
Cypress Setup														Playwright
	To Install: npm install cypress --save-dev						To Install: npm init playwright@latest -> Y -> tests -> Enter -> Enter
																	Update Playwright (Optional but recommended): npm install -D @playwright/test@latest
	To Open Cypress: npx cypress open								Install the browsers manually via Command Line (Recommended): mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
=========================================================================================================
== Playwright:																			my-hybrid-framework/  [Java + Selenium + Playwright + Maven]   
project-folder/																				├── pom.xml
│																							└── src/
├── tests/                              # Contains all test/spec files							├── main/
│   ├── login/																					│   └── java/
│   │   └── login.spec.ts               # Login-related test cases								│       └── com/framework/
│   ├── dashboard/																				│           ├── core/
│   │   └── dashboard.spec.ts           # Dashboard-related test cases							│           │   ├── SeleniumDriverManager.java  # Initializes WebDriver
│   └── checkout/																				│           │   └── PlaywrightManager.java      # Initializes Playwright Page
│       └── checkout.spec.ts            # Checkout/payment-related test cases					│           └── utils/
│																								│               └── ConfigReader.java           # Reads properties files
├── pages/                              # Page Object Model (POM) files							└── test/
│   ├── LoginPage.ts                    # Locators & methods for Login page							└── java/
│   ├── DashboardPage.ts                # Dashboard page methods										└── com/framework/	
│   └── CheckoutPage.ts                 # Checkout page methods												├── pages/
│																											│   ├── selenium/
├── fixtures/                           # Static test data / mock data										│   │   └── LoginPageA.java         # Selenium WebElements		
│   ├── users.json                      # User credentials or profile data									│   └── playwright/
│   ├── products.json                   # Product-related test data											│       └── LoginPageB.java         # Playwright Locators
│   └── apiResponse.json                # Mock API responses												└── tests/
│																												├── BaseTest.java               # Setup/Teardown for both
├── utils/                              # Reusable helper functions												└── HybridLoginTest.java        # Actual test execution
│   ├── constants.ts                    # Common constants / URLs
│   ├── helpers.ts                      # Generic helper functions
│   └── testDataGenerator.ts            # Dynamic/random test data creation
│
├── hooks/                              # Global hooks / reusable setup-teardown
│   ├── globalSetup.ts                  # Runs once before all tests
│   ├── globalTeardown.ts               # Runs once after all tests
│   └── testHooks.ts                    # beforeEach / afterEach reusable hooks
│
├── playwright-report/                  # HTML execution reports (auto-generated)
│
├── test-results/                       # Screenshots, videos, traces on failures
│
├── .env                                # Environment variables
│
├── playwright.config.ts                # Playwright configuration
│                                        # Base URL, browsers, retries, reporter etc.
│
├── package.json                        # Project dependencies & npm scripts
│
├── node_modules/                       # Installed npm packages
│
├── reports/                            # Stores generated custom reports
│   ├── html-report/                    # Custom HTML reports
│   └── junit/                          # JUnit XML for CI/CD integration
│
├── .gitignore                          # Ignore node_modules, reports etc.
│
└── README.md                           # Project documentation / setup guide
	
	Command to Check Version: npx playwright --version
	Command to Update(Package): npm install -D @playwright/test@latest
	Command to Update(Browsers): npx playwright install
	Playwright's interactive UI mode: npx playwright test --ui
	
	Make Directory: mkdir playwright-demo
	Change Directory: cd playwright-demo
	Initialize Playwright: npm init playwright@latest
	Initialize (Bypass Bypass): npm.cmd init playwright@latest
	Execute Tests: npx playwright test
	View Results: npx playwright show-report
=========================================================================================================
== Cucumber:
project-folder/
│
├── features/                               # Contains all feature files (BDD scenarios)
│   ├── login/
│   │   └── login.feature                   # Login scenarios in Given/When/Then format
│   ├── dashboard/
│   │   └── dashboard.feature               # Dashboard-related scenarios
│   └── checkout/
│       └── checkout.feature                # Checkout/payment scenarios
│
├── step-definitions/                       # Step definition files
│   ├── loginSteps.js                       # Maps feature steps to automation code
│   ├── dashboardSteps.js                   # Dashboard step definitions
│   └── checkoutSteps.js                    # Checkout step definitions
│
├── pages/                                  # Page Object Model (POM) files
│   ├── LoginPage.js                        # Locators & methods for Login page
│   ├── DashboardPage.js                    # Dashboard page methods
│   └── CheckoutPage.js                     # Checkout page methods
│
├── hooks/                                  # Hooks for setup/teardown
│   ├── hooks.js                            # Before, After, BeforeStep, AfterStep
│   ├── globalSetup.js                      # Runs before all features
│   └── globalTeardown.js                   # Runs after all features
│
├── fixtures/                               # Static test data / mock data
│   ├── users.json                          # User credentials or profile data
│   ├── products.json                       # Product-related test data
│   └── apiResponse.json                    # Mock API responses
│
├── utils/                                  # Helper methods / reusable utilities
│   ├── constants.js                        # Common constants / URLs
│   ├── helpers.js                          # Generic helper functions
│   └── testDataGenerator.js                # Dynamic/random test data
│
├── reports/                                # Test execution reports
│   ├── html-report/                        # HTML report
│   ├── json-report/                        # JSON report
│   └── junit/                              # XML report for CI/CD
│
├── screenshots/                            # Failure screenshots
├── videos/                                 # Test execution videos (if supported)
│
├── cucumber.js / cucumber.json             # Cucumber configuration
│                                            # Paths, tags, formatters etc.
│
├── package.json                            # Project dependencies & npm scripts
│
├── node_modules/                           # Installed npm packages
│
├── .env                                    # Environment variables
│
├── .gitignore                              # Ignore reports/node_modules/screenshots
│
└── README.md                               # Project documentation
______________________________________________________________________________________
== mysql --version
mysqld --console
mysql -u root -p
MYSQL password : Password@1213
clear cmd - system cls
C:\Program Files\MySQL\MySQL Server 8.0\bin
C:\ProgramData\MySQL\MySQL Server 8.0

mysqld --defaults-file="C:\\ProgramData\MySQL\MySQL Server 8.0\\my.ini" --init-file=c:\\mysql-init.txt --console

Common:
Location file : 	cd bqurious
File Run : 			java -jar startBqClient.jar 

Location -> Devices -> Billing Contract -> Create Bill
Bill > Bill Item 

agar kabhi ye error aye to follow these steps :
i- Launch chrome://flags/#allow-insecure-localhost on Chrome
ii- Look for the option "Allow invalid certificates for resources loaded from localhost." and enable the option.
iii- Relaunch Chrome
iv- Access BQ Platform and try Recording/Local Execution.
