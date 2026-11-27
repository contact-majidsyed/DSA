package practice.graphs_and_union_find.accounts_merge;

import java.util.*;

/** Accounts Merge. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: accounts = [["Alex","x@example.com","y@example.com"],["Alex","y@example.com","z@example.com"]]
    //   Output: [["Alex","x@example.com","y@example.com","z@example.com"]]
    // Example 2:
    //   Input: accounts = [["Alex","a@example.com"],["Alex","b@example.com"]]
    //   Output: [["Alex","a@example.com"],["Alex","b@example.com"]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        // ===== LOOP START L1: for loop =====
        for (List<String> account : accounts) {
            // ===== LOOP START L2: for loop =====
            for (int i = 1; i < account.size(); i++) {
                // Example 1 visits x@example.com,y@example.com, then y@example.com,z@example.com.
                // Comments below abbreviate these emails as x,y,z; names are Alex.
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                size.putIfAbsent(email, 1);
                owner.putIfAbsent(email, account.get(0));
                // AFTER unions in input order: x with x changes nothing; x with y sets parent[y]=x;
                // y with y changes nothing; y with z sets parent[z]=x. Final root x has size 3.
                union(parent, size, account.get(1), email);
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        Map<String, List<String>> groups = new HashMap<>();
        // ===== LOOP START L3: for loop =====
        for (String email : parent.keySet()) {
            // GROUP VISITS: each email finds root x -> groups[x] contains x,y,z. HashMap visit order is unspecified.
            groups.computeIfAbsent(find(parent, email), key -> new ArrayList<>()).add(email);
        }
        // ===== LOOP END L3 =====
        List<List<String>> result = new ArrayList<>();
        // ===== LOOP START L4: for loop =====
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            // AFTER sorting this group: emails=[x,y,z]. Then prepend Alex to form the result account.
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(entry.getKey()));
            merged.addAll(emails);
            result.add(merged);
        }
        // ===== LOOP END L4 =====
        return result;
    }
    private String find(Map<String, String> parent, String email) {
        // FIND RECURSION: find(y) reads p=x; find(x) reads p=x, its own root.
        String p = parent.get(email);
        // BASE CASE is p.equals(email): skip recursion. Otherwise call find(p), then compress the path.
        // For y: recursive find(x) returns x; parent[y] is set to x.
        if (!p.equals(email)) parent.put(email, find(parent, p));
        return parent.get(email);
    }
    private void union(Map<String, String> parent, Map<String, Integer> size, String a, String b) {
        String ra = find(parent, a), rb = find(parent, b);
        // UNION EARLY RETURN when both emails already have the same root; no size change.
        if (ra.equals(rb)) return;
        if (size.get(ra) < size.get(rb)) { String temp = ra; ra = rb; rb = temp; }
        // ATTACH the smaller root under the larger. For final union: rb=z,ra=x -> parent[z]=x.
        parent.put(rb, ra);
        // After the two actual joins, size[x]=2, then 3. Result has one merged account.
        size.put(ra, size.get(ra) + size.get(rb));
    }
}
