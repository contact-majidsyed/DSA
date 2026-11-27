import { test, expect } from "@playwright/test";
import { fileURLToPath, pathToFileURL } from "node:url";
const html = pathToFileURL(
  fileURLToPath(new URL("../dist/two-sum.html", import.meta.url)),
).href;

test("next/back/reset keep the code, map and flow in sync; playback stops at return", async ({
  page,
}) => {
  const errors = [];
  page.on("pageerror", (error) => errors.push(error.message));
  await page.setViewportSize({ width: 728, height: 1000 });
  await page.goto(html);
  await expect(
    page.getByRole("heading", { name: "Create an empty map" }),
  ).toBeVisible();
  await expect(page.locator(".react-flow__node")).toHaveCount(7);
  await expect(
    page.getByRole("button", { name: "← Back", exact: true }),
  ).toBeDisabled();
  for (let i = 0; i < 4; i++)
    await page.getByRole("button", { name: "Next →", exact: true }).click();
  await expect(
    page.getByRole("heading", { name: "Store seen.put(2, 0)", exact: true }),
  ).toBeVisible();
  await expect(page.locator(".map-card tbody tr")).toHaveCount(1);
  await expect(page.locator(".map-card tbody td").first()).toHaveText("2");
  await expect(page.locator(".code-line.executing")).toHaveAttribute(
    "data-line",
    "10",
  );
  await expect(page.locator(".flow-box.active strong")).toHaveText(
    "Store value → index",
  );
  await page.getByRole("button", { name: "← Back", exact: true }).click();
  await expect(page.getByText("Empty map", { exact: false })).toBeVisible();
  await expect(page.locator(".code-line.executing")).toHaveCount(3);
  await page.getByLabel("Playback speed").selectOption("700");
  await page.getByRole("button", { name: "▶ Play", exact: true }).click();
  await expect(
    page.getByRole("heading", { name: "Return indices [0, 1]", exact: true }),
  ).toBeVisible({ timeout: 10000 });
  await expect(
    page.getByRole("button", { name: "Next →", exact: true }),
  ).toBeDisabled();
  await expect(page.locator(".array-cell.pair")).toHaveCount(2);
  await expect(page.locator(".map-card tbody tr")).toHaveCount(1);
  await expect(page.locator(".map-card .matched-row")).toHaveCount(1);
  await page.getByRole("button", { name: "Reset", exact: true }).click();
  await expect(page.locator(".step-count")).toHaveText("Step 1 / 9");
  await expect(page.locator(".flow-box.active strong")).toHaveText(
    "Create seen",
  );
  expect(errors).toEqual([]);
});

test("duplicate example and custom invalid/no-answer inputs", async ({
  page,
}) => {
  await page.goto(html);
  await page.getByLabel("Example input").selectOption("1");
  await page.getByLabel("Execution step").fill("8");
  await expect(
    page.getByRole("heading", { name: "Return indices [0, 1]", exact: true }),
  ).toBeVisible();
  await expect(page.locator(".map-card tbody td").first()).toHaveText("3");
  await page.getByText("Try your own numbers", { exact: true }).click();
  await page.getByLabel("Custom array").fill("1,,2");
  await page.getByRole("button", { name: "Use input", exact: true }).click();
  await expect(page.getByRole("alert")).toContainText("comma-separated");
  await page.getByLabel("Custom array").fill("1, 2, 4");
  await page.getByLabel("Custom target").fill("8");
  await page.getByRole("button", { name: "Use input", exact: true }).click();
  await expect(page.getByRole("alert")).toHaveCount(0);
  const max = await page.getByLabel("Execution step").getAttribute("max");
  await page.getByLabel("Execution step").fill(max);
  await expect(
    page.getByRole("heading", { name: "Throw “No pair found”", exact: true }),
  ).toBeVisible();
  await expect(page.locator(".flow-box.active strong")).toHaveText(
    "Throw exception",
  );
  await expect(page.locator(".map-card tbody tr")).toHaveCount(3);
});

test("mobile layout stays within the viewport and flow is visible", async ({
  page,
}) => {
  await page.setViewportSize({ width: 390, height: 844 });
  await page.goto(html);
  await expect(page.locator(".react-flow__node")).toHaveCount(7);
  await page.getByRole("button", { name: "Next →", exact: true }).click();
  await expect(page.locator(".array-cell.current")).toHaveAttribute(
    "data-index",
    "0",
  );
  const overflowing = await page.evaluate(
    () => document.documentElement.scrollWidth > window.innerWidth,
  );
  expect(overflowing).toBe(false);
  await page.locator(".diagram").scrollIntoViewIfNeeded();
  await expect(page.locator(".flow-box.active")).toBeVisible();
});
