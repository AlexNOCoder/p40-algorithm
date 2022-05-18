package minimum_window_substring_76;

import java.util.HashMap;

public class SolutionByAlex {
    public String minWindow(String s, String t) {
        // 记录t以及滑动窗口window中字符与个数的映射关系
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            need.put(c1, need.getOrDefault(c1, 0) + 1);
        }
        // 双指针，指向窗口开始和结束
        int left = 0;
        int right = 0;
        int count = 0;
        // 用于更新满足的窗口window的长度,如果是len一直是MAX_VALUE，说明没有满足的串
        int len = Integer.MAX_VALUE;
        // 用于记录window串的起始位置，则返回 s[start, len]
        int start = 0;

        while (right < s.length()) {
            // 扩张，流程与收缩对应
            char c = s.charAt(right);
            right++;
            // 只要c是t中出现的字符就更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 更新c字符出现的次数
                if (window.get(c).equals(need.get(c))) {
                    count++;
                }
            }
            // 调试使用： System.out.println(window);
            // 收缩window的长度
            while (count == need.size()) {
                // 更新并记录window的长度,以及window的起始位置start
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
