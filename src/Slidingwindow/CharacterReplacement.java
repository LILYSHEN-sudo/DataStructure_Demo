package Slidingwindow;

public class CharacterReplacement {
    public int longestCharacterReplacement(String s, int k) {
        int[] dic = new int[26];
        int count = 0;
        int left = 0;
        int res = 0;

        for(int right = 0; right < s.length(); right++) {
            int cur = s.charAt(right) - 'a';
            dic[cur] = dic[cur] + 1;
            count = Math.max(count, dic[cur]);

            while(right - left + 1 - count > k) {
                dic[s.charAt(left++) - 'a']--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        CharacterReplacement ch = new CharacterReplacement();
        int res = ch.longestCharacterReplacement("aababba", 1);
        System.out.println(res);
    }
}
