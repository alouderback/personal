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

public class Lab03Part5Test {

    /* Check to make sure that the memory contents are correct before the 
     * assembly instructions are actually run
     */
    @Test(timeout=1000)  // 500
    public void verify_nums_initial_memory_contents() {
        run("end");
        int[] nums_expected = {1, 3, 5, 7, 9};
        int[] nums_actual = getWords("nums", 0, 5);
        int flag_expected = 0xDEADBEEF;
        int flag_actual = getWord("flag", 0);
        assertArrayEquals("\n\tInitial contents of \"nums\" are incorrect", nums_expected, nums_actual);
        assertEquals("\n\tInitial contents of \"flag\" are incorrect", flag_expected, flag_actual);
    }

    /* Check to make sure that the program didn't overwrite the nums memory.
     * The nums memory should be unchanged after the program runs.
     */
    @Test(timeout=1000)  // 501
    public void verify_nums_final_memory_contents() {
        run("ece260_main");
        int[] nums_expected = {1, 3, 5, 7, 9};
        int[] nums_actual = getWords("nums", 0, 5);
        int flag_expected = 0xDEADBEEF;
        int flag_actual = getWord("flag", 0);
        assertArrayEquals("\n\tFinal contents of \"nums\" are incorrect", nums_expected, nums_actual);
        assertEquals("\n\tFinal contents of \"flag\" are incorrect", flag_expected, flag_actual);
    }

    /* Check the contents of the output array to verify that the required computation
     * was done correctly and the results were written to the appropriate locations
     */
    @Test(timeout=1000)  // 502
    public void verify_array_memory_contents() {
        run("ece260_main");
        int[] array_expected = {4, 7, 11, 15, 19};
        int[] array_actual = getWords("array", 0, 5);
        assertArrayEquals("\n\tContents of \"array\" are incorrect", array_expected, array_actual);
    }

    /* Check to make sure that no other memory locations have been modified 
     * by the assembly
     */
    @Test(timeout=1000)  // 503
    public void verify_other_memory_contents() {
        run("ece260_main");
        getWords("nums", 0, 5);  // just access these to update MUnit framework, 
        getWords("array", 0, 5); // don't actually need the return value
        assertTrue("\n\tYou have written to memory locations that you should not have modified", noOtherMemoryModifications());
    }
}
