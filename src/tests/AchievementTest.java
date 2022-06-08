package tests;

import logics.AchievementImpl;
import logics.GameStateBuilder;

import static org.junit.Assert.*;

public class AchievementTest {

    @org.junit.Test
	public void testAchievement() {
		var gameState = new GameStateBuilder().build();
        var achievement = new AchievementImpl("Champion", "Score 5 goals in one game", (game) -> game.getMainPlayer().getScore() >= 5);
        var achievement2 = new AchievementImpl("PogChamp", "score 15 goals in one game", (game) -> game.getMainPlayer().getScore() >= 15);
        
        System.out.println("initial score: "+gameState.getMainPlayer().getScore());
        
        for(int i=0;i<10;i++) {
        	System.out.println("\n\nscored!");
        	gameState.getMainPlayer().scorePoint();
        	System.out.println("score: "+gameState.getMainPlayer().getScore());
        }
        assertTrue(achievement.isUnlocked(gameState));
        assertFalse(achievement2.isUnlocked(gameState));
	}

}
