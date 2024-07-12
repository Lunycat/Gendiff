package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "gendiff",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    Path filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    Path filepath2;

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish",
            paramLabel = "format")
    String format;

    @Override
    public String call() throws IOException {
        String diff = Differ.generate(filepath1, filepath2);
        System.out.println(diff);
        return diff;
    }
}
