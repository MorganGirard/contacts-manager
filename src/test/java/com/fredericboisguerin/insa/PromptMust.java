package com.fredericboisguerin.insa;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PromptMust {
    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

    }

    @Test
    public void fail_if_email_without_arobase() throws Exception {
        String input = "add\nbenoit\nbenoitmailsansarobase\n0123456789\nquit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Prompt p = new Prompt();
        p.mainLoop();

        String expectedOutput = "Email du contact invalide";
        assertThat(standardOutput(), containsString(expectedOutput));
    }

    @Test
    public void does_show_print_added_contact() throws Exception {
        String input = "add\nbenoit\n@\n0123456789\nshow\nbenoit\nquit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Prompt p = new Prompt();
        p.mainLoop();

        String expectedOutput = "benoit, @, 0123456789";
        assertThat(standardOutput(), containsString(expectedOutput));
    }

    @Test
    public void does_show_all_print_added_contacts() throws Exception {
        String input = "add\nbenoit\n@\n0123456789\nshowAll\nquit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Prompt p = new Prompt();
        p.mainLoop();

        String expectedOutput = "benoit, @, 0123456789";
        assertThat(standardOutput(), containsString(expectedOutput));
    }

    private String standardOutput() {
        return out.toString();
    }
}
