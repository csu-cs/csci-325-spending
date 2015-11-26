package csu.csci325;

import java.security.PublicKey;

/**
 * Created by BBrak on 11/22/2015.
 */
public class LinkedQueue<T> extends QueueWrapper<T> {
    private class Node<T>{
        public T mVal;
        public Node<T> mNext;
    }

    Node<T> mHead, mTail;
    int mSize = 0;


    public LinkedQueue(){
        mHead = mTail = null;
    }


    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>();
        newNode.mVal = element;
        if(mTail != null) {
            mTail.mNext = newNode;
        }
        mTail = newNode;

        if(mHead == null){
            mHead = mTail;
        }
        mSize++;
    }

    @Override
    public T dequeue() {
        T ret = first();
        if(!isEmpty()) {
            mHead = mHead.mNext;
            mSize--;
        }
        if(isEmpty()){
            mTail = null;
        }
        return ret;
    }

    @Override
    public T first() {
        if(!isEmpty()) {
            return mHead.mVal;
        }return null;
    }

    @Override
    public int size() {
        return mSize;
    }

}
