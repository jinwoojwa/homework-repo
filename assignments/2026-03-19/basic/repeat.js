export function repeat(n, f) {
  for (let i = 0; i < n; ++i) {
    f(i);
  }
}
