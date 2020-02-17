/*
 * MIPSUnit::MUnit is a JUnit-based unit testing framework for MIPS assembly created by
 * and freely distributed by Zachary Kurmas.  More information can be found at:
 * http://www.cis.gvsu.edu/~kurmasz/Software/mipsunit_munit/
 */
 
import org.junit.*;
import static org.junit.Assert.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;
import edu.gvsu.mipsunit.munit.MUnit;;

public class Lab03Part4Test {

    @Test(timeout=1000)  // 400
    public void verify_intarray_memory_contents() {
        run("ece260_main");
        int[] intarray_expected = {0, 1, 3, 5, 7, 11, 13, 17, 19, 23};
        int[] intarray_actual = getWords("intarray", 0, 10);
        assertArrayEquals("\n\tContents of \"intarray\" are incorrect", intarray_expected, intarray_actual);
    }

    @Test(timeout=1000)  // 401
    public void verify_empty_memory_contents() {
        run("ece260_main");
        byte[] empty_expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] empty_actual = getBytes("empty", 0, 10);
        assertArrayEquals("\n\tContents of \"empty\" are incorrect", empty_expected, empty_actual);
    }

    @Test(timeout=1000)  // 402
    public void verify_hello_memory_contents() {  
        run("ece260_main");
        String hello_expected = "Hello World!\0";
        String hello_actual = getString("hello", 0, 13);
        assertEquals("\n\tContents of \"hello\" are incorrect", hello_expected, hello_actual);
    }

    @Test(timeout=1000)  // 403
    public void verify_goodbye_memory_contents() {
        run("ece260_main");
        String goodbye_expected = "Goodbye\0";
        String goodbye_actual = getString("goodbye", 0, 8);
        assertEquals("\n\tContents of \"goodbye\" are incorrect", goodbye_expected, goodbye_actual);
    }

    @Test(timeout=1000)  // 404
    public void verify_other_memory_contents() {   
        run("ece260_main");
        getWords("intarray", 0, 10);
        getBytes("empty", 0, 10);
        getString("hello", 0, 13);
        getString("goodbye", 0, 8);
        assertTrue("\n\tYou have written to memory locations that you should not have modified", noOtherMemoryModifications());
    }

    @Test(timeout=1000)  // 405
    public void verify_t0_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $t0 should contain the address of \"intarray\" -- ", 0x10010000, get(t0));
    }

    @Test(timeout=1000)  // 406
    public void verify_t1_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $t1 should contain the address of \"empty\" -- ", 0x10010028, get(t1));
    }

    @Test(timeout=1000)  // 407
    public void verify_t2_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $t2 should contain the address of \"hello\" -- ", 0x10010032, get(t2));
    }

    @Test(timeout=1000)  // 408
    public void verify_t3_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $t3 should contain the address of \"goodbye\" -- ", 0x1001003F, get(t3));
    }

    @Test(timeout=1000)  // 409
    public void verify_other_reg_contents() {
        run("ece260_main");
        assertEquals("\n\tRegister $s0 should not have been modified and should contain 0 -- ", 0, get(s0));
        assertEquals("\n\tRegister $s0 should not have been modified and should contain 0 -- ", 0, get(s1));
        assertEquals("\n\tRegister $s2 should not have been modified and should contain 0 -- ", 0, get(s2));
        assertEquals("\n\tRegister $s3 should not have been modified and should contain 0 -- ", 0, get(s3));
        assertEquals("\n\tRegister $s4 should not have been modified and should contain 0 -- ", 0, get(s4));
        assertEquals("\n\tRegister $s5 should not have been modified and should contain 0 -- ", 0, get(s5));
        assertEquals("\n\tRegister $s6 should not have been modified and should contain 0 -- ", 0, get(s6));
        assertEquals("\n\tRegister $s7 should not have been modified and should contain 0 -- ", 0, get(s7));
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
