package tests;

import logics.Achievement;
import logics.AchievementImpl;
import logics.AchievementLogics;
import logics.AchievementLogicsFactory;
import logics.AchievementLogicsFactoryImpl;
import logics.Difficulty;
import logics.EnemyPlayerImpl;
import logics.GameState;
import logics.GameStateBuilder;
import java.util.List;

import org.jbox2d.common.Vec2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AchievementTest {

    @org.junit.Test
	public void testAchievement() {
		var gameState = new GameStateBuilder().build();
        var achievement = new AchievementImpl("Champion", "Score 5 goals in one game", (game) -> game.getMainPlayer().getScore() >= 5);
        var achievement2 = new AchievementImpl("Amazing skills", "score 15 goals in one game", (game) -> game.getMainPlayer().getScore() >= 15);
                
        for(int i=0;i<10;i++) {
        	gameState.getMainPlayer().scorePoint();
        }
        assertTrue(achievement.isUnlocked(gameState));
        assertFalse(achievement2.isUnlocked(gameState));
	}
    
    @org.junit.Test
    public void testAchievementFactory() {
    	AchievementLogicsFactory achievementFactory = new AchievementLogicsFactoryImpl();
    	AchievementLogics achievementLogics = achievementFactory.baseAchievements();
    	List<Achievement> achievements = achievementLogics.getAchievements();
    	achievements.removeIf(a -> a.getDescription().contains("theme"));
    	var gameState = new GameStateBuilder().build();
    	assertFalse(achievements.stream().allMatch(a -> a.isUnlocked(gameState)));
    	
    	var gameState1 = new GameStateBuilder()
    			.setEnemyPlayer(new EnemyPlayerImpl(1.4f, new Vec2(9.0f,28.0f), GameState.gamePhysics, Difficulty.DUMB))
    			.setMaxScore(5)
    			.build();
    	gameState1.getEnemyPlayer().setScore(gameState1.getMaxScore());
    	gameState1.update();
    	assertTrue(achievements.stream().anyMatch(a -> a.isUnlocked(gameState1)));
    }
}
