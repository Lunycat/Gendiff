package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name="gendiff", version = "1.0.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class Differ implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, World!");
    }
}
