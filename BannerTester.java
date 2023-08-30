import java.util.Scanner;

public class BannerTester {

    public BannerTester() {

    }

    public void setProgramRunning() {
        System.out.println("Welcome to the Genshin Wishing Simulator!");
        System.out.println("We are NOT responsible for your losses, so spend wisely you incel.");
        System.out.print("Please enter your primogems amount: ");

        while(!isNumber) {
            try {
                inputPrimoGemsAmount = Integer.parseInt(input.nextLine());
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid amount of primogems.");
            }
        }

        Summoner banner = new Summoner(inputPrimoGemsAmount);

        while (programRunning) {
            System.out.println("<---------------------------------------------->");
            System.out.println("Paimon: What would you like to do, traveller?");
            System.out.println("<---------------------------------------------->");
            System.out.println("Primogems: " + banner.getPrimoGems());
            System.out.println("You have enough for " + (banner.getPrimoGems() / 160) + " summon/s");
            System.out.println("1/ 1x Summon on the Standard Banner");
            System.out.println("2/ 10x Summon on the Standard Banner");
            System.out.println("3/ 1x Summon on Weapon Banner");
            System.out.println("4/ 10x Summon on Weapon Banner");
            System.out.println("----------------------------------------------");
            System.out.println("Character Banner Pity: " + banner.getFiveStarCharacterPity() + "/90");
            System.out.println("Character Banner Total Summons: " + banner.getTotalCharacterBannerSummons());
            System.out.println("----------------------------------------------");
            System.out.println("Weapon Banner Pity: " + banner.getFiveStarWeaponPity() + "/90");
            System.out.println("Weapon Banner Total Summons: " + banner.getTotalWeaponBannerSummons());
            System.out.println("----------------------------------------------");
            System.out.println("5/EXIT SIM");
            System.out.println("<---------------------------------------------->");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("\n");
                    banner.characterBannerSingleSummon(genshinCharacters, genshinWeapons);
                    System.out.println("\n");
                }
                case "2" -> {
                    System.out.println("\n");
                    banner.characterBannerMultiSummon(genshinCharacters, genshinWeapons);
                    System.out.println("\n");
                }
                case "3" -> {
                    System.out.println("\n");
                    banner.weaponBannerSingleSummon(genshinCharacters, genshinWeapons);
                    System.out.println("\n");
                }
                case "4" -> {
                    System.out.println("\n");
                    banner.weaponBannerMultiSummon(genshinCharacters, genshinWeapons);
                    System.out.println("\n");
                }
                case "5" -> {
                    System.out.println("Thank you for using our wishing simulator.");
                    System.out.println("We hope you the best of luck on your pulls :D");
                    programRunning = false;
                }
                default -> {
                    System.out.println("\n");
                    System.out.println("Please choose a valid option.");
                    System.out.println("\n");
                }
            }
        }
    }

    boolean programRunning = true;
    boolean isNumber = false;
    int inputPrimoGemsAmount;
    Characters genshinCharacters = new Characters();
    Weapons genshinWeapons = new Weapons();
    Scanner input = new Scanner(System.in);

}

