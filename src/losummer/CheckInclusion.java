package losummer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckInclusion {
    public boolean checkAnagram(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) {
            return false;
        }
        //记录s1中每个字符的需求次数
        int[] freq = new int[26];
        for(char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = 0; //记录当前窗口匹配到的字符数量

        //右指针不断扩张窗口
        while(right < m) {
            int curR = s2.charAt(right++) - 'a';
            //如果这个字符事s1所需的，则count++
            if (freq[curR] > 0) {
                count++;
            }
            //无论是否匹配，都要将freq中对应计数--
            freq[curR]--;

            //当窗口超过s1长度时，移动左指针收缩窗口
            if (right - left > n) {
                int curL = s2.charAt(left++) - 'a';
                //若移除的字符本来就是满足需求的，则count--
                if (freq[curL] >= 0) {
                    count--;
                }
                //恢复freq中该字符的计数
                freq[curL]++;
            }

            //一旦count达到s1的长度，说明窗口内正好包含一个异位词
            if (count == n) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m > n) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < m; i++) {
            char cur1 = s1.charAt(i);
            char cur2 = s2.charAt(i);
            map1.put(cur1, map1.getOrDefault(cur1, 0) + 1);
            map2.put(cur2, map2.getOrDefault(cur2, 0) + 1);
        }

        if(map1.equals(map2)) {
            return true;
        }

        int left = 0;
        for(int right = m; right < n; right++) {
            char curR = s2.charAt(right);
            map2.put(curR, map2.getOrDefault(curR, 0) + 1);

            char curL = s2.charAt(left);
            map2.put(curL, map2.get(curL) - 1);

            if(map2.get(curL) == 0) {
                map2.remove(curL);
            }
            left++;

            if(map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CheckInclusion ch = new CheckInclusion();
        String s1 = "abc";
        String s2 = "dcba";
        boolean res = ch.checkAnagram(s1, s2);
        boolean res2 = ch.checkInclusion(s1,s2);
        System.out.println(res);
        System.out.println(res2);
    }
}
