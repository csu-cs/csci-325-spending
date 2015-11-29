package csu.csci325;

public class Main {
    public static void main(String[] args) {
        StartFrame sf = new StartFrame();
        AddUsers added = new AddUsers();
        //Users user1 = new Users("Brian", "cat");

        added.put("Brian", "cat");
        added.put("N'dia", "java");

        System.out.println(added.size());
        System.out.println(added.get("java"));


    //NEED TO SWITCH FRAMES TO PANELS CALLED FROM START FRAME
        //SETUP, ADD EXPENSE, TRACKING, USER PROFILE

    }
}
