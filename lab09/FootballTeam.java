public class FootballTeam extends Team<FootballPlayer>  //FootballTeam "Is-a" Team, make changes here!
{ 
    public FootballTeam(String name, int teamSize, int maxMatches) 
    {
        super(name, teamSize, maxMatches);
    }
}