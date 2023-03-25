
### 快速排序

挖坑+分治法. 

```java

class Solution {

    void quickSort(int s[], int l, int r) {
        if (l < r) {
            //基准数
            int x = s[l];
            int i = l, j = r;
            while (i < j) {
                //从右往左,找比基准数小的
                while (i < j && s[j] > x) {
                    j--;
                }
                if (i < j) {
                    //找到第一个比基准数小的之后,将其放入坑中
                    s[i++] = s[j];
                }
                //从左往右,找比基准数大的
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }

            //将基准数放最后腾出来的坑里
            s[i] = x;
            //分治法
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] s = new int[]{23, 2312, 312, 43, 214, 124, 12};
        solution.quickSort(s, 0, s.length - 1);
        for (int i : s) {
            System.out.println(i);
        }
    }

}
```