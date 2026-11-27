import { build } from "esbuild";
import { readFile, mkdir, writeFile } from "node:fs/promises";
import { fileURLToPath } from "node:url";
import path from "node:path";
const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const result = await build({
  absWorkingDir: root,
  entryPoints: ["src/main.jsx"],
  bundle: true,
  outfile: "dist/app.js",
  write: false,
  minify: true,
  define: { "process.env.NODE_ENV": '"production"' },
  format: "iife",
  target: ["es2020"],
  legalComments: "eof",
});
const js = result.outputFiles.find((f) => f.path.endsWith(".js")).text;
const css = result.outputFiles.find((f) => f.path.endsWith(".css")).text;
const template = await readFile(path.join(root, "src/shell.html"), "utf8");
const html = template
  .replace("/* INLINE_CSS */", () => css)
  .replace("/* INLINE_JS */", () => js.replace(/<\/script/gi, "<\\/script"));
await mkdir(path.join(root, "dist"), { recursive: true });
await writeFile(path.join(root, "dist/two-sum.html"), html);
await writeFile(path.join(root, "dist/index.html"), html);
console.log(
  "Built visualizer/dist/two-sum.html — self-contained, no server or CDN required.",
);
