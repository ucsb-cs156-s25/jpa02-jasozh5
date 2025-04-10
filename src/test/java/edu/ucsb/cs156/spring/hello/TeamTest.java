package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }


    @Test
    public void equalsn() {
        Team test = new Team();
        assert(test.equals(test));
        assert(!test.equals(1));

        Team test2 = new Team();
        assert(test.equals(test));
        
        test2.addMember("t");
        assert(!test.equals(test2));

        test.addMember("t");
        assert(test.equals(test2));

        test2.setName("test2");
        assert(!test.equals(test2));
    }

    @Test
    public void hashCode_tests() {
        Team test1 = new Team();
        test1.addMember("t1");
        test1.addMember("t2");

        Team test2 = new Team();
        test2.addMember("t1");
        test2.addMember("t2");

        assertEquals(test1.hashCode(), test2.hashCode());

        int result = test1.hashCode();
        int expectedResult = 117602;
        assertEquals(expectedResult, result);   


    }
}
