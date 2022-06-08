package logics;

import java.util.ArrayList;
import java.util.List;

public class AchievementLogicsFactoryImpl implements AchievementLogicsFactory {


    public AchievementLogics baseAchievements() {
        AchievementLogicsImpl achievementLogics = new AchievementLogicsImpl();
        ArrayList<Achievement> list = new ArrayList<>();
		
		list.add(new AchievementImpl("A piece of cake","Scored 5 goals in dumb mode", (g) -> g.getMainPlayer().getScore() >= 5));
				//&& g.getEnemyPlayer().getDifficulty() == Difficulty.DUMB));
		list.add(new AchievementImpl("5 o'clock","Scored 5 goals in easy mode", (g) -> g.getMainPlayer().getScore() >= 5)); 
				//&& g.getEnemyPlayer().getDifficulty() == Difficulty.EASY));
		list.add(new AchievementImpl("You got some skills","Scored 5 goals in normal mode", (g) -> g.getMainPlayer().getScore() >= 5));
				//&& g.getEnemyPlayer().getDifficulty() == Difficulty.NORMAL));
		list.add(new AchievementImpl("Eyes of heaven", "Scored 20 goals in normal mode", (g) -> g.getMainPlayer().getScore() >= 20));
				//&& g.getEnemyPlayer().getDifficulty() == Difficulty.NORMAL));
		achievementLogics.addAchievements(list);
        return achievementLogics;
    }

    public AchievementLogics fromList(List<Achievement> achievements) {
        AchievementLogicsImpl achievementLogics = new AchievementLogicsImpl();
        achievementLogics.addAchievements(achievements);
        return achievementLogics;
    }
}

