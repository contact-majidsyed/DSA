package practice.graphs_and_union_find.accounts_merge;

import java.util.*;

/** Accounts Merge. See explanation.md for the contract and walkthrough. */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                size.putIfAbsent(email, 1);
                owner.putIfAbsent(email, account.get(0));
                union(parent, size, account.get(1), email);
            }
        }
        Map<String, List<String>> groups = new HashMap<>();
        for (String email : parent.keySet()) {
            groups.computeIfAbsent(find(parent, email), key -> new ArrayList<>()).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(entry.getKey()));
            merged.addAll(emails);
            result.add(merged);
        }
        return result;
    }
    private String find(Map<String, String> parent, String email) {
        String p = parent.get(email);
        if (!p.equals(email)) parent.put(email, find(parent, p));
        return parent.get(email);
    }
    private void union(Map<String, String> parent, Map<String, Integer> size, String a, String b) {
        String ra = find(parent, a), rb = find(parent, b);
        if (ra.equals(rb)) return;
        if (size.get(ra) < size.get(rb)) { String temp = ra; ra = rb; rb = temp; }
        parent.put(rb, ra);
        size.put(ra, size.get(ra) + size.get(rb));
    }
}
