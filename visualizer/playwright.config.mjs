import { defineConfig } from "@playwright/test";
export default defineConfig({
  testDir: "./tests",
  testMatch: "**/*.spec.mjs",
  fullyParallel: false,
  use: {
    headless: true,
    launchOptions: process.env.DSA_CHROME_PATH
      ? { executablePath: process.env.DSA_CHROME_PATH }
      : {},
  },
});
