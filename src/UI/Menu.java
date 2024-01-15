
package UI;

public class Menu {
    public static String printMenu(String menu){
        String arr[] = menu.split("\\|");
        for (String o : arr) {
            System.out.println(o.trim());
        }
        return tools.tool.inputString("Enter your choice");
    }
}
