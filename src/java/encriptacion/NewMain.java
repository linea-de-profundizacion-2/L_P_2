/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;

/**
 *
 * @author kefab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        AES256 d=new AES256();
        
        String 
        text="12";
        
        String sds= d.encrypt(text);
        System.out.println("sin: "+text+ "  encr: "+ sds);
        
        
        String s=d.decrypt(text);
        System.out.println("   des"+s);
    }
    
}
