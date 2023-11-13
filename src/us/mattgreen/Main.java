package us.mattgreen;

import us.mattgreen.talkables.TalkableCreator;
import us.mattgreen.talkables.pet.Cat;
import us.mattgreen.talkables.pet.Dog;
import us.mattgreen.talkables.Talkable;
import us.mattgreen.talkables.person.Teacher;
import us.mattgreen.util.FileInput;
import us.mattgreen.util.FileOutput;

import java.util.ArrayList;

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();

        // Lines to Replace Begin Here
        TalkableCreator tc = new TalkableCreator(zoo);
        tc.create();
        // End Lines to Replace

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }
}
