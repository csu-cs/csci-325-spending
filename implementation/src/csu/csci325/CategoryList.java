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

    ArrayList get() {
        return categoryList;
    }

}
