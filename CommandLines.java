CMD
cd /d d:  	for change drive
cd\  		start from c drive
cd.. 		one folder back
dir  		To know file and folder name avilable in current directory
cls  		To clear Command Prompt
C:			To go back to C drive
	
change location or set path for apps ex. git: cd C:\Users\shiva\OneDrive\JavaSelenium
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
For	                 Commands	                                     Work
	        	    driverquery	                                    Lists All Installed Drivers	
	            	powershell start cmd -v runAs 	                Run the Command Prompt as an Administrator	cd\  start from c drive
	                chdir or cd	                                    Changes the Current Working Directory to the Specified Directory	cd /d d:  for change drive
	                systeminfo	                                    Shows Your PC's Details	cd.. one folder back
______________________________________________________________________________________
Java	
	                        For Run Java Program
  Compile Program                   C:\Users\Your Name>javac Main.java
  Run Java Program                  C:\Users\Your Name>java Main
                          Hello World

Environment Variables -> System variables -> New:
Variable Name:		JAVA_HOME
Variable Value:		C:\Program Files\Java\jdk-17
System variables -> Path -> Edit -> New: %JAVA_HOME%\bin
______________________________________________________________________________________
Maven Commands
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
Appium
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
Commands - Jenkins

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
To satrt server - 			appium
For app web version - 		appium --allow-cors
To clean aommand prompt - 	cls
______________________________________________________________________________________
Git:
project-folder/
│
├── .git/                                 # Hidden folder created by Git
│   │                                     # Stores commit history, branches, config
│
├── src/                                  # Main source code folder
│   ├── main/                             # Main application/framework code
│   ├── test/                             # Test scripts / automation code
│
├── docs/                                 # Project documentation
│   ├── API.md                            # API documentation
│   ├── SETUP.md                          # Installation/setup guide
│   └── CONTRIBUTING.md                   # Contribution guidelines
│
├── config/                               # Configuration files
│   ├── dev.config                        # Development environment config
│   ├── qa.config                         # QA environment config
│   └── prod.config                       # Production config
│
├── scripts/                              # Utility scripts
│   ├── build.sh                          # Build script
│   ├── deploy.sh                         # Deployment script
│   └── run-tests.sh                      # Execute tests
│
├── reports/                              # Test/build reports
│   ├── html-report/                      # HTML reports
│   └── logs/                             # Execution logs
│
├── .gitignore                            # Ignore files/folders from commit
│                                          # Example: node_modules/, target/, logs/
│
├── .gitattributes                        # Defines line endings / merge strategy
│
├── README.md                             # Project overview/documentation
│
├── LICENSE                               # License information
│
└── Jenkinsfile / .github/ / .gitlab-ci.yml # CI/CD pipeline definitions

.git/
│
├── HEAD                                  # Points to current branch
├── config                                # Local Git repository config
├── hooks/                                # Git hooks (pre-commit, pre-push etc.)
├── objects/                              # Stores commits, blobs, trees
├── refs/
│   ├── heads/                            # Local branches
│   ├── remotes/                          # Remote tracking branches
│   └── tags/                             # Tags/releases
	
Workflow (Add → Commit → Push)															
	Install cmd: winget install --id Git.Git -e --source winget									
	Git version: git --version																	
	SetName: C:\Users\shiva>	git config --global user.name "Shivam Parashar"						
	SetEmail: C:\Users\shiva>	git config --global user.email "shivamparashar1213@gmail.com"	
	one folder back[Git]: cd ..																	
																								
	cd onedriver -> cd javaselenium -> cd ProjectName											
	Check if .git exists: dir /a  /  dir														
	if .git not exist then run command in cmd: git init												
																									
	warnings: test-output/, *.html, *.xml, *.js														
	in Project Update .gitignore: test-output/														
								  *.html															
								  *.xml																
								  *.js																
																									
	Remove this warning: git config --global core.autocrlf true																							
																									
1️⃣ Initialize Git (first time only)
git init
2️⃣ Add files to staging
git add .
👉 Adds all files (your Selenium project)
OR specific file:
git add ChatBot.java
3️⃣ Commit changes
git commit -m "Added chatbot automation logic"
👉 This saves snapshot locally
4️⃣ Connect to GitHub repo (one-time setup)
git remote add origin https://github.com/username/repo-name.git

5️⃣ Push code to GitHub *****************
Project Location: cd /d D:\Git_Project\NaukriJob_Apr22
# This forces your local branch to be renamed to 'main'
git branch -M main
# This pushes the code and links your local 'main' to GitHub's 'main'
git push -u origin main
********* Flow:
# 1. Navigate into your new, clean folder
cd /d D:\Git_Project\Naukri_Auto_Final
# 2. Turn this clean folder into a fresh Git repository
git init
# 3. Add your pasted files
git add .
# 4. Create your first commit
git commit -m "Initial commit: Naukri automation project"
# 5. Set the branch to main
git branch -M main
# 6. Link it to the CORRECT GitHub repository
git remote add origin https://github.com/ShivamPandit1213/NaukriJob_Apr22.git
# 7. Push the code!
git push -u origin main
--------------------------------------
	Step 1: Update the remote URL: git remote set-url origin https://github.com/ShivamPandit1213/NaukriJob_Apr22.git
	Step 2: Verify the change (Optional but recommended): git remote -v
	Step 3: Push your code: git push -u origin main
============================================================================================================================================
🔄 Pull (Get Latest Code from GitHub) *****************
git pull origin main
👉 Use this before starting work to avoid conflicts
********** Flow																						Repeat cmd:	
1. Go to your main workspace folder: cd D:\Git_Project												cd D:\Git_Project
2. Clone the correct repository: git clone https://github.com/ShivamPandit1213/NaukriTest.git		fatal: destination path 'NaukriTest' already exists and is not an empty directory.
3. Move inside the new project folder: cd NaukriTest												cd NaukriTest

1. Go into your existing folder: cd D:\path\to\your\existing\folder
2. Sever the tie to the false repo and link the correct one: git remote set-url origin https://github.com/ShivamPandit1213/NaukriTest.git
3. Verify the fix: git remote -v
4. Pull the correct code down: git pull origin master
	
🔁 Daily Workflow (Very Important):
git add .
git commit -m "Updated chatbot logic"
git pull origin main
git push origin main
______________________________________________________________________________________
mysql --version
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
=========================================================================================================
Cypress:
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
______________________________________________________________________________________
Cypress Setup														Playwright
	To Install: npm install cypress --save-dev						To Install: npm init playwright@latest -> Y -> tests -> Enter -> Enter
	To Open Cypress: npx cypress open
=========================================================================================================
Playwright:
project-folder/
│
├── tests/                              # Contains all test/spec files
│   ├── login/
│   │   └── login.spec.ts               # Login-related test cases
│   ├── dashboard/
│   │   └── dashboard.spec.ts           # Dashboard-related test cases
│   └── checkout/
│       └── checkout.spec.ts            # Checkout/payment-related test cases
│
├── pages/                              # Page Object Model (POM) files
│   ├── LoginPage.ts                    # Locators & methods for Login page
│   ├── DashboardPage.ts                # Dashboard page methods
│   └── CheckoutPage.ts                 # Checkout page methods
│
├── fixtures/                           # Static test data / mock data
│   ├── users.json                      # User credentials or profile data
│   ├── products.json                   # Product-related test data
│   └── apiResponse.json                # Mock API responses
│
├── utils/                              # Reusable helper functions
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
=========================================================================================================
Cucumber:
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
