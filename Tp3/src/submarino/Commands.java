package submarino;

import java.util.HashMap;
import java.util.Map;

public abstract class Commands {
    public abstract void execute(Submarino submarino);
    public static Commands createMovement(String command){
        Map<String,Commands> commandMap = new HashMap<>();
        commandMap.put("l", new TurnLeft());
        commandMap.put("r", new TurnRight());
        commandMap.put("f", new MoveFWD());
        commandMap.put("d", new Down());
        commandMap.put("u", new Up());
        commandMap.put("m", new LaunchICBM());
        return commandMap.getOrDefault(command, new NoOperation());

    }
}