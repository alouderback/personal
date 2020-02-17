#
# Makefile for a ECE260 lab or programming assignment.
# Do NOT modify this file!!!
#

COURSE_NAME = ECE 260 
SEMESTER = Spring $(shell date +%Y)
PROJECT_NUMBER = lab03

UUT1 = lab03_part1
UUT2 = lab03_part2
UUT3 = lab03_part3
UUT4 = lab03_part4
UUT5 = lab03_part5
UNIT_TEST_NAME1 = Lab03Part1Test
UNIT_TEST_NAME2 = Lab03Part2Test
UNIT_TEST_NAME3 = Lab03Part3Test
UNIT_TEST_NAME4 = Lab03Part4Test
UNIT_TEST_NAME5 = Lab03Part5Test

#######################################################
#######################################################

ASM_DIR = ./src
ASM_SRC1 = $(ASM_DIR)/$(UUT1).asm
ASM_SRC2 = $(ASM_DIR)/$(UUT2).asm
ASM_SRC3 = $(ASM_DIR)/$(UUT3).asm
ASM_SRC4 = $(ASM_DIR)/$(UUT4).asm
ASM_SRC5 = $(ASM_DIR)/$(UUT5).asm

TESTING_DIR = ./test
MUNIT = $(TESTING_DIR)/munit.jar
UNIT_TEST_SRC1 = $(TESTING_DIR)/$(UNIT_TEST_NAME1).java
UNIT_TEST_SRC2 = $(TESTING_DIR)/$(UNIT_TEST_NAME2).java
UNIT_TEST_SRC3 = $(TESTING_DIR)/$(UNIT_TEST_NAME3).java
UNIT_TEST_SRC4 = $(TESTING_DIR)/$(UNIT_TEST_NAME4).java
UNIT_TEST_SRC5 = $(TESTING_DIR)/$(UNIT_TEST_NAME5).java
UNIT_TEST_CLASS1 = $(TESTING_DIR)/$(UNIT_TEST_NAME1).class
UNIT_TEST_CLASS2 = $(TESTING_DIR)/$(UNIT_TEST_NAME2).class
UNIT_TEST_CLASS3 = $(TESTING_DIR)/$(UNIT_TEST_NAME3).class
UNIT_TEST_CLASS4 = $(TESTING_DIR)/$(UNIT_TEST_NAME4).class
UNIT_TEST_CLASS5 = $(TESTING_DIR)/$(UNIT_TEST_NAME5).class


########################################################################
# Do a little extra work to make this Makefile compatible with
# MacOS, Linux, and Cygwin running on Windows.
# The findJava script works properly for both old and newer versions of Java
########################################################################
detected_OS = $(shell uname -s)
ifeq ($(detected_OS),Darwin)
	JAVAC = javac
	JAVA = java
endif
ifeq ($(detected_OS),Linux)
	JAVAC = javac
	JAVA = java
endif
ifeq ($(findstring CYGWIN,$(detected_OS)),CYGWIN)
	JAVAHOME = $(shell cygpath -au "`./util/findJava.bat`")
	JAVAC = "$(JAVAHOME)/bin/javac"
	JAVA = "$(JAVAHOME)/bin/java"
endif

JFLAGS = -cp $(MUNIT)
RUNFLAGS = -Djava.awt.headless=true -Djava.util.logging.config.file="./util/logging.properties" -jar $(MUNIT)
########################################################################

all:
	@echo "Run one of the following tests:"
	@echo "  make test_part1"
	@echo "  make test_part2"
	@echo "  make test_part3"
	@echo "  make test_part4"
	@echo "  make test_part5"
	@echo "  -- OR -- "
	@echo "  test everything with:"
	@echo "  make test_all"

test_all: test_part1 test_part2 test_part3 test_part4 test_part5


$(UNIT_TEST_CLASS1): $(UNIT_TEST_SRC1)
	$(JAVAC) $(JFLAGS) $(UNIT_TEST_SRC1)
