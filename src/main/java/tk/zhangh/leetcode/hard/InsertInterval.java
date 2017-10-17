package tk.zhangh.leetcode.hard;

import tk.zhangh.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/14.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int i;
        for (i = 0; i < intervals.size() && intervals.get(i).end < newInterval.start; i++) {
            res.add(intervals.get(i));
        }

        if (i < intervals.size()) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        res.add(newInterval);
        for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; i++) {
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        }
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
