package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


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
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    @Test
    public void testEqualsSameObject() {
        Team t1 = new Team();
        t1.setName("teamA");
        t1.addMember("member1");

        assert(t1.equals(t1))== true; 
    }

    // Test case for the condition: if (!(obj instanceof Team)) { return false; }
    @Test
    public void testEqualsDifferentClass() {
        Team t1 = new Team();
        t1.setName("teamA");
        t1.addMember("member1");

       
        assert(t1.equals("some string"))==false; 
    }

    // Test case for the condition where two objects are instances of Team but their fields are different
    @Test
    public void testEqualsDifferentFields() {
        Team t1 = new Team();
        t1.setName("teamA");
        t1.addMember("member1");

        Team t2 = new Team();
        t2.setName("teamB"); 
        t2.addMember("member1");

        assert(t1.equals(t2))==false; 
    }

    // Test case where the name fields are the same but members are different
    @Test
    public void testEqualsSameNameDifferentMembers() {
        Team t1 = new Team();
        t1.setName("teamA");
        t1.addMember("member1");

        Team t2 = new Team();
        t2.setName("teamA"); 
        t2.addMember("member2"); 

        
        assert(t1.equals(t2))==false; 
    }

    // Test case where both name and members are the same
    @Test
    public void testEqualsSameFields() {
        Team t1 = new Team();
        t1.setName("teamA");
        t1.addMember("member1");

        Team t2 = new Team();
        t2.setName("teamA"); 
        t2.addMember("member1"); 

        
        assert(t1.equals(t2))==true; 
    }
    


    @Test
    public void testHashCode() {
        // Test case 1: Same objects (equal names and members)
        Team t1 = new Team();
        t1.setName("teamA");
        ArrayList<String> members1 = new ArrayList<>();
        members1.add("member1");
        t1.setMembers(members1);

        Team t2 = new Team();
        t2.setName("teamA");
        ArrayList<String> members2 = new ArrayList<>();
        members2.add("member1");
        t2.setMembers(members2);

        // Assert hash codes are equal for the same content
        assertEquals(t1.hashCode(), t2.hashCode());

        // Test case 2: Different names, same members
        t2.setName("teamB"); // Changing name in t2
        assertNotEquals(t1.hashCode(), t2.hashCode());

        // Test case 3: Same name, different members
        t2.setName("teamA");
        ArrayList<String> difMembers = new ArrayList<>();
        difMembers.add("member2");
        t2.setMembers(difMembers); 
        assertNotEquals(t1.hashCode(), t2.hashCode());

        // Test case 4: Different names and members
        t2.setName("teamB");
        t2.setMembers(difMembers);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
}

