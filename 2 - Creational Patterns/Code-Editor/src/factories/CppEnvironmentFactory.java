package factories;

import fonts.Font;
import fonts.MonacoFont;
import parsers.CppParser;
import parsers.Parser;

public class CppEnvironmentFactory implements EnvironmentFactory {
    @Override
    public Parser getParser() {
        return new CppParser();
    }

    @Override
    public Font getFont() {
        return new MonacoFont();
    }

    @Override
    public String environmentName() {
        return "CPP Environment";
    }
}
