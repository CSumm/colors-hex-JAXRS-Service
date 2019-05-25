/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

/**
 *
 * @author CAR
 */
public class Color {
    String name = "";
    String hex = "";
    
    
     public Color(String name, String hex){
         this.name = name;
         this.hex = hex;
     }
     
     public String getName(){
         return this.name;
     }
     
     public void setName(String newName){
         this.name = newName;
     }
     
     public String getHex(){
         return this.hex;
     }
     
     public void setHex(String newHex){
         this.hex = newHex;
     }
     
}
