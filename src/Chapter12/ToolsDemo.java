package Chapter12;

enum Tools{
    SCREWDRIVER,
    WRENCH,
    HAMMER,
    PLIERS
}
public class ToolsDemo {
    public static void main(String[] args) {
        System.out.println("Enum Tools contains:");
        for (Tools tool: Tools.values()){
            System.out.println(tool + " Ordinal: " + tool.ordinal());
        }
    }
}
