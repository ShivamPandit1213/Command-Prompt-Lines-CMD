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
Cypress Setup														Playwright
	To Install: npm install cypress --save-dev						To Install: npm init playwright@latest -> Y -> tests -> Enter -> Enter
	To Open Cypress: npx cypress open
	
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
	my-project
	 ├── pom.xml
	 └── src
	     ├── main
	     │   ├── java
	     │   │   └── com/example/app
	     │   │        ├── App.java
	     │   │        ├── HelloService.java
	     │   │        └── ConfigReader.java
	     │   └── resources
	     │        └── config.properties
	     └── test
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
1. Navigate to: C:\Users\shiva\OneDrive\Jenkins
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
Git	-	Workflow (Add → Commit → Push)															
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
5️⃣ Push code to GitHub
git push -u origin main
👉 Sends your code to GitHub 🚀

🔄 Pull (Get Latest Code from GitHub)
git pull origin main
👉 Use this before starting work to avoid conflicts
********** Flow															Repeat cmd:	
1. Go to your main workspace folder: cd D:\Git_Project														cd D:\Git_Project
2. Clone the correct repository: git clone https://github.com/ShivamPandit1213/NaukriTest.git			fatal: destination path 'NaukriTest' already exists and is not an empty directory.
3. Move inside the new project folder: cd NaukriTest															cd NaukriTest

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


