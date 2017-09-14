package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution68 {
    // http://blog.csdn.net/linhuanmars/article/details/24063271
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        int count = 0;
        int last = 0;
        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() + (i - last) > maxWidth) {
                int spaceNum = 0;
                int extraNum = 0;
                if (i - last - 1 > 0) {
                    spaceNum = (maxWidth - count) / (i - last - 1);
                    extraNum = (maxWidth - count) % (i - last - 1);
                }
                StringBuilder str = new StringBuilder();
                for (int j = last; j < i; j++) {
                    str.append(words[j]);
                    if (j < i - 1) {
                        for (int k = 0; k < spaceNum; k++) {
                            str.append(" ");
                        }
                        if (extraNum > 0) {
                            str.append(" ");
                        }
                        extraNum--;
                    }
                }
                for (int j = str.length(); j < maxWidth; j++) {
                    str.append(" ");
                }
                res.add(str.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }

        StringBuilder str = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            str.append(words[i]);
            if (str.length() < maxWidth)
                str.append(" ");
        }
        for (int i = str.length(); i < maxWidth; i++) {
            str.append(" ");
        }
        res.add(str.toString());
        return res;
    }
}
