import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    //Class Variables
    Scanner in = new Scanner(System.in);    
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Team> teams = new ArrayList<Team>();

    System.out.println("How many teams do you want to create?");
    int numberOfTeams = Integer.parseInt(in.nextLine());



    //Do while loop that asks the user to create a team and the players
    int n = 0;
    do
    {
      System.out.println("\nTeam " + (n + 1) + ":\n");

      //For loop to create 5 players for the team
      for(int j = 0; j < 5; j++)
      {
        System.out.println((j + 1) + ")");

        System.out.println("What is the name of the player? ");
        String name = in.nextLine();
        
        System.out.println("What is the age of the player? ");
        int age = Integer.parseInt(in.nextLine());

        System.out.println("What is the position of the player? (Top, Mid, Bot, Jungle, Support) ");
        String position = in.nextLine();
  
        System.out.println("");

        players.add(new Player(name, age, position));
      }

      //Create the team
      System.out.println("What is the name of the team?");
      String teamName = in.nextLine();
      System.out.println("What is the acronym of the team?");
      String acronym = in.nextLine();
      teams.add(new Team(teamName, acronym, players.get(0), players.get(1), players.get(2), players.get(3), players.get(4)));

      players.clear();
      System.out.println("========================================================================");
      n++;
    }
    while(numberOfTeams > n);
    


    //Prints all teams and their best and worst Players
    for(int k = 0; k < teams.size(); k++)
    {
      System.out.println(teams.get(k));
      System.out.println(teams.get(k).maxAndMinPlayer());
      teams.get(k).teamCheck();
      System.out.println(" ");
    }   



    System.out.println("========================================================================");


    //Prints all players abilities and then sorted.
    ArrayList<Integer> allAbilities = new ArrayList<Integer>();
    for(int i = 0; i < teams.size(); i++)
    {
      for(int j = 1; j < 6; j++)
      {
        allAbilities.add(teams.get(i).getPlayer(j).getAbility());
      }
    }


    System.out.println("List of abilities from all players:");
    for(int ability : allAbilities)
    {
      System.out.print(ability + " ");
    }


    System.out.println("\n\nList of abilities from all players, but sorted:");
    InsertionSort sorting = new InsertionSort(allAbilities);
    ArrayList<Integer> sortedAbilities = sorting.sort();

    for(int ability : sortedAbilities)
    {
      System.out.print(ability + " ");
    }



    System.out.println("\n========================================================================");


    //Showcasing many of the Player methods
    Player player = teams.get(0).getPlayer(1);
    System.out.println("Initial player stats\n" + player);

    player.setPosition("Mid");
    System.out.println("The player changed positions\n" + player);

    player.trainingTime(40);
    System.out.println(player);

    player.birthday();
    System.out.println("It's the player's birthday!\n" + player);



    System.out.println("========================================================================");
  }
}