package transformacionClaves;

public class ModularHash{
    
    int K;
   
    public ModularHash(){
        this.K = 10;
    }
    
    public ModularHash(int K){
        this.K = K; 
    }
    
    public void setK(int K){
        this.K = K;
    }
    
    public Integer transformElement(Integer element){
        return (element % K) + 1;
    }
    
}