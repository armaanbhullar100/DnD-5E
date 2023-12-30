package character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import job.JobFactory;

public class CharacterController {
    
    public CharacterController() {}

    public Character createCharacter(Scanner scan) throws IOException {
        JobFactory jobFactory = new JobFactory(scan);
        RaceFactory raceFactory = new RaceFactory(scan);
        BackgroundFactory backgroundFactory = new BackgroundFactory(scan);

        // System.out.print("Please enter your character's name: ");
        // String characterName = scan.nextLine();
        
        // System.out.print("Please enter your name: ");
        // String playerName = scan.nextLine();

        // System.out.print("Please enter your class: ");
        // String jobName = scan.nextLine();

        // System.out.print("Please enter your race: ");
        // String raceName = scan.nextLine();

        // System.out.print("Please enter your background: ");
        // String backgroundName = scan.nextLine();

        // System.out.print("Please enter your alignment: ");
        // String alignment = scan.nextLine();

        // System.out.print("Please enter your strength: ");
        // int strength = scan.nextInt();

        // System.out.print("Please enter your dexerity: ");
        // int dexerity = scan.nextInt();

        // System.out.print("Please enter your constitution: ");
        // int constitution = scan.nextInt();

        // System.out.print("Please enter your intelligence: ");
        // int intelligence = scan.nextInt();

        // System.out.print("Please enter your wisdom: ");
        // int wisdom = scan.nextInt();

        // System.out.print("Please enter your charisma: ");
        // int charisma = scan.nextInt();

        // ArrayList<Integer> abilityScoresArray = new ArrayList<>();
        // abilityScoresArray.add(strength);
        // abilityScoresArray.add(dexerity);
        // abilityScoresArray.add(constitution);
        // abilityScoresArray.add(intelligence);
        // abilityScoresArray.add(wisdom);
        // abilityScoresArray.add(charisma);

        // return new Character(characterName, playerName, jobFactory.createJob(jobName), raceFactory.createRace(raceName), backgroundFactory.createBackground(backgroundName), alignment, abilityScoresArray);

        ArrayList<Integer> testAbilityScoresArray = new ArrayList<>();
        testAbilityScoresArray.add(12);
        testAbilityScoresArray.add(12);
        testAbilityScoresArray.add(12);
        testAbilityScoresArray.add(12);
        testAbilityScoresArray.add(12);
        testAbilityScoresArray.add(12);

        return new Character("test character name", "test player name", jobFactory.createJob("barbarian"), raceFactory.createRace("dwarf"), backgroundFactory.createBackground("acolyte"), "test alignment", testAbilityScoresArray);
    }

}
