package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Jason Z.", Developer.getName());
    }


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test 
    public void getGithubId_returns_correct_githubId() {

        assertEquals("jasozh5", Developer.getGithubId());

    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-09", t.getName());
        assertTrue(t.getMembers().contains("Jason Z."));
        assertTrue(t.getMembers().contains("Andrew K."));
        assertTrue(t.getMembers().contains("Fred Z."));
        assertTrue(t.getMembers().contains("Joel S."));
        assertTrue(t.getMembers().contains("Moiez B."));
        assertTrue(t.getMembers().contains("Ruben A."));

    }

}
