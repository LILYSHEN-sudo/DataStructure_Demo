package losummer;

import java.util.HashSet;

public class MaxSubArray {

    //Method1: Hashtable
    public int maxSubArrayLen(String s) {
        HashSet<Character> dic = new HashSet<>();
        int res = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(!dic.contains(cur)) {
                dic.add(cur);
                count++;
            } else {
                count = 1;
            }

            if(res < count) {
                res = count;
            }
        }
        return res;
    }

    //Method2: Array
    public int maxSubArrayLen2(String s) {
        int n = s.length();
        int[] lastPos = new int[128];
        for(int i = 0; i < 128; i++) {
            lastPos[i] = -1;
        }
        int maxLen = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(lastPos[c] >= start) {
                start = lastPos[c] + 1;
            }
            lastPos[c] = i;
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        MaxSubArray slide = new MaxSubArray();
        int res = slide.maxSubArrayLen("pwwkew");
        int res2 = slide.maxSubArrayLen2("pwwkew");
        System.out.println(res);
        System.out.println(res2);
    }
}


