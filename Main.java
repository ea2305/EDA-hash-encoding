import menu.*;//Importamos la funcionalidad del menu
import transform.*;

public class Main{
    
    public static void main(String []argv){
        //Instancia de menu principal
        String [] elements = {"wea","cosa","otra cosa", "etc"}; 
        Menu myMenu = new Menu("EL MENU", elements);
        
        myMenu.printTitle();
        myMenu.printOptions();
        
        ModularHash modularHash = new ModularHash(100);
        
        System.out.println(modularHash.transformElement(7259));
        
    }
    
}