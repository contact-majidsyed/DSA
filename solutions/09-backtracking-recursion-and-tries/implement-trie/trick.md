# Implement Trie: Quick Recall

**Trick:** Use c-'a' to select a child slot. A path proves a prefix exists; an end marker is required to prove the whole word was inserted.

**Key code:** `return node != null && node.end;`

**Looks like:** After inserting apple: root->a->p->p->l->e*; search(app)=false, startsWith(app)=true.

**Remember:** Path means prefix; marker means word.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
