package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Created by ZhangHao on 2017/4/14.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(o -> o.start));

        List<Interval> result = new ArrayList<>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= last.end) {
                last.end = Math.max(last.end, curt.end);
            } else {
                result.add(last);
                last = curt;
            }
        }
        result.add(last);
        return result;
    }
}
