import java.util.Arrays;

public class Player implements Comparable<Player> // A player can be compared with other players, something needs to be
                                                  // added here!!
{
    private String name; // name of the player
    private int[] matchScores; // Array to keep track of scores for individual matches
    private int matchesPlayed; // To keep track of the number of matches played, initially 0

    public Player(String name, int maxMatches) {
        this.name = name;
        this.matchesPlayed = 0;
        this.matchScores = new int[maxMatches];
    }

    public String getName() {
        return this.name;
    }

    // Get the number of matches played
    public int getMatchesPlayed() {
        return this.matchesPlayed;
    }

    // Add score for a match
    public void addMatchScore(int score) {
        this.matchScores[this.matchesPlayed] = score;
        this.matchesPlayed++;
    }

    public int getMatchScore(int matchNum) // matchNum is 0-indexed
    {
        return this.matchScores[matchNum];
    }

    // Get the total score across all matches
    public int getTotalScore() {
        int totalScore = 0;
        for (int i : matchScores) {
            totalScore += i;
        }
        return totalScore;
    }

    // Get the average score for a player
    public double getAverageScore() {
        return ((double) this.getTotalScore() / (double) this.matchesPlayed);
    }

    // Compare based on total score, return 1, -1 and 0 if score of the current
    // player is greater than, less than or equal respectively
    // Check that both object are the instances of the same type, if not return -2
    @Override
    public int compareTo(Player other) {
        if (this.getClass().getSimpleName() != other.getClass().getSimpleName()) {
            return -2;
        }
        return (int) Math.signum(this.getTotalScore() - other.getTotalScore());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", matchScores=" + Arrays.toString(Arrays.copyOf(matchScores, matchesPlayed)) +
                ", matchesPlayed=" + matchesPlayed +
                '}';
    }
}