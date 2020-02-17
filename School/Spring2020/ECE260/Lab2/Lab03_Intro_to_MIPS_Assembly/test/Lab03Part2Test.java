/*
 * MIPSUnit::MUnit is a JUnit-based unit testing framework for MIPS assembly created by
 * and freely distributed by Zachary Kurmas.  More information can be found at:
 * http://www.cis.gvsu.edu/~kurmasz/Software/mipsunit_munit/
 */
 
import org.junit.*;
import static org.junit.Assert.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

public class Lab03Part2Test {

    @Test(timeout=1000)  // 200
    public void verify_s1_contents() {
        run("ece260_main");
        assertEquals("\n\tResult of -100 should be stored in register $s1 -- ", -100, get(s1));
    }

    @Test(timeout=1000)  // 201
    public void verify_other_reg_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $s0 should not have been modified and should contain 0 -- ", 0, get(s0));
        assertEquals("\n\tRegister $s2 should not have been modified and should contain 0 -- ", 0, get(s2));
        assertEquals("\n\tRegister $s3 should not have been modified and should contain 0 -- ", 0, get(s3));
        assertEquals("\n\tRegister $s4 should not have been modified and should contain 0 -- ", 0, get(s4));
        assertEquals("\n\tRegister $s5 should not have been modified and should contain 0 -- ", 0, get(s5));
        assertEquals("\n\tRegister $s6 should not have been modified and should contain 0 -- ", 0, get(s6));
        assertEquals("\n\tRegister $s7 should not have been modified and should contain 0 -- ", 0, get(s7));
        assertEquals("\n\tRegister $t0 should not have been modified and should contain 0 -- ", 0, get(t0));
        assertEquals("\n\tRegister $t1 should not have been modified and should contain 0 -- ", 0, get(t1));
        assertEquals("\n\tRegister $t2 should not have been modified and should contain 0 -- ", 0, get(t2));
        assertEquals("\n\tRegister $t3 should not have been modified and should contain 0 -- ", 0, get(t3));
        assertEquals("\n\tRegister $t4 should not have been modified and should contain 0 -- ", 0, get(t4));
        assertEquals("\n\tRegister $t5 should not have been modified and should contain 0 -- ", 0, get(t5));
        assertEquals("\n\tRegister $t6 should not have been modified and should contain 0 -- ", 0, get(t6));
        assertEquals("\n\tRegister $t7 should not have been modified and should contain 0 -- ", 0, get(t7));
        assertEquals("\n\tRegister $t8 should not have been modified and should contain 0 -- ", 0, get(t8));
        assertEquals("\n\tRegister $t9 should not have been modified and should contain 0 -- ", 0, get(t9));
        assertEquals("\n\tRegister $a0 should not have been modified and should contain 0 -- ", 0, get(a0));
        assertEquals("\n\tRegister $a1 should not have been modified and should contain 0 -- ", 0, get(a1));
        assertEquals("\n\tRegister $a2 should not have been modified and should contain 0 -- ", 0, get(a2));
        assertEquals("\n\tRegister $a3 should not have been modified and should contain 0 -- ", 0, get(a3));
        assertEquals("\n\tRegister $v0 should not have been modified and should contain 0 -- ", 0, get(v0));
        assertEquals("\n\tRegister $v1 should not have been modified and should contain 0 -- ", 0, get(v1));
    }
}
