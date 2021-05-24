package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int a = nums[0], cnta = 0;
        int b = nums[0], cntb = 0;
        for (int num : nums) {
            if (num == a) {
                ++cnta;
            } else if (num == b) {
                ++cntb;
            } else if (cnta == 0) {
                a = num;
                cnta = 1;
            } else if (cntb == 0) {
                b = num;
                cntb = 1;
            } else {
                --cnta;
                --cntb;
            }
        }
        cnta = 0;
        cntb = 0;
        for (int num : nums) {
            if (num == a) {
                ++cnta;
            } else if (num == b) {
                ++cntb;
            }
        }
        if (cnta > nums.length / 3) {
            res.add(a);
        }
        if (cntb > nums.length / 3) {
            res.add(b);
        }
        return res;
    }
}
