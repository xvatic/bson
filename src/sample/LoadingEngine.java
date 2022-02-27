package sample;

public class LoadingEngine {
    public static Class start(String modulePath, String moduleFullName) {

        ModuleLoader loader = new ModuleLoader(modulePath, ClassLoader.getSystemClassLoader());
        try {
            String moduleName = moduleFullName.split("\\.class")[0];
            return loader.loadClass(moduleName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
