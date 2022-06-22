package logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AchievementLogicsFactoryImpl implements AchievementLogicsFactory {

    public AchievementLogics baseAchievements() {
        AchievementLogicsImpl achievementLogics = new AchievementLogicsImpl();
        ArrayList<Achievement> list = new ArrayList<>();
        Settings settings = new Settings();
		
		list.add(new AchievementImpl("A piece of cake","Score at least 5 goals in dumb mode", (g)->  (g.getMainPlayer().getScore() >= 5 
				&& g.getEnemyPlayer().getDifficulty() == Difficulty.DUMB)));
		list.add(new AchievementImpl("5 o'clock","Score at least 5 goals in easy mode", (g)->  (g.getMainPlayer().getScore() >= 5 
				&& g.getEnemyPlayer().getDifficulty() == Difficulty.EASY)));
		list.add(new AchievementImpl("Building Confidence", "Score at least 10 goals in normal mode", (g)->  (g.getMainPlayer().getScore() >= 10 
				&& g.getEnemyPlayer().getDifficulty() == Difficulty.NORMAL)));
		list.add(new AchievementImpl("AirHockey Lord","Score at least 10 goals in insane mode", (g)-> (g.getMainPlayer().getScore() >= 10 
				&& g.getEnemyPlayer().getDifficulty() == Difficulty.INSANE)));
		list.add(new AchievementImpl("The Gleam Eyes", "Win a game without enemy's goals", (g) -> (g.getWinner().equals(Optional.of(g.getMainPlayer()))
				&& g.getEnemyPlayer().getScore() == 0)));
		list.add(new AchievementImpl("Girlfriend (Seems easy, it's nearly impossible)", "The enemy player win in dumb mode", (g) -> (g.getWinner().get() == g.getEnemyPlayer()
				&& g.getEnemyPlayer().getDifficulty() == Difficulty.DUMB)));
		list.add(new AchievementImpl("Asuka Red", "The theme is set to RED", (g) -> settings.load().getTheme() == Theme.RED));
		list.add(new AchievementImpl("I'm Blue", "The theme is set to BLUE", (g) -> settings.load().getTheme() == Theme.BLUE));
		achievementLogics.addAchievements(list);
        return achievementLogics;
    }

    public AchievementLogics fromList(List<Achievement> achievements) {
        AchievementLogicsImpl achievementLogics = new AchievementLogicsImpl();
        achievementLogics.addAchievements(achievements);
        return achievementLogics;
    }
}

