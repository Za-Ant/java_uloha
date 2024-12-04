import java.util.PriorityQueue;
import java.util.Comparator;

abstract class HockeyPlayer {
    private String name;
    private int age;

    public HockeyPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getPlayerDetails();
}

class Forward extends HockeyPlayer {
    private int goals;

    public Forward(String name, int age, int goals) {
        super(name, age);
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    @Override
    public String getPlayerDetails() {
        return "Forward: " + getName() + ", Age: " + getAge() + ", Goals: " + goals;
    }
}

class Defender extends HockeyPlayer {
    private int hits;

    public Defender(String name, int age, int hits) {
        super(name, age);
        this.hits = hits;
    }

    public int getHits() {
        return hits;
    }

    @Override
    public String getPlayerDetails() {
        return "Defender: " + getName() + ", Age: " + getAge() + ", Hits: " + hits;
    }
}

class Goalie extends HockeyPlayer {
    private int wins;

    public Goalie(String name, int age, int wins) {
        super(name, age);
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    @Override
    public String getPlayerDetails() {
        return "Goalie: " + getName() + ", Age: " + getAge() + ", Wins: " + wins;
    }
}
public class HockeyManager {
    private PriorityQueue<HockeyPlayer> playersQueue;

    public HockeyManager() {
        playersQueue = new PriorityQueue<>(Comparator.comparingInt(HockeyPlayer::getAge));
    }

    public void AddNewForward(String name, int age, int goals) {
        playersQueue.add(new Forward(name, age, goals));
    }

    public void AddNewDefender(String name, int age, int hits) {
        playersQueue.add(new Defender(name, age, hits));
    }

    public void AddNewGoalie(String name, int age, int wins) {
        playersQueue.add(new Goalie(name, age, wins));
    }

    public void PrintNameAndAgeOfTheYoungestPlayer() {
        if (!playersQueue.isEmpty()) {
            HockeyPlayer youngest = playersQueue.peek();
            System.out.println("Youngest Player: " + youngest.getName() + ", Age: " + youngest.getAge());
        } else {
            System.out.println("No players available.");
        }
    }

    public void PrintAllPlayers() {
        for (HockeyPlayer player : playersQueue) {
            System.out.println(player.getPlayerDetails());
        }
    }
}
public class Main { 
    public static void main(String[] args) { 
        HockeyManager manager = new HockeyManager(); 
        System.out.println("All Players:");
        manager.PrintAllPlayers();
    } 
}

