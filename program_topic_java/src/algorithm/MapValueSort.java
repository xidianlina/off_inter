package algorithm;

import java.util.*;

public class MapValueSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("three", 3);
        map.put("nine", 9);
        map.put("zero", 0);
        map.put("five", 5);
        map.put("two", 2);
        map.put("six", 6);
        MapValueSort m = new MapValueSort();
        Map<String, Integer> res = m.mapValueSort(map);
        for (String key : res.keySet()) {
            System.out.println(key + " " + res.get(key));
        }
    }

    public <T extends Comparable> Map<String, T> mapValueSort(Map<String, T> map) {
        int size = map.size();
        if (size == 0 || map == null) {
            return map;
        }
        List<Map.Entry<String, T>> list = new ArrayList<>();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<String, T>>() {
            @Override
            public int compare(Map.Entry<String, T> o1, Map.Entry<String, T> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<String, T> m = new LinkedHashMap<>();
        for (Map.Entry<String, T> entry : list) {
            m.put(entry.getKey(), entry.getValue());
        }
        return m;
    }
}
