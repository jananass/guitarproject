/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;
import java.util.*;

/**
 *
 * @author s16005598
 */
public class GuitarChord {
    public String name;
    public int fret;
    public String tuning;
    public String[] strings;
    
    public GuitarChord(String n,int f,String t,String[] s)
    {
        name = n; fret = f; tuning = t; strings = s;
    }
}
