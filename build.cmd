@echo off

rem   Compile the application code [*not* the test code]
rem   Here, any third-party library JARs are located in lib and added to the classpath [-classpath option]
rem   Remove this -classpath "lib\*" if you're not using any.
javac -d classes src\com\mastermind\*.java src\com\mastermind\client\*.java

rem   Build the application JAR
rem   This command adds the directory tree of .class files starting at 'classes', and also the entire 'data' directory.
rem   The 'data' directory is included in the JAR because the application reads from files in there
jar --create --file mastermind.jar -C classes rem . data

rem   Create the Javadoc
rem   The '-package' flag will include non-public classes and all class members except for private ones.
rem   Again, any third-party library JARs are located in lib and added to the classpath
rem   And again, remove this -classpath "lib\*" if you're not using any.
javadoc -d doc --source-path src -package -windowtitle Mastermind com.mastermind com.mastermind.client