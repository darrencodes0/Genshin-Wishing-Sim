import java.util.Random;

public class Summoner{

    public Summoner(int primos){
        this.primoGems = primos;
    }

    public void standardBannerSummon(int summons, Characters characters, Weapons weapons){
        if(primoGems < (160 * summons)){
            System.out.println("Not enough primogems for this transaction.");
            return;
        }

        for(int i = 0; i < summons; i++) {
            int generatedNumber = rnd.nextInt(101); // includes number from 0 = 100
            primoGems -= summonCost;
            FiveStarCharacterPity++;
            FourStarCharacterPity++;

            if(FiveStarCharacterPity == 90){ // guarnteed 5* when hit 90 pity
                fiftyFiftyPity();
                System.out.println("You got a guaranteed 5* Character!");
                int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                FiveStarCharacterPity = 0;
                FourStarCharacterPity = 0;
                FiveStarCharacters++;
            } else if(FourStarCharacterPity == 10){
                int weaponOrCharacter = rnd.nextInt(2);
                if(weaponOrCharacter == 0) {
                    System.out.println("You got a guaranteed 4* Character!");
                    int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                    System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                } else{
                    System.out.println("You got a guaranteed 4* Weapon!");
                    int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                    System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                }
                FourStarCharacterPity = 0;
            } else if (generatedNumber >= 7) {  // includes numbers from 7 - 100 (94%)
                int generatedValue = rnd.nextInt(weapons.getThreeStarWeapons().size());
                System.out.println("(3*)(W) " + weapons.getThreeStarWeapons().get(generatedValue));
            } else if (generatedNumber >= 4) { // includes numbers from 4-6 (3%)
                int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                System.out.println("You got a 4* Character!");
                System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                FourStarCharacterPity = 0;
            } else if (generatedNumber >= 1) { // includes numbers from 1-3 (3%)
                System.out.println("You got a 4* Weapon!");
                int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                FourStarCharacterPity = 0;
            } else { // number 0 (1%)
                fiftyFiftyPity();
                int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                System.out.println("You got a 5* Character!");
                System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                FiveStarCharacterPity = 0;
                FiveStarCharacters++;
            }

            totalCharacterBannerSummons++;
        }

        pityReset();
    }


    public void weaponBannerSummon(int summons, Characters characters, Weapons weapons){
        if(primoGems < (160 * summons)){
            System.out.println("Not enough primogems for this transaction.");
            return;
        }

        for(int i = 0; i < summons; i++) {
            int generatedNumber = rnd.nextInt(101); // includes number from 0 = 100
            primoGems -= summonCost;
            FiveStarWeaponPity++;
            FourStarWeaponPity++;

            if(FiveStarWeaponPity == 90) { // guaranteed 5* when hit 90 pity
                seventyFivePity();
                System.out.println("You got a guaranteed 5* Weapon!");
                int generatedValue = rnd.nextInt(weapons.getFiveStarWeapons().size());
                System.out.println("(5*)(W) " + weapons.getFiveStarWeapons().get(generatedValue));
                weapons.getYourFiveStarWeapons().add(weapons.getFiveStarWeapons().get(generatedValue)); // adds the 5* weapon
                FiveStarWeaponPity = 0;
                FourStarWeaponPity = 0;
                FiveStarWeapons++;
            } else if(FourStarWeaponPity == 10){
                int weaponOrCharacter = rnd.nextInt(2);
                if(weaponOrCharacter == 0) {
                    System.out.println("You got a guaranteed 4* Character!");
                    int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                    System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                } else{
                    System.out.println("You got a guaranteed 4* Weapon!");
                    int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                    System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                }
                FourStarWeaponPity = 0;
            } else if (generatedNumber >= 7) {  // includes numbers from 7 - 100 (94%)
                int generatedValue = rnd.nextInt(weapons.getThreeStarWeapons().size());
                System.out.println("(3*)(W) " + weapons.getThreeStarWeapons().get(generatedValue));
            } else if (generatedNumber >= 4) { // includes numbers from 6-4 (3%)
                System.out.println("You got a 4* Weapon!");
                int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                FourStarWeaponPity = 0;
            } else if (generatedNumber >= 1) { // includes numbers from 1-3 (3%)
                int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                System.out.println("You got a 4* Character!");
                System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                FourStarWeaponPity = 0;
            } else { // number 0 (1%)
                seventyFivePity();
                int generatedValue = rnd.nextInt(weapons.getFiveStarWeapons().size());
                System.out.println("You got a 5* Weapon!");
                System.out.println("(5*)(W) " + weapons.getFiveStarWeapons().get(generatedValue));
                weapons.getYourFiveStarWeapons().add(weapons.getFiveStarWeapons().get(generatedValue)); // adds the 5* weapon
                FiveStarWeaponPity = 0;
                FiveStarWeapons++;
            }
            totalWeaponBannerSummons++;
        }
        pityReset();
    }



