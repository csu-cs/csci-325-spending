package csu.csci325;

import java.util.ArrayList;

/**
 * Created by N'dia on 11/25/2015.
 */
public class CategoryList {
    public static CategoryList catList = new CategoryList();
    public ArrayList categoryList = new ArrayList();

    void addString (String cat) {
        categoryList.add(cat);
    }

    String[] getAsArray() {
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        return catL;
    }

    public void ListToStringOutput(){
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        for (int i = 0; i < catL.length; i++) {
            System.out.println(catL[i]);
        }
    }

    String ListToString() {
        String str = "";
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);

        for (int i = 0; i < catL.length - 1; i++) {
            str = str + catL[i] + ", ";
        }

        str = str + "& " + catL[catL.length - 1] + ".";
        return str;
    }

}
