run_all.bat
// Run file all types - java / JavaScript / TypeScript
// don't want the window to close at all, replace the word "pause" with "cmd /k" in your script: cmd /k

@echo off
rem Change terminal encoding to UTF-8 to fix the emoji text
chcp 65001 > nul

echo 🚀 --- Running Java ---
java App.java

echo.
echo 🚀 --- Running JavaScript ---
node script.js

echo.
echo 🚀 --- Running TypeScript ---
rem Added CALL so the script doesn't exit after npx
call npx --yes tsx script.ts

echo.
echo ✅ All scripts executed successfully!
pause

=========================================================================
App.java
public class App {
    public static void main(String[] args) {
        System.out.println("Java is working!");
    }
}
=========================================================================
script.js
console.log("JavaScript is working!");
=========================================================================
script.ts
const message: string = "TypeScript is working!";
console.log(message);
