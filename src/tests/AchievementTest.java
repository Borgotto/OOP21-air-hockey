package tests;

import logics.AchievementImpl;
import logics.GameStateBuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AchievementTest {

    @org.junit.Test
	public void testAchievement() {
		var gameState = new GameStateBuilder().build();
        var achievement = new AchievementImpl("Champion", "Score 5 goals in one game", (game) -> game.getMainPlayer().getScore() >= 5);
        var achievement2 = new AchievementImpl("PogChamp", "score 15 goals in one game", (game) -> game.getMainPlayer().getScore() >= 15);
                
        for(int i=0;i<10;i++) {
        	gameState.getMainPlayer().scorePoint();
        }
        assertTrue(achievement.isUnlocked(gameState));
        assertFalse(achievement2.isUnlocked(gameState));
	}
}
