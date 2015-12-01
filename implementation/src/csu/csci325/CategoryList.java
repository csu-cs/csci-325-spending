package csu.csci325;

import java.util.ArrayList;

public class CategoryList {
    public static CategoryList catList = new CategoryList();
    public ArrayList categoryList = new ArrayList();

    void addString (String cat) {
        categoryList.add(cat);
    }

    void removeString (String cat) {
        categoryList.remove(cat);
    }

    String[] getAsArray() {
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        return catL;
    }

    public void PrintListToString(){
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);
        for (String aCatL : catL) {
            System.out.println(aCatL);
        }
    }

    String ListToString() {
        String str = "";
        String catL[] = (String[]) categoryList.toArray(new String[categoryList.size()]);

        if (categoryList.size() > 1) {
            for (int i = 1; i < catL.length - 1; i++) {
                str = str + catL[i] + ", ";
            }
            str = str + "& " + catL[catL.length - 1] + ".";
        }

        return str;
    }

}
