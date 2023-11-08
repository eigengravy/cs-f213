public class CricketTeam extends Team<CricketPlayer>    //CricketTeam "Is-a" Team, make changes here!
{ 
    public CricketTeam(String name, int teamSize, int maxMatches) 
    {
        super(name, teamSize, maxMatches);
    }
}