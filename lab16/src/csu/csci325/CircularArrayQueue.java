package csu.csci325;

/**
 * Created by BBrak on 11/22/2015.
 */
public class CircularArrayQueue<T> extends QueueWrapper<T> {
    T[] mArray;
    int mHead, mTail;
    int mSize;

    public CircularArrayQueue(){
        mArray = (T[])(new Object[100]);
        mHead = mTail = mSize = 0;

    }

    @Override
    public void enqueue(T element) {
        if(size() == mArray.length){
            expandCapacity();
        }
        mArray[mTail] = element;
        mTail = (mTail + 1) % mArray.length;
        mSize++;

    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
        T ret = mArray[mHead];
        mArray[mHead] = null;
        mHead = (mHead + 1) % mArray.length;
        mSize--;
        return ret;
        }else
            return null;

    }

    @Override
    public T first() {
        T ret = mArray[mHead];
        return ret;
    }

    @Override
    public int size() {
        return mSize;
    }

    public void expandCapacity(){
        T[] mArray2 = (T[])(new Object[mArray.length * 2]);
        for(int index = 0; index < mSize; index++) {
            mArray2[index] = mArray[mHead];
            mHead = (mHead + 1) % mArray.length;
        }
        mHead = 0;
        mTail = mSize;
        mArray = mArray2;
    }
}
