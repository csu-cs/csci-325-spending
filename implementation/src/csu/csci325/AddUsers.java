package csu.csci325;

/**
 * Created by BBrak on 11/28/2015.
 */
public class AddUsers<P, N> {
    private int mSize;

    public class Node{
        public P mPassword;
        public N mUserName;
        Node mNext;
    }

    private Object mTable[];

    public AddUsers(){
        mTable = (new Object[100]);
        for(int i = 0; i < mTable.length; i++){
            mTable[i] = null;
        }
    }

    public void put(N userName, P password){
        Node newNode = new Node();
        newNode.mUserName = userName;
        newNode.mPassword = password;
        newNode.mNext = null;

        int index = password.hashCode() % mTable.length;

        if(mTable[index] != null){
            newNode.mNext = (Node)(mTable[index]);
            mTable[index] = newNode;
        }else{
            mTable[index] = newNode;
        }

        mSize++;
    }

    public N get(P password){
        int index = password.hashCode() % mTable.length;

        if(mTable[index] == null)
            return null;
        else{
            Node node = (Node)(mTable[index]);
            while(node != null && !node.mPassword.equals(password))
            node = node.mNext;
            if(node == null)
                return null;
            else
                return node.mUserName;
        }
    }

    public int size(){
        return mSize;
    }



}
