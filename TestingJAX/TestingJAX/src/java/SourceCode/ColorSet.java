/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.util.HashMap;

/**
 *
 * @author CAR
 */
public class ColorSet {

    HashMap<Integer, Color> colors = new HashMap<>();
    Color blue = new Color("blue", "#339BFF");
    Color green = new Color("green", "#34FF33");
    Color yellow = new Color("yellow", "#F6FF33");
    private static ColorSet instance = null;
    int id = 1;

    public static ColorSet getInstance() {
        if (instance == null) {
            instance = new ColorSet();
        }
        return instance;
    }

    public void initialize() {
        if(colors.isEmpty()){
        colors.put(id++, blue);
        colors.put(id++, green);
        colors.put(id++, yellow);
        }
       
    }

    public String getColors() {
        StringBuilder str = new StringBuilder();
        for (Integer i : colors.keySet()) {
            String colorName = colors.get(i).getName() + " " + colors.get(i).getHex();
            str.append(String.format("%s\n", colorName));
        }
        return str.toString();
    }

    public String getColor(int colorId) {
        String str = colors.get(colorId).getName() + " " + colors.get(colorId).getHex();
        return str;
    }

    public int listSize() {
        return colors.size();
    }
    
    public boolean doesExist(int id){
        for(Integer i: colors.keySet()){
            if(i.equals(id)){
                return true;
            }
        }
        return false;
    }

    public void addColor(String colorName, String colorHex) {
        Color color = new Color(colorName, colorHex);
        colors.put(id++, color );
    }

    public boolean deleteColor(int id) {
            colors.remove(id);
            return true;
            }
}
