package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private Team testTeam;

    @BeforeEach
    void setUp() {
        testTeam = new Team("Winx");
    }

    @Test
    void testTeamInitialization() {
        Assertions.assertEquals(10, testTeam.getMembers().size());
        Assertions.assertEquals("Winx", testTeam.getName());

        testTeam.getMembers().forEach(member -> {
            Assertions.assertTrue(member instanceof General || member instanceof Captain || member instanceof Soldier,
                    "acceptable only: General, Captain or Soldier");
        });
    }

    @Test
    void hasAliveMembersWhenAllAliveTest() {
        Assertions.assertTrue(testTeam.hasAliveMembers());
    }

    @Test
    void hasAliveMembersWhenAllDeadTest() {
        testTeam.getMembers().forEach(warrior -> warrior.takeDamage(Integer.MAX_VALUE));
        Assertions.assertFalse(testTeam.hasAliveMembers(),
                "If all members of team is dead, then method 'hasAliveMembers' should return false");
    }

    @Test
    void getAliveMemberWhenAllAliveTest() {
        Assertions.assertNotNull(testTeam.getAliveMember(),
                "Method 'getAliveMember' should return alive member of the team");
    }

    @Test
    void getAliveMemberWhenAllDead() {
        testTeam.getMembers().forEach(warrior -> warrior.takeDamage(Integer.MAX_VALUE));
        Assertions.assertNull(testTeam.getAliveMember(),
                "Method 'getAliveMember' should return null, if all team members are dead");
    }
}
