package algorithm;

/**
 * Created by xfhy on 2021/4/8 8:59
 * Description : 查找相关
 */
public class Find {

    /*
    //二分查找框架
    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }
    * */

    /**
     * 寻找一个数（基本的二分搜索）
     *
     * @param nums   升序数组
     * @param target 需要查找的数
     * @return target在数组中的下标, 找不到则返回-1
     */
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        //只要跳出循环 就是没找到呗
        return -1;
    }

    /**
     * 二分查找并返回第一次出现(左边界)的位置 or 寻找左侧边界的二分搜索
     *
     * @param nums   升序数组
     * @param target 需要查找的数
     * @return target在数组中的最左侧的下标(可能存在重复元素), 找不到则返回-1
     */
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        //跳出循环时 left==right+1,所以可能left会等于数组长度
        //跳出循环时  不一定已经找到了target在数组中的位置,所以需要判断一下
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 二分查找并返回最后一次出现(右边界)的位置 or 寻找右侧边界的二分搜索
     *
     * @param nums   升序数组
     * @param target 需要查找的数
     * @return target在数组中的最右侧的下标(可能存在重复元素), 找不到则返回-1
     */
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                //收缩左边界
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        //跳出循环时  left==right+1   此时可能left=0,right=-1  这是没有找到的情况,target比最小的还小
        //跳出循环时  没有找到,这种情况是target处于某2个nums元素之间,或者target比最大的还大
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int[] nums = {1, 2, 2, 2, 5, 6};
        //System.out.println(find.binarySearch(nums, 1));
//        System.out.println(find.left_bound(nums, 3));
        //System.out.println(find.right_bound(nums, 7));
    }

}

