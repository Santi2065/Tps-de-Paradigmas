package submarino;

import java.util.HashMap;
import java.util.Map;

public abstract class Commands {
    public static Submarino submarino = new Submarino();
    public abstract void execute();
    public static Commands createMovement(String command){
        Map<String,Commands> commandMap = new HashMap<>();
        commandMap.put("l", new TurnLeft());
        commandMap.put("r", new TurnRight());
        commandMap.put("f", new MoveFWD());
        commandMap.put("d", new Down());
        commandMap.put("u", new Up());
        commandMap.put("m", new LaunchICBM());
        return commandMap.getOrDefault(command, new InvalidCommand());

    }

    public static void main(String[] args) {
        String commands = "rffrffrffrff";
        for (char c : commands.toCharArray()) {
            Commands.createMovement(String.valueOf(c)).execute();
        }
        System.out.println(submarino.position().toString());
        System.out.println(submarino.direction());
        System.out.println(submarino.depth.get(submarino.depth.size()-1).toString());
    }
}