import Editors.Editor;
import factories.EnvironmentFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = Editor.getInstance();

        while (true) {
            String filename = scanner.nextLine();
            EnvironmentFactory environment = editor.getEnvironment(filename);
            if(environment != null) {
                String parserName = environment.getParser().parserName();
                String fontName = environment.getFont().fontName();

                System.out.println(environment.environmentName() + " uses " + parserName + " and " + fontName + " font.");
            }
        }
    }
}
