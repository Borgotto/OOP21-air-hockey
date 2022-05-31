package tests;

import logics.AchievementImpl;
import logics.GameState;

import static org.junit.Assert.*;

class AchievementTest {

    @org.junit.Test
	public void testAchievement() {
		var gamestate = new GameState();
        var achievement = new AchievementImpl("", "Champion", "Score 5 goals in one game", (game) -> game.getMainPlayer().getScore() >= 5);
        var achievement2 = new AchievementImpl("", "PogChamp", "score 15 goals in one game", (game) -> game.getMainPlayer().getScore() >= 15);
        
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
