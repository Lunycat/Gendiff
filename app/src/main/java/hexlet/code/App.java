package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;

@CommandLine.Command(
        name="gendiff",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File filepath2;

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish",
            paramLabel = "format")
    String format;

    @Override
    public void run() {
        System.out.println("aaaa");
    }
}
