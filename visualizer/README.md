# Two Sum interactive walkthrough

A React + React Flow example that connects the Java code to a live array, variables, and `seen` map. Use **Next**, **Back**, **Play/Pause**, **Reset**, or the step slider. The two question examples are included, along with a longer map example, an exception example, and custom integer input.

## Open it

GitHub's file viewer shows source code; it cannot run React or HTML. The intended online host is GitHub Pages. **Publishing is not enabled yet:** GitHub rejected Pages for this private repository because the current account plan does not support it. The repository remains private.

Meanwhile, the GitHub Actions workflow builds a downloadable `two-sum-visualizer` artifact. After a successful run, download and unzip it, then open `two-sum.html` in your browser. The artifact is self-contained: no server, CDN, or internet connection is needed to run the lesson. GitHub authentication may be required to download artifacts from this private repository.

To build locally with Node.js 22 or newer:

```sh
cd visualizer
npm ci
npm test
npm run build
```

Open `dist/two-sum.html` directly in a browser. `dist/index.html` is the identical site entry point for Pages.

## What the learner sees

- Each step highlights its Java statement and React Flow stage.
- The array shows values and zero-based indices separately.
- The map shows **number → earlier index**. A lookup never inserts an entry.
- New or overwritten entries are marked; a found entry is highlighted.
- Returning ends execution immediately, before storing the matched current value.
- Back restores a saved snapshot, including the earlier map state.
- Invalid custom inputs produce an error without replacing the current lesson.

This is a precomputed simulation of the checked-in Two Sum algorithm, not a Java runtime debugger. Java uses an unordered HashMap; rows are presented in insertion order here to make the visits easier to follow. The `long` complement and Java int-range guard are included. The UI's highlighted line numbers refer to its displayed method, where the range condition is wrapped across three lines.

## Browser checks

```sh
npx playwright install chromium
npm run test:ui
```

For an already installed browser, set `DSA_CHROME_PATH` to its executable path. Tests cover stepping, restoring old map state, playback completion, duplicate values, input validation, no-answer behavior, and mobile layout. The trace tests also cover overwritten map entries and Java integer boundaries.

## GitHub Pages deployment

The workflow in [visualizer.yml](../.github/workflows/visualizer.yml) builds and tests on changes to this app and uploads a downloadable artifact. It does not attempt unsupported Pages deployment automatically.

Once a repository supports Pages:

1. Set **Settings → Pages → Source** to **GitHub Actions**.
2. Run the **Two Sum visualizer** workflow manually with **deploy_pages** enabled.
3. Use the published deployment URL as the **Open interactive visualizer** link in the question.

Only the built files in `visualizer/dist/` are published. A separate public repository containing this app and its workflow is another hosting option; that does not require making the DSA repository public.

## Files

- `src/trace.mjs`: immutable execution snapshots and displayed Java.
- `src/main.jsx`: linked flowchart, map, array, code, and playback controls.
- `src/style.css`: responsive layout and focus states.
- `scripts/build.mjs`: bundles React, React Flow, styles, and code into standalone HTML.
- `tests/`: trace checks and browser interaction checks.

Keep this first example small before extending the visualizer to other algorithms. Each new algorithm should define its own state and views while reusing playback behavior.
