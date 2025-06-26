package Slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    //这道题和CheckInclusion很像，只需要添加一个arraylist来记录left的值就好
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<>();   //新建ArrayList
        if(m < n) {
            return res;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char curS = s.charAt(i);
            char curP = p.charAt(i);
            mapS.put(curS, mapS.getOrDefault(curS, 0) + 1);
            mapP.put(curP, mapP.getOrDefault(curP, 0) + 1);
        }
        int left = 0;
        if(mapS.equals(mapP)) {
            res.add(left);     //添加left到ArrayList
        }
        for(int right = n; right < m; right++) {
            char curR = s.charAt(right);
            mapS.put(curR, mapS.getOrDefault(curR, 0) + 1);
            char curL = s.charAt(left);
            mapS.put(curL, mapS.get(curL) - 1);
            if(mapS.get(curL) == 0) {
                mapS.remove(curL);
            }
            left++;
            if(mapS.equals(mapP)) {
                res.add(left);       //添加left到ArrayList
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagrams ch = new FindAllAnagrams();
        String s1 = "abab";
        String s2 = "ab";
        List<Integer> res = ch.findAnagrams(s1, s2);
        System.out.println(res);
    }
}
