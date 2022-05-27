package tests;

import logics.AchievementImpl;
import logics.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AchievementTest {

	@Test
	void testAchievement() {
		var gamestate = new GameState();
        var achievement = new AchievementImpl(null, "Champion", "Score 5 goals in one game", (game) -> game.getMainPlayer().getScore() >= 5);
        var achievement2 = new AchievementImpl(null, "PogChamp", "score 15 goals in one game", (game) -> game.getMainPlayer().getScore() >= 15);
        
        System.out.println("initial score: "+gamestate.getMainPlayer().getScore());
        
        for(int i=0;i<10;i++) {
        	System.out.println("\n\nscored!");
        	gamestate.getMainPlayer().scorePoint();
        	System.out.println("score: "+gamestate.getMainPlayer().getScore());
        }
        assertTrue(achievement.isUnlocked(gamestate));
        assertFalse(achievement2.isUnlocked(gamestate));
	}

}
