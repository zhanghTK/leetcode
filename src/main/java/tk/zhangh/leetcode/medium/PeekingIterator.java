package tk.zhangh.leetcode.medium;

import java.util.Iterator;

/**
 * Created by ZhangHao on 2017/5/15.
 */
public class PeekingIterator implements Iterator<Integer> {

    Integer cache;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.cache = iterator.next();
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = cache;
        cache = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || cache != null;
    }
}
