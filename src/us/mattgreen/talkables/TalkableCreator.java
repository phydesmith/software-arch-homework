package us.mattgreen.talkables;

import us.mattgreen.input.InputGatherer;
import us.mattgreen.talkables.person.Teacher;
import us.mattgreen.talkables.pet.Cat;
import us.mattgreen.talkables.pet.Dog;

import java.util.List;

public class TalkableCreator {
    private static final String DOG = "dog";
    private static final String CAT = "cat";
    private static final String TEACHER = "teacher";

    private List<Talkable> zoo;


    public TalkableCreator(List<Talkable> zoo) {
        this.zoo = zoo;
    }

    public void create() {
        boolean isCreating = true;
        while (isCreating) {
            String input = askToCreate();
            if (input.equalsIgnoreCase(DOG)) {
                createDog();
            } else if (input.equalsIgnoreCase(CAT)) {
                createCat();
            } else if (input.equalsIgnoreCase(TEACHER)) {
                createTeacher();
            } else {
                invalidInput();
            }
            isCreating = !askIfFinished();
        }
    }

    public String askToCreate() {
        return InputGatherer.promptForStringInput("What would you like to create? (dog, cat, teacher): ");
    }



    public void createDog() {
        this.zoo.add(
            new Dog(
                isFriendly(),
                getName()
            )
        );
    }
    private String getName(){
        return InputGatherer.promptForStringInput("What is the name of your talkable?: " );
    }
    private boolean isFriendly(){
        return InputGatherer.promptForStringInput("Is your dog friendly? (y/n): ").equalsIgnoreCase("y");
    }

    public void createCat() {
        this.zoo.add(
                new Cat(
                        getKills(),
                        getName()
                )
        );
    }
    private int getKills(){
        return InputGatherer.promptForIntInput("How many mice did your cat kill?: ");
    }


    public void createTeacher() {
        this.zoo.add(
                new Teacher(
                        getAge(),
                        getName()
                )
        );
    }
    private int getAge(){
        return InputGatherer.promptForIntInput("How old is this person?: ");
    }

    public void invalidInput() {
        InputGatherer.invalidInput();
    }

    public boolean askIfFinished() {
        return InputGatherer.promptForStringInput("Are you finished creating? (y/n): ").equalsIgnoreCase("y");
    }








}