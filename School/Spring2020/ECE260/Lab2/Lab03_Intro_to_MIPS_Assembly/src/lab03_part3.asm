#
# Anything after a # is a comment
# Use comments to describe what each line of code does
#

.globl ece260_main		# makes the main label accessible from other files

####################################################################################

.text				# all instructions go in the .text section
ece260_main:
	# insert your instructions here
	# indent your instructions just as this comment is indented
	# stylistically, this indentation will make more sense later
	li $s1 100
	addi $s1 $s1 200