package submarino.Commands;

import submarino.Submarino;

public class NoOperation extends Commands {
    public void execute(Submarino submarino) {
        System.out.println("Invalid Key, try again");
    }
}
