#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
#
# @author Dr. Fenwick
# @version Fall 2021
#

HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
#CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_COMMAND =  -jar checkstyle-9.0-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "5 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ defchk, stylechk - default or custom checkstyle"
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make stylechk"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

compile: $(JUNIT5_JAR)
	cd src ; javac -cp .:../$(JUNIT5_JAR) *.java

clean:
	rm -f *~
	rm -f *.class
	rm -f javatrix/*.class
	rm -f javatrix/*~
	rm -f javatrixtest/*.class

test: $(JUNIT5_JAR)
	cd src ; java -cp .:../$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

defchk: Matrix.java $(CKSTYLE_XML)
#	checkstyle Matrix.java
	cd javatrix ; java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) Matrix.java

stylechk: javatrix/Matrix.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml javatrix/Matrix.java

style.xml:
	@echo "Custom checkstyle needs a local style.xml file."
	@echo "Copy cs_appstate_checks.xml into style.xml and edit as needed."
	@echo "--------------------------------------------------------------"
