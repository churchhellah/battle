package org.battle.services;

import org.battle.Warrior;
import org.battle.models.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BattleTest {
    private Team firstTestTeam;
    private Team secondTestTeam;
    private Warrior infernoHero;
    private Warrior necropolisHero;
    private Battle battle;

    @BeforeEach
    void setUp() {
        firstTestTeam = mock(Team.class);
        secondTestTeam = mock(Team.class);
        infernoHero = mock(Warrior.class);
        necropolisHero = mock(Warrior.class);

        battle = new Battle(firstTestTeam, secondTestTeam);
    }

    @Test
    void testBattleWhenFirstTeamIsWin() {
        when(firstTestTeam.hasAliveMembers()).thenReturn(true, true);
        when(secondTestTeam.hasAliveMembers()).thenReturn(true, false);

        when(firstTestTeam.getAliveMember()).thenReturn(infernoHero);
        when((secondTestTeam.getAliveMember())).thenReturn((necropolisHero));

        when(infernoHero.isKilled()).thenReturn(false);
        when(necropolisHero.isKilled()).thenReturn(true);

        battle.start();

        verify(infernoHero).attack(necropolisHero);
        verify(necropolisHero, times(0)).attack(infernoHero);

        Assertions.assertFalse(secondTestTeam.hasAliveMembers());
        Assertions.assertTrue(firstTestTeam.hasAliveMembers());
    }

    @Test
    void testBattleWhenSecondTeamIsWin() {
        when(firstTestTeam.hasAliveMembers()).thenReturn(true, false);
        when(secondTestTeam.hasAliveMembers()).thenReturn(true, true);

        when(firstTestTeam.getAliveMember()).thenReturn(infernoHero);
        when((secondTestTeam.getAliveMember())).thenReturn((necropolisHero));

        when(infernoHero.isKilled()).thenReturn(true);
        when(necropolisHero.isKilled()).thenReturn(false);

        battle.start();

        verify(necropolisHero).attack(infernoHero);
        verify(infernoHero, times(0)).attack(infernoHero);

        Assertions.assertFalse(firstTestTeam.hasAliveMembers());
        Assertions.assertTrue(secondTestTeam.hasAliveMembers());
    }
}
