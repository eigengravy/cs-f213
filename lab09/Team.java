//A generic Team class that can only be parameterized with objects that are subclasses of the Player class.
//Team instances will be compared with other Team instances that have the same type of Player.
public class Team<T extends Player> implements Comparable<Team<T>>// Make changes here!
{
    private String name; // Name of the Team
    private int wins; // Number of wins
    private int ranking; // Current ranking of the team, intially = 1
    private T[] members; // Array of team members
    private int memberCount; // Number of added members
    private boolean[] matchWins; // Tracks whether each match was won
    private int matchesPlayed; // Number of matches played

    @SuppressWarnings("unchecked")
    public Team(String name, int teamSize, int maxMatches) // teamSize is the max size a team can have
    { // maxMatches is the maximum number of matches each team can play
        this.name = name;
        this.wins = 0;
        this.ranking = 1;
        this.members = (T[]) new Player[teamSize];
        this.memberCount = 0;
        this.matchWins = new boolean[maxMatches];
        this.matchesPlayed = 0;
    }

    public void addMember(T member) {
        this.members[this.memberCount] = member;
        this.memberCount++;
    }

    public T[] getMembers() { // you can print the members as well
        return this.members;
    }

    public int numOfMembers() // Returns the current number of members
    {
        return this.memberCount;
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getMatchesPlayed() {
        return this.matchesPlayed;
    }

    public void recordMatch(boolean win) // update the relevant attributes to record the result of a match
    {
        this.matchWins[matchesPlayed] = win;
        this.matchesPlayed += 1;
        if (win) {
            this.wins += 1;
        }
    }

    public int compareTo(Team<T> other) // This will be used to rank the teams, make changes accordingly
    {
        return (int) Math.signum(other.getWins() - this.getWins() );
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", ranking=" + ranking +
                ", members=" + members.length +
                ", memberCount=" + memberCount +
                ", matchWins=" + this.getWins() +
                ", matchesPlayed=" + matchesPlayed +
                '}';
    }
}
