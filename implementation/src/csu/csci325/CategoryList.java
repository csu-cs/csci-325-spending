package csu.csci325;

import java.util.ArrayList;

/**
 * Created by N'dia on 11/25/2015.
 */
public class CategoryList {
    public ArrayList categoryList = new ArrayList();

    void addString (String cat) {
        categoryList.add(cat);
    }

    String[] getAsArray() {
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        return catL;
    }

    public void ListToString(){
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        for (int i = 0; i < catL.length; i++) {
            System.out.println(catL[i]);
        }
    }

}
