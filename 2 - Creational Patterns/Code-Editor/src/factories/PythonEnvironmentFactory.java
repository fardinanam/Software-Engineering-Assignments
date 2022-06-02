package factories;

import fonts.ConsolasFont;
import fonts.Font;
import parsers.Parser;
import parsers.PythonParser;

public class PythonEnvironmentFactory implements EnvironmentFactory {
    @Override
    public Parser getParser() {
        return new PythonParser();
    }

    @Override
    public Font getFont() {
        return new ConsolasFont();
    }

    @Override
    public String environmentName() {
        return "Python Environment";
    }
}
