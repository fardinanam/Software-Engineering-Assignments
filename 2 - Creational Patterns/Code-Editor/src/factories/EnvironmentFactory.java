package factories;

import fonts.Font;
import parsers.Parser;

public interface EnvironmentFactory {
    public Parser getParser();
    public Font getFont();
    public String environmentName();
}
