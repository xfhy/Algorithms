import java.util.HashMap;

/**
 * @author : xfhy
 * Create time : 2021年06月17日08:58:46
 * Description : 滑动窗口
 * source :
 */
public class Solution {

    /**
     * 最小覆盖子串
     *
     * @param s 全部字符串
     * @param t 需要在s中找到包含t的最小子串
     */
    public String minWindow(String s, String t) {
        HashMap<String, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String c = String.valueOf(t.charAt(i));
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        //窗口中满足need条件的字符个数
        int valid = 0;
        //记录最小字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //c是将移入窗口的字符
            String c = String.valueOf(s.charAt(right));
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新   need中有这个字符
            if (need.get(c) != null) {
                //窗口中相应字符个数+1
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果窗口中该字符个数与need中该字符个数相等,则说明该字符收集满了
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            System.out.printf("window: [%d,%d)", left, right);

            //need中的字符全部都收集齐了,则收缩左侧窗口
            while (valid == need.size()) {
                //在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                String d = String.valueOf(s.charAt(left));
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新   -> need含有该字符,才需要更新窗口内数据
                if (need.get(d) != null) {
                    //need中的该字符个数比窗口中该字符个数相等,则需要将valid-1
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    //窗口中相应字符个数-1
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String minWindow = solution.minWindow("AABBCCDGEDDS", "BCA");
        System.out.println("\n");
        System.out.println(minWindow);
    }

}