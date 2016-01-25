package transform;

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
    
    public long transformElement(Integer element){
        return (element % K) + 1;
    }
    
}