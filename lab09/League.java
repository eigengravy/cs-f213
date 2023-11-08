import java.util.Arrays;
import java.util.Random;

//generic League class can contain teams of any type, as long as those teams are subclasses of Team that are parameterized by any type of Player or its subclasses. 
public class League<T extends Team<? extends Player>> {
    private T[] teams;
    private T[] winners; // Array to record the winner of each match
    private int teamCount; // Initially 0
    private int matchCount; // Counter for the number of matches played

    @SuppressWarnings("unchecked")
    public League(int leagueSize, int totalMatch) // leagueSize is the max number of teams possible in the league
    {
        this.teams = (T[]) new Team[leagueSize];
        this.winners = (T[]) new Team[totalMatch];
        this.teamCount = 0;
        this.matchCount = 0;
    }

    public void addTeam(T team) {
        this.teams[this.teamCount] = team;
        this.teamCount++;
    }

    public T[] getTeams() {
        return this.teams;
    }

    public T[] getWinners() // Return only the part of the array that has been used
    {
        return this.winners;
    }

    // use this to assign random scores to each player of a team. For a football
    // player max score can be 3 and for a cricket player it can be 150
    // Return the total score of the team after assigning the random scores
    private static int assignRandomScoresToTeam(Team<? extends Player> team) {
        Random rand = new Random();
        int totalScore = 0;
        for (Player player : team.getMembers()) {
            if (player.getClass().getSimpleName() == "FootballPlayer") {
                int matchScore = rand.nextInt(4);
                totalScore += matchScore;
                player.addMatchScore(matchScore);
            } else if (player.getClass().getSimpleName() == "CricketPlayer") {
                int matchScore = rand.nextInt(150);
                totalScore += matchScore;
                player.addMatchScore(rand.nextInt(matchScore));
            }
        }
        return totalScore;
    }

    // team with same number of wins will have the same rank. Ranks needs to be
    // adjusted for non-tied teams.
    // for example wins of Team1 = 2, wins of Team2 = 2 and wins Of Team3 = 1, Ranks
    // will be Team1 = 1, Team2 = 1, and Team3 = 3
    private void updateRankings() // Updates the ranks of all teams based on the current wins
    {
        Arrays.sort(teams);
        for (int i = 0; i < teams.length; i++) {
            if (i > 0 && teams[i - 1].getWins() == teams[i].getWins()) {
                teams[i].setRanking(teams[i - 1].getRanking());
            } else {
                teams[i].setRanking(i + 1);
            }
        }
    }

    // use assignRandomScoresToTeam to assign scores to each team, team with the
    // higher score wins. In case of a tie, nobody wins. Record the match for each
    // team
    public void playMatch(T team1, T team2) {
        int totalScore1 = League.assignRandomScoresToTeam(team1);
        int totalScore2 = League.assignRandomScoresToTeam(team2);
        team1.recordMatch(totalScore1 > totalScore2);
        team2.recordMatch(totalScore1 < totalScore2);
        if (totalScore1 > totalScore2) {
            this.winners[this.matchCount] = team1;
        } else if (totalScore1 < totalScore2) {
            this.winners[this.matchCount] = team2;
        }
        this.matchCount += 1;
        this.updateRankings();
    }

    public void showStandings() // Only print out teams that have been added
    {
        for (T t : teams) {
            System.out.println(t.getName() + " Ranking: " + t.getRanking() + " Wins: " + t.getWins());
        }
    }

}
