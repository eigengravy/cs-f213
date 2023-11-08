import java.util.Random;

public class Main {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------
        // Uncomment the following after completing the Player, CricketPlayer and FootballPlayer class
        FootballPlayer f1 = new FootballPlayer("Player 1", 10);
        CricketPlayer c1 = new CricketPlayer("Player 2", 10);
        if(f1.getName() != "Player 1" || c1.getName() != "Player 2"){
            System.out.println("getName() is not correct!");
            return;
        }

        f1.addMatchScore(2);
        f1.addMatchScore(3);
        if(f1.getMatchScore(0) != 2 || f1.getMatchScore(1) != 3){
            System.out.println("addMatchScore() or getMatchScore() is not correct!");
            return;
        }

        if(f1.getTotalScore() != 5){
            System.out.println("getTotalScore() is not correct!");
            return;
        }

        if(f1.getAverageScore() != 2.5){
            System.out.println("getAverageScore() is not correct!");
            return;
        }

        FootballPlayer f2 = new FootballPlayer("Player 3", 10);
        f2.addMatchScore(2);
        if(f1.compareTo(f2) != 1){
            System.out.println("compareTo() is not correct!");
            return;
        }
        
        System.out.println("Proceed to complete Team, CricketTeam, and FootballTeam.");
// // ---------------------------------------------------------------------------------------
//         // Uncomment the following after completing the Team, CricketTeam and FootballTeam class

//         // Create teams
        FootballTeam team1 = new FootballTeam("Team A", 5, 4);
        FootballTeam team2 = new FootballTeam("Team B", 5, 4);
        FootballTeam team3 = new FootballTeam("Team C", 5, 4);
        FootballTeam team4 = new FootballTeam("Team D", 5, 4);

        // Add players to teams (just using numbers to represent players)
        for (int i = 1; i <= 5; i++) {
            team1.addMember(new FootballPlayer("Player " + i, 10));
            team2.addMember(new FootballPlayer("Player " + (i + 5), 10));
            team3.addMember(new FootballPlayer("Player " + (i + 10), 10));
            team4.addMember(new FootballPlayer("Player " + (i + 15), 10));
        }

        if(team1.getName() != "Team A"){
            System.out.println("Constructor is not correct!");
            return;
        }

        Player[] temp = team1.getMembers();
        for(int i = 1; i <= 5; i++){
            if(temp[i-1].getName().equals("Player " + i) != true){
                System.out.println("addMember() is not correct!");
                return;
            }
        }

        if(team1.numOfMembers() != 5){
            System.out.println("addMember() is not correct!");
            return;
        }
        System.out.println("Proceed to complete League Class");
// // ---------------------------------------------------------------------------------------
//         // Uncomment the following after completing League
        League<FootballTeam> footballLeague = new League<>(4, 15);
        League<CricketTeam> cricketLeague = new League<>(4, 15);
        // Add teams to league
        footballLeague.addTeam(team1);
        footballLeague.addTeam(team2);
        footballLeague.addTeam(team3);
        footballLeague.addTeam(team4);

        CricketTeam cricketTeam1 = new CricketTeam("Cricket Team A", 11, 4);
        CricketTeam cricketTeam2 = new CricketTeam("Cricket Team B", 11, 4);
        CricketTeam cricketTeam3 = new CricketTeam("Cricket Team C", 11, 4);
        CricketTeam cricketTeam4 = new CricketTeam("Cricket Team D", 11, 4);

// Add players to cricket teams (using numbers to represent players similarly)
        for (int i = 1; i <= 11; i++) {
            cricketTeam1.addMember(new CricketPlayer("Cricket Player " + i, 10));
            cricketTeam2.addMember(new CricketPlayer("Cricket Player " + (i + 5), 10));
            cricketTeam3.addMember(new CricketPlayer("Cricket Player " + (i + 10), 10));
            cricketTeam4.addMember(new CricketPlayer("Cricket Player " + (i + 15), 10));
        }

        cricketLeague.addTeam(cricketTeam1);
        cricketLeague.addTeam(cricketTeam2);
        cricketLeague.addTeam(cricketTeam3);
        cricketLeague.addTeam(cricketTeam4);


        // Play matches
        footballLeague.playMatch(team1, team2);
        footballLeague.playMatch(team3, team4);
        footballLeague.playMatch(team1, team3);
        footballLeague.playMatch(team2, team4);
        footballLeague.playMatch(team1, team4);
        footballLeague.playMatch(team2, team3);

        // Display league standings
        System.out.println("League Standings:");
        footballLeague.showStandings();

    }
}
