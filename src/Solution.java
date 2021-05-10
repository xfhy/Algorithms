import java.util.ArrayList;
import java.util.List;

/**
 * @author : xfhy
 * Create time : 2021年05月8日08:58:46
 * Description :
 * source : https://leetcode-cn.com/problems/coin-change/
 */
public class Solution {

    //问题:输入一组不重复的数字,返回它们的全排列

    //思路:首先这题肯定是求所有答案,也就是全部穷举完,回朔法
    //核心就是:
    /*

    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表中移除
        路径.add(选择)
        backtrack(路径,选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择恢复到选择列表

    * */

    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute1(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(track, nums);
        return res;
    }

    /**
     * 回溯
     *
     * @param track 路径
     * @param nums  选择列表
     */
    public void backtrack(List<Integer> track, int nums[]) {
        //已完成路径
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //路径中已存在 该选择
            if (track.contains(nums[i])) continue;
            //做出选择
            track.add(nums[i]);
            //回溯
            backtrack(track, nums);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.permute1(new int[]{3, 5, 7}));
    }

}