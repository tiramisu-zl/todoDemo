package org.tw.todo;

import com.sun.tools.javac.comp.Todo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LearnTest {


    @Test
    public void learn() {
        List<Integer> intArray = new ArrayList<Integer>();
        intArray.add(Integer.valueOf(123));
        intArray.add(Integer.valueOf(234));
        intArray.add(Integer.valueOf(345));
        assertThat(intArray.size(), is(3));
    }

    @Test
    public void shouldPrint(){



    }





}
