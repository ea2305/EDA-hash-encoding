import menu.*;//Importamos la funcionalidad del menu
import transformacionClaves.*;

public class Main{

    public static void main(String []argv){
        //Instancia de menu principal
        String [] elements = {"wea","cosa","otra cosa", "etc"};
        Menu myMenu = new Menu("EL MENU", elements);

        myMenu.printTitle();
        myMenu.printOptions();


        Kernel kernel = new Kernel();
        System.out.println(kernel.testHash(7259, 100));
        System.out.println(kernel.testHash(9359, 100));
    }

}
