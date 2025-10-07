package solutions.daily.sept25;


import java.util.*;

/*
165: Compare Version Numbers [MED]
 */
public class CompareVersion {
    public int compareVersion (String version1, String version2) {
        List<String> v1 = new ArrayList<>(List.of(version1.split("\\.")));
        List<String> v2 = new ArrayList<>(List.of(version2.split("\\.")));
        if (v1.size() < v2.size()) {
            int extra = v2.size() - v1.size();
            while(extra > 0) {
               v1.add("0");
               extra --;
            }
        }
        if (v2.size() < v1.size()) {
            int extra = v1.size() - v2.size();
            while (extra > 0) {
                v2.add("0");
                extra --;
            }
        }

        for (int i = 0; i < v1.size(); i++) {
           if (Integer.parseInt(v1.get(i)) > Integer.parseInt(v2.get(i))) return 1;
           if (Integer.parseInt(v1.get(i)) < Integer.parseInt(v2.get(i))) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion c = new CompareVersion();
        System.out.println(c.compareVersion("1.0.1", "1"));
    }

}
