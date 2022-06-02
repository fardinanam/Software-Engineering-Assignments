package Editors;

import factories.CEnvironmentFactory;
import factories.CppEnvironmentFactory;
import factories.EnvironmentFactory;
import factories.PythonEnvironmentFactory;

public class Editor {
    private Editor() {}
    private static class SingletonHelper {
        private static final Editor editor = new Editor();
    }
    public static Editor getInstance() {
        return SingletonHelper.editor;
    }

    public EnvironmentFactory getEnvironment(String filename) {
        String fileType;

        try {
            fileType = filename.split("\\.")[1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid file name");
            return null;
        }

        switch (fileType) {
            case "c":
                return new CEnvironmentFactory();
            case "cpp":
                return new CppEnvironmentFactory();
            case "py":
                return new PythonEnvironmentFactory();
            default:
                System.out.println("Invalid file extension");
                return null;
        }
    }
}
