import React, { memo, useEffect, useMemo, useState } from "react";
import { createRoot } from "react-dom/client";
import {
  ReactFlow,
  Background,
  Handle,
  Position,
  MarkerType,
} from "@xyflow/react";
import "@xyflow/react/dist/style.css";
import "./style.css";
import { buildTrace, EXAMPLES, JAVA, parseInput } from "./trace.mjs";

const FlowNode = memo(({ data }) => (
  <div className={`flow-box ${data.active ? "active" : ""}`}>
    <Handle type="target" id="top" position={Position.Top} />
    {["visit", "throw"].includes(data.id) && (
      <Handle type="target" id="left" position={Position.Left} />
    )}
    <span className="flow-kicker">{data.tag}</span>
    <strong>{data.label}</strong>
    <Handle type="source" id="bottom" position={Position.Bottom} />
    {data.id === "store" && (
      <Handle type="source" id="left" position={Position.Left} />
    )}{" "}
    {data.id === "visit" && (
      <Handle type="source" id="right" position={Position.Right} />
    )}
  </div>
));
const nodeTypes = { lesson: FlowNode };
const layout = [
  ["init", 110, 0, "01 · SETUP", "Create seen"],
  ["visit", 110, 78, "02 · LOOP", "More elements?"],
  ["need", 110, 156, "03 · CALCULATE", "need = target − value"],
  ["lookup", 110, 234, "04 · DECISION", "Is need in seen?"],
  ["store", 0, 330, "05 · SAVE", "Store value → index"],
  ["return", 220, 330, "06 · DONE", "Return the two indices"],
  ["throw", 330, 78, "NO ANSWER", "Throw exception"],
];
const connections = [
  ["init", "visit", ""],
  ["visit", "need", "yes"],
  ["need", "lookup", ""],
  ["lookup", "store", "no"],
  ["lookup", "return", "yes"],
  ["store", "visit", "i++"],
  ["visit", "throw", "no"],
];
function Flow({ step, previous }) {
  const phase = step.phase === "exhausted" ? "visit" : step.phase;
  const prev = previous?.phase === "exhausted" ? "visit" : previous?.phase;
  const nodes = layout.map(([id, x, y, tag, label]) => ({
    id,
    type: "lesson",
    position: { x, y },
    draggable: false,
    selectable: false,
    data: { id, tag, label, active: id === phase },
    style: { width: 172 },
  }));
  const edges = connections.map(([source, target, label]) => {
    const active = source === prev && target === phase;
    return {
      id: `${source}-${target}`,
      source,
      target,
      label,
      type: "smoothstep",
      animated: active,
      sourceHandle:
        source === "store" ? "left" : target === "throw" ? "right" : "bottom",
      targetHandle: target === "throw" || source === "store" ? "left" : "top",
      markerEnd: {
        type: MarkerType.ArrowClosed,
        color: active ? "var(--primary)" : "var(--muted-foreground)",
      },
      style: {
        stroke: active ? "var(--primary)" : "var(--border)",
        strokeWidth: active ? 2.5 : 1.4,
      },
      labelStyle: { fill: "var(--foreground)", fontSize: 12, fontWeight: 650 },
      labelBgStyle: { fill: "var(--card)" },
      labelBgPadding: [5, 3],
      pathOptions: { offset: source === "store" ? 35 : 18 },
    };
  });
  return (
    <div className="diagram" aria-label={`Flowchart: ${step.title}`}>
      <ReactFlow
        nodes={nodes}
        edges={edges}
        nodeTypes={nodeTypes}
        fitView
        fitViewOptions={{ padding: 0.12 }}
        minZoom={0.35}
        maxZoom={1.5}
        nodesConnectable={false}
        nodesFocusable={false}
        edgesFocusable={false}
        panOnDrag={false}
        zoomOnScroll={false}
        zoomOnPinch={false}
        zoomOnDoubleClick={false}
        preventScrolling={false}
      >
        <Background color="var(--border)" gap={18} size={1} />
      </ReactFlow>
    </div>
  );
}
function App() {
  const [input, setInput] = useState(EXAMPLES[0]),
    [selected, setSelected] = useState("0");
  const [position, setPosition] = useState(0),
    [playing, setPlaying] = useState(false),
    [speed, setSpeed] = useState(1500);
  const [arrayText, setArrayText] = useState("2, 7, 11, 15"),
    [targetText, setTargetText] = useState("9"),
    [error, setError] = useState("");
  const steps = useMemo(() => buildTrace(input.nums, input.target), [input]);
  const step = steps[position],
    last = position === steps.length - 1;
  useEffect(() => {
    if (!playing) return;
    if (last) {
      setPlaying(false);
      return;
    }
    const timer = setTimeout(() => setPosition((p) => p + 1), speed);
    return () => clearTimeout(timer);
  }, [playing, last, position, speed]);
  function jump(next) {
    setPlaying(false);
    setPosition(Math.max(0, Math.min(steps.length - 1, next)));
  }
  function choose(e) {
    const index = e.target.value,
      value = EXAMPLES[Number(index)];
    setSelected(index);
    setPlaying(false);
    setPosition(0);
    setError("");
    setInput(value);
    setArrayText(value.nums.join(", "));
    setTargetText(String(value.target));
  }
  function apply(e) {
    e.preventDefault();
    setPlaying(false);
    try {
      const next = parseInput(arrayText, targetText);
      setInput(next);
      setPosition(0);
      setSelected("custom");
      setError("");
    } catch (e) {
      setError(e.message);
    }
  }
  return (
    <main>
      <header className="intro">
        <div className="eyebrow">
          ARRAYS & HASHMAPS <span>/</span> CODE WALKTHROUGH
        </div>
        <div className="title-row">
          <h1>Two Sum</h1>
          <span className="badge">Java · HashMap</span>
        </div>
        <p>
          Find two indices whose values add up to the target. Watch what the map
          remembers—and when the code uses it.
        </p>
      </header>
      <section className="setup" aria-label="Choose input">
        <div className="example-select">
          <label htmlFor="example">Example input</label>
          <select id="example" value={selected} onChange={choose}>
            {EXAMPLES.map((example, i) => (
              <option value={i} key={i}>
                {example.label}
              </option>
            ))}
            {selected === "custom" && (
              <option value="custom">Your input</option>
            )}
          </select>
        </div>
        <details>
          <summary>Try your own numbers</summary>
          <form onSubmit={apply}>
            <label>
              Array
              <input
                aria-label="Custom array"
                value={arrayText}
                onChange={(e) => setArrayText(e.target.value)}
              />
            </label>
            <label>
              Target
              <input
                aria-label="Custom target"
                value={targetText}
                onChange={(e) => setTargetText(e.target.value)}
              />
            </label>
            <button type="submit">Use input</button>
          </form>
          <p className="helper">
            Up to 12 integers. If no pair exists, follow the exception path.
          </p>
          {error && (
            <p className="error" role="alert">
              {error}
            </p>
          )}
        </details>
      </section>
      <section className="playback" aria-label="Playback controls">
        <div className="buttons">
          <button
            onClick={() => jump(0)}
            disabled={position === 0 && !playing}
            aria-label="Reset"
          >
            ↺ Reset
          </button>
          <button onClick={() => jump(position - 1)} disabled={position === 0}>
            ← Back
          </button>
          <button
            className="play"
            onClick={() => {
              if (last) setPosition(0);
              setPlaying((p) => !p);
            }}
          >
            {playing ? "Ⅱ Pause" : "▶ Play"}
          </button>
          <button
            className="next"
            onClick={() => jump(position + 1)}
            disabled={last}
          >
            Next →
          </button>
        </div>
        <div className="timeline">
          <span className="step-count">
            Step {position + 1} / {steps.length}
          </span>
          <input
            aria-label="Execution step"
            type="range"
            min="0"
            max={steps.length - 1}
            value={position}
            onChange={(e) => jump(Number(e.target.value))}
          />
          <select
            aria-label="Playback speed"
            value={speed}
            onChange={(e) => setSpeed(Number(e.target.value))}
          >
            <option value={2500}>Slow</option>
            <option value={1500}>Normal</option>
            <option value={700}>Fast</option>
          </select>
        </div>
      </section>
      <section
        className={`step-note ${step.phase === "return" ? "complete" : ""}`}
        aria-live="polite"
        aria-atomic="true"
      >
        <div className="note-top">
          <span className="phase">
            {step.phase === "return"
              ? "ANSWER FOUND"
              : step.phase.toUpperCase()}
          </span>
          <span className="line-tag">
            Java {step.lines.length > 1 ? "lines" : "line"}{" "}
            {step.lines.join(", ")}
          </span>
        </div>
        <h2>{step.title}</h2>
        <p>{step.detail}</p>
      </section>
      <div className="state-grid">
        <section className="card array-card">
          <div className="card-heading">
            <h2>The array</h2>
            <span className="target">
              target <b>{input.target}</b>
            </span>
          </div>
          <div className="array" aria-label="Input array">
            {input.nums.map((value, index) => {
              const current = index === step.i,
                matched = index === step.matchIndex,
                pair = step.pair?.includes(index);
              return (
                <div
                  key={index}
                  className={`array-cell ${current ? "current" : ""} ${matched ? "matched" : ""} ${pair ? "pair" : ""}`}
                  data-index={index}
                >
                  <span className="pointer">
                    {current ? "i ↓" : matched ? "found ↓" : "\u00a0"}
                  </span>
                  <strong>{value}</strong>
                  <span className="index">index {index}</span>
                </div>
              );
            })}
          </div>
          <div className="variables">
            <div>
              <span>
                i <small>index</small>
              </span>
              <b>{step.i ?? "—"}</b>
            </div>
            <div>
              <span>
                nums[i] <small>value</small>
              </span>
              <b>{step.value ?? "—"}</b>
            </div>
            <div className={step.need !== null ? "need" : ""}>
              <span>
                need <small>partner</small>
              </span>
              <b>{step.need ?? "—"}</b>
            </div>
          </div>
          <p className="helper">
            Blue marks the current index. Green marks the earlier match.
          </p>
        </section>
        <section className="card map-card">
          <div className="card-heading">
            <h2>
              <code>seen</code> <span>HashMap</span>
            </h2>
            <span className="badge">
              {step.entries.length}{" "}
              {step.entries.length === 1 ? "entry" : "entries"}
            </span>
          </div>
          <table aria-label="Map contents">
            <thead>
              <tr>
                <th>
                  Key <small>number</small>
                </th>
                <th></th>
                <th>
                  Value <small>earlier index</small>
                </th>
              </tr>
            </thead>
            <tbody>
              {step.entries.length === 0 ? (
                <tr>
                  <td colSpan="3" className="empty-map">
                    Empty map<span>No number stored yet</span>
                  </td>
                </tr>
              ) : (
                step.entries.map((entry) => (
                  <tr
                    key={entry.value}
                    className={
                      entry.value === step.stored
                        ? "inserted"
                        : entry.index === step.matchIndex
                          ? "matched-row"
                          : ""
                    }
                  >
                    <td>{entry.value}</td>
                    <td className="arrow">→</td>
                    <td>
                      {entry.index}
                      {entry.value === step.stored && (
                        <span className="row-label">
                          {step.previousIndex === null ? "added" : "updated"}
                        </span>
                      )}
                      {entry.index === step.matchIndex && (
                        <span className="row-label">match</span>
                      )}
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
          <p className="map-rule">
            <b>Look up first. Store second.</b>
            <br />
            This prevents using the same index twice.
          </p>
        </section>
      </div>
      <div className="execution-grid">
        <section className="card flow-card">
          <div className="card-heading">
            <h2>Follow the flow</h2>
            <span className="live-key">
              <i /> Active stage
            </span>
          </div>
          <Flow step={step} previous={steps[position - 1]} />
          <p className="helper">
            The highlighted box follows the highlighted Java line. The moving
            edge shows the latest transition.
          </p>
        </section>
        <section className="card code-card">
          <div className="card-heading">
            <h2>The Java code</h2>
            <span className="badge">Read only</span>
          </div>
          <div className="code" aria-label="Java source code">
            {JAVA.map((line, i) => (
              <div
                key={i}
                className={`code-line ${step.lines.includes(i + 1) ? "executing" : ""}`}
                data-line={i + 1}
                aria-current={step.lines.includes(i + 1) ? "step" : undefined}
              >
                <span className="line-number">{i + 1}</span>
                <code>{line || " "}</code>
              </div>
            ))}
          </div>
          <p className="helper">
            Highlight = the statement represented by this step. Assignments show
            their values after execution.
          </p>
        </section>
      </div>
      <footer>
        <a
          href="https://github.com/contact-majidsyed/DSA/blob/main/solutions/01-arrays-and-hashmaps/two-sum/question.md"
          target="_blank"
          rel="noreferrer"
        >
          Question on GitHub ↗
        </a>
        <a
          href="https://github.com/contact-majidsyed/DSA/blob/main/solutions/01-arrays-and-hashmaps/two-sum/SolutionDebug.java"
          target="_blank"
          rel="noreferrer"
        >
          Commented Java walkthrough ↗
        </a>
        <span>Built with React Flow</span>
      </footer>
    </main>
  );
}
createRoot(document.getElementById("root")).render(<App />);