$(UNIT_TEST_CLASS2): $(UNIT_TEST_SRC2)
	$(JAVAC) $(JFLAGS) $(UNIT_TEST_SRC2)
$(UNIT_TEST_CLASS3): $(UNIT_TEST_SRC3)
	$(JAVAC) $(JFLAGS) $(UNIT_TEST_SRC3)
$(UNIT_TEST_CLASS4): $(UNIT_TEST_SRC4)
	$(JAVAC) $(JFLAGS) $(UNIT_TEST_SRC4)
$(UNIT_TEST_CLASS5): $(UNIT_TEST_SRC5)
	$(JAVAC) $(JFLAGS) $(UNIT_TEST_SRC5)

test_part1: $(UNIT_TEST_CLASS1)
	-$(JAVA) $(RUNFLAGS) $(ASM_SRC1) $(UNIT_TEST_CLASS1)
	@echo "Test of part1 is done"
	@echo ""
	@echo "==========================="
	@echo ""
test_part2: $(UNIT_TEST_CLASS2)
	-$(JAVA) $(RUNFLAGS) $(ASM_SRC2) $(UNIT_TEST_CLASS2)
	@echo "Test of part2 is done"
	@echo ""
	@echo "==========================="
	@echo ""
test_part3: $(UNIT_TEST_CLASS3)
	-$(JAVA) $(RUNFLAGS) $(ASM_SRC3) $(UNIT_TEST_CLASS3)
	@echo "Test of part3 is done"
	@echo ""
	@echo "==========================="
	@echo ""
test_part4: $(UNIT_TEST_CLASS4)
	-$(JAVA) $(RUNFLAGS) $(ASM_SRC4) $(UNIT_TEST_CLASS4)
	@echo "Test of part4 is done"
	@echo ""
	@echo "==========================="
	@echo ""
test_part5: $(UNIT_TEST_CLASS5)
	-$(JAVA) $(RUNFLAGS) $(ASM_SRC5) $(UNIT_TEST_CLASS5)
	@echo "Test of part5 is done"
	@echo ""
	@echo "==========================="
	@echo ""

clean:
	rm -f $(TESTING_DIR)/*.class
	
distclean: clean clean_submit

#######################################################
# The following is for submission to Marmoset
#######################################################

SUBMIT_URL = https://cs.ycp.edu/marmoset/bluej/SubmitProjectViaBlueJSubmitter


submit: submit.properties solution.zip
	perl submitToMarmoset.pl solution.zip submit.properties

solution.zip: collected-files.txt
	@echo "Creating a solution zip file"
	@zip -9 $@ `cat collected-files.txt`
	@rm -f collected-files.txt

# Create the submit.properties file that describes how
# the project should be uploaded to the Marmoset server.
submit.properties: nonexistent
	@echo "Creating submit.properties file"
	@rm -f $@
	@echo "submitURL = $(SUBMIT_URL)" >> $@
	@echo "courseName = $(COURSE_NAME)" >> $@
	@echo "semester = $(SEMESTER)" >> $@
	@echo "projectNumber = $(PROJECT_NUMBER)" >> $@

# Collect the names of all files that don't appear
# to be generated files.
collected-files.txt: nonexistent
	@echo "Collecting the names of files to be submitted"
	@rm -f $@
	@find . -not \( \
		-name '*\.exe' \
		-or -name '*~' \
		-or -name '~*' \
		-or -name '*\.swp' \
		-or -name '*\.sdf' \
		-or -name '*\.suo' \
		-or -name 'collected-files.txt' \
		-or -name 'submit.properties' \
		-or -name 'submitToMarmoset.pl' \
		-or -name 'Makefile' \
		-or -type d \
		-path '*test' -prune \
		-or -type d \
		-path '*util' -prune \
	\) -print \
	| perl -ne 's,\./,,; print' \
	> $@

# This is just a dummy target to force other targets
# to always be out of date.
nonexistent:

# Remove generated files.
clean_submit: 
	rm -rf collected-files.txt submit.properties solution.zip

