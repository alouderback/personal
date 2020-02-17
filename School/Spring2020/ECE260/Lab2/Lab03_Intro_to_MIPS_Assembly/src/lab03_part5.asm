# 
# Anything after a # is a comment
# Use comments to describe what each line of code does
#

.globl ece260_main end nums array flag	# make these labels accessible from other files for testing

####################################################################################

.data
	# insert your data values here (arrays, strings, variables, etc.)
	# indent your data values just as this comment is indented
	nums: .word 1 3 5 7 9
	array: .space 20
	flag: .word 0xDEADBEEF
	
####################################################################################

.text
ece260_main:
	# insert your instructions here
	# indent your instructions just as this comment is indented
	# stylistically, this indentation will make more sense later
	la $s0, nums
	la $s1, array
	
	addi $s3, $zero, 3
	lw $s4, ($s0)
	add $s3, $s3, $s4
	addi $s3, $s3, 0
	sw $s3, array
	
	addi $s3, $zero, 3
	lw $s5, ($s0)
	lw $s4, 4($s0)
	add $s3, $s3, $s5
	add $s3, $s3, $s4
	sw $s3, array+4
	
	addi $s3, $zero, 3
	lw $s5, 4($s0)
	lw $s4, 8($s0)
	add $s3, $s3, $s5
	add $s3, $s3, $s4
	sw $s3, array+8

	addi $s3, $zero, 3
	lw $s5, 8($s0)
	lw $s4, 12($s0)
	add $s3, $s3, $s5
	add $s3, $s3, $s4
	sw $s3, array+12
	
	addi $s3, $zero, 3
	lw $s5, 12($s0)
	lw $s4, 16($s0)
	add $s3, $s3, $s5
	add $s3, $s3, $s4
	sw $s3, array+16
	
####################################################################################
end:	# don't put any code after this label, and DO NOT DELETE THIS LABEL
####################################################################################
