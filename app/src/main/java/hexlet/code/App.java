package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "gendiff",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<String> {

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish",
            paramLabel = "format")
    private String format;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public String call() throws IOException {
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
        return result;
    }
}
