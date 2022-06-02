package factories;

import fonts.CourierNewFont;
import fonts.Font;
import parsers.CParser;
import parsers.Parser;

public class CEnvironmentFactory implements EnvironmentFactory {
    @Override
    public Parser getParser() {
        return new CParser();
    }

    @Override
    public Font getFont() {
        return new CourierNewFont();
    }

    @Override
    public String environmentName() {
        return "C Environment";
    }
}
