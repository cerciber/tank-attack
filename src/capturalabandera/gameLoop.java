/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturalabandera;

/**
 *
 * @author cesar
 */
public class gameLoop {
    
    MenuPrincipal menuPrincipal = new MenuPrincipal(); 
    
    public void iniciar(){
        
        eventos();
        
        while(true){
            
            actualizar();
            imprimir();
            
            try{Thread.sleep(1);}
            catch(InterruptedException ex){}
            
        }
        
    }
    
    public void eventos(){
        
        
        
    } 
    
    public void actualizar(){
        
        
        
    }
    
    public void imprimir(){
        
        
    }
    
    

}
