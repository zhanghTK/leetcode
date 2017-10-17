package tk.zhangh.leetcode.medium;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Here is an example of version numbers ordering:
 * <p/>
 * 0.1 < 1.1 < 1.2 < 13.37
 * Created by ZhangHao on 2017/5/2.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int i = 0;
        for (; i < version1s.length && i < version2s.length; i++) {
            if (Integer.parseInt(version1s[i]) < Integer.parseInt(version2s[i])) {
                return -1;
            } else if (Integer.parseInt(version1s[i]) > Integer.parseInt(version2s[i])) {
                return 1;
            }
        }
        if (version2s.length > version1s.length) {
            for (; i < version2s.length; i++) {
                if (Integer.parseInt(version2s[i]) != 0) {
                    return -1;
                }
            }
        } else if (version1s.length > version2s.length) {
            for (; i < version1s.length; i++) {
                if (Integer.parseInt(version1s[i]) != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
