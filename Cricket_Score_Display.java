import java.util.Scanner;

class Batsman {
    String name;
    int runs, balls, ones, twos, threes, fours, sixes;
    float strikeRate;
}

class Bowler {
    String name;
    int runsGiven, wicketsTaken, overs;
    float economy;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of batsmen:");
        int m = sc.nextInt();
        Batsman[] batsmen = new Batsman[m];

        for (int i = 0; i < m; i++) {
            batsmen[i] = new Batsman();

            System.out.println("Enter name of batsman " + (i + 1) + ":");
            batsmen[i].name = sc.next();

            System.out.println("Enter the number of ones scored by batsman " + (i + 1) + ":");
            batsmen[i].ones = sc.nextInt();

            System.out.println("Enter the number of twos scored by batsman " + (i + 1) + ":");
            batsmen[i].twos = sc.nextInt();

            System.out.println("Enter the number of threes scored by batsman " + (i + 1) + ":");
            batsmen[i].threes = sc.nextInt();

            System.out.println("Enter the number of fours scored by batsman " + (i + 1) + ":");
            batsmen[i].fours = sc.nextInt();

            System.out.println("Enter the number of sixes scored by batsman " + (i + 1) + ":");
            batsmen[i].sixes = sc.nextInt();

            System.out.println("Enter the balls played by batsman " + (i + 1) + ":");
            batsmen[i].balls = sc.nextInt();
        }

        System.out.println("\nEnter the number of bowlers:");
        int n = sc.nextInt();
        Bowler[] bowlers = new Bowler[n];

        for (int i = 0; i < n; i++) {
            bowlers[i] = new Bowler();

            System.out.println("Enter name of bowler " + (i + 1) + ":");
            bowlers[i].name = sc.next();

            System.out.println("Enter the runs given by bowler " + (i + 1) + ":");
            bowlers[i].runsGiven = sc.nextInt();

            System.out.println("Enter the overs bowled by bowler " + (i + 1) + ":");
            bowlers[i].overs = sc.nextInt();

            System.out.println("Enter the wickets taken by bowler " + (i + 1) + ":");
            bowlers[i].wicketsTaken = sc.nextInt();
        }

        System.out.println("\nThank you, all details are recorded.");

        int choice;
        do {
            System.out.println("\nEnter your choice:\n1) Batsman detail\n2) Bowler detail\n3) Match summary\n4) Records\n5) Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the batsman number to see details:");
                    int batsmanNumber = sc.nextInt() - 1;

                    if (batsmanNumber >= 0 && batsmanNumber < m) {
                        Batsman b = batsmen[batsmanNumber];
                        b.runs = (1 * b.ones) + (2 * b.twos) + (3 * b.threes) + (4 * b.fours) + (6 * b.sixes);
                        b.strikeRate = (b.runs * 100.0f) / b.balls;

                        System.out.printf("\n%-15s %-10s %-10s %-10s %-10s %-10s\n",
                                "Batsman", "Runs", "Balls", "Fours", "Sixes", "Strike Rate");
                        System.out.printf("%-15s %-10d %-10d %-10d %-10d %.2f\n",
                                b.name, b.runs, b.balls, b.fours, b.sixes, b.strikeRate);
                    } else {
                        System.out.println("Invalid batsman number.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the bowler number to see details:");
                    int bowlerNumber = sc.nextInt() - 1;

                    if (bowlerNumber >= 0 && bowlerNumber < n) {
                        Bowler bowler = bowlers[bowlerNumber];
                        bowler.economy = bowler.runsGiven / (float) bowler.overs;

                        System.out.printf("\n%-15s %-10s %-10s %-10s %-10s\n",
                                "Bowler", "Overs", "Runs", "Wickets", "Economy");
                        System.out.printf("%-15s %-10d %-10d %-10d %.2f\n",
                                bowler.name, bowler.overs, bowler.runsGiven, bowler.wicketsTaken, bowler.economy);
                    } else {
                        System.out.println("Invalid bowler number.");
                    }
                    break;

                case 3:
                    System.out.println("\nMatch Summary:");

                    System.out.printf("\n%-15s %-10s %-10s %-10s %-10s %-10s\n",
                            "Batsman", "Runs", "Balls", "Fours", "Sixes", "Strike Rate");
                    int totalRuns = 0;

                    for (Batsman b : batsmen) {
                        b.runs = (1 * b.ones) + (2 * b.twos) + (3 * b.threes) + (4 * b.fours) + (6 * b.sixes);
                        totalRuns += b.runs;
                        b.strikeRate = (b.runs * 100.0f) / b.balls;

                        System.out.printf("%-15s %-10d %-10d %-10d %-10d %.2f\n",
                                b.name, b.runs, b.balls, b.fours, b.sixes, b.strikeRate);
                    }

                    System.out.println("\nTotal Runs: " + totalRuns);

                    System.out.printf("\n%-15s %-10s %-10s %-10s %-10s\n",
                            "Bowler", "Overs", "Runs", "Wickets", "Economy");

                    for (Bowler bowler : bowlers) {
                        bowler.economy = bowler.runsGiven / (float) bowler.overs;
                        System.out.printf("%-15s %-10d %-10d %-10d %.2f\n",
                                bowler.name, bowler.overs, bowler.runsGiven, bowler.wicketsTaken, bowler.economy);
                    }
                    break;

                case 4:
                    int maxRuns = 0, maxFours = 0, maxSixes = 0, maxWickets = 0;

                    for (Batsman b : batsmen) {
                        b.runs = (1 * b.ones) + (2 * b.twos) + (3 * b.threes) + (4 * b.fours) + (6 * b.sixes);
                        if (b.runs > maxRuns) maxRuns = b.runs;
                        if (b.fours > maxFours) maxFours = b.fours;
                        if (b.sixes > maxSixes) maxSixes = b.sixes;
                    }

                    for (Bowler bowler : bowlers) {
                        if (bowler.wicketsTaken > maxWickets) maxWickets = bowler.wicketsTaken;
                    }

                    System.out.println("\nRecords:");
                    System.out.println("Highest Runs: " + maxRuns);
                    System.out.println("Maximum Fours: " + maxFours);
                    System.out.println("Maximum Sixes: " + maxSixes);
                    System.out.println("Maximum Wickets: " + maxWickets);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}