    // when pity hits 90, resets back to 0
    private void pityReset(){
        if(FiveStarCharacterPity > 90){
            FiveStarCharacterPity = 0;
        } else if(FiveStarWeaponPity > 90){
            FiveStarWeaponPity = 0;
        }
    }

    // flips a coin, 0 - win 50/50, 1 - lose 50/50
    private void fiftyFiftyPity() {
        boolean wonfiftyFifty = true;
        int fiftyFifty = rnd.nextInt(2);

        if (fiftyFifty == 0) { // Player wins 50/50
            System.out.println("You won the 50/50 pity!");
            wonfiftyFifty = true;
        } else if (fiftyFifty == 1 && !wonfiftyFifty) { // Player loses, but is guaranteed to win next time
            System.out.println("You are guaranteed to win the 50/50 pity!");
            wonfiftyFifty = true;
        } else if (fiftyFifty == 1) { // Player loses
            System.out.println("You lost the 50/50");
            wonfiftyFifty = false;
        }
    }

    // 1 - 3 (75%) , 0 (25%) pity
    private void seventyFivePity(){

        boolean wonseventyFive = true;
        int seventyFive = rnd.nextInt(4);

        if(seventyFive >= 1){
            System.out.println("You won the 75/25 pity!");
            wonseventyFive = true;
        } else if(seventyFive == 0 & !wonseventyFive){
            System.out.println("You are guaranteed to win the 75/25 pity!");
            wonseventyFive = true;
        } else if(seventyFive == 0){
            System.out.println("You lost the 75/25 pity!");
            wonseventyFive = false;
        }
    }

    public int getFiveStarCharacterPity(){
        return FiveStarCharacterPity;
    }

    public int getFiveStarWeaponPity(){
        return FiveStarWeaponPity;
    }

    public int getFourStarCharacterPity() {
        return FourStarCharacterPity;
    }

    public int getFourStarWeaponPity() {
        return FourStarWeaponPity;
    }

    public int getTotalCharacterBannerSummons() {
        return totalCharacterBannerSummons;
    }

    public int getTotalWeaponBannerSummons() {
        return totalWeaponBannerSummons;
    }

    public int getFiveStarWeapons() {
        return FiveStarWeapons;
    }

    public int getFiveStarCharacters() {
        return FiveStarCharacters;
    }

    public int getPrimoGems() {
        return primoGems;
    }

    protected void setPrimoGems(int primoGems) {
        this.primoGems = primoGems;
    }

    Random rnd = new Random();
    private int totalCharacterBannerSummons = 0;
    private int totalWeaponBannerSummons = 0;
    private int FiveStarCharacterPity = 0;
    private int FourStarCharacterPity = 0;
    private int FourStarWeaponPity = 0;
    private int FiveStarWeaponPity = 0;
    private int FiveStarCharacters = 0;
    private int FiveStarWeapons = 0;
    private int primoGems;
    private final int summonCost = 160;
}
