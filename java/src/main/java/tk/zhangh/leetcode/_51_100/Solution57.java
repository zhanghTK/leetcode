package tk.zhangh.leetcode._51_100;

import tk.zhangh.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        int i;
        // 找到应该插入的位置
        for (i = 0;
             i < intervals.size() &&
                     intervals.get(i).end < newInterval.start;  // 插入条件 newInterval.start<intervals[i].end
             i++) {
            res.add(intervals.get(i));
        }
        // 插入
        if (i < intervals.size()) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        res.add(newInterval);
        // 找到不重叠位置
        for (; i < intervals.size() &&
                intervals.get(i).start <= newInterval.end;  // 冲突条件 intervals[i].start <= newInterval.end
             i++) {
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        }
        // 添加剩余
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
