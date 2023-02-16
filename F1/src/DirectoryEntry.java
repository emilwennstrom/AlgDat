/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DirectoryEntry){
            DirectoryEntry temp = (DirectoryEntry) o;
            return temp.name.compareTo(this.name) == 0;
        }
       return false;
    }

}
