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
        
        System.out.println("resultado : " + kernel.modularHash(7259,100));
        
    }
    
}