package AlgorithmTest.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16985Maaaaaaze {
	static boolean map[][][][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int ans = Integer.MAX_VALUE;
	static Queue<Node> q;
	static int step[][] = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	private static class Node {
		int dep, i, j, cnt;

		public Node(int dep, int i, int j, int cnt) {
			this.dep = dep;
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	// 5*5 5floor
	public static void main(String[] args) {
		input();
		// displayMap();
		/**
		 * 1층당 rotate할 수 있는 경우의 수는 4가지
		 * 
		 */
		// rot 0-3 floor 0-4
		int info[] = new int[5];
		rec(0, info);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	static void rec(int dep, int info[]) {
		if (dep == 5) {
			if (map[0][info[0]][0][0]) {
				for (int i = 0; i < 5; ++i) {
					System.out.print(info[i] + " ");
				}
				System.out.println();
				solve(info);
			}
			return;
		}
		for (int x = 0; x <= 3; ++x) {
			System.out.println("Dep : " + dep + " x : " + x );
			info[dep] = x;
			rec(dep + 1, info);
		}

	}

	private static void solve(int info[]) {
		// 1. rotate 경우의 수를 모두 다 고려
		// 2. 최소 이동수를 구해야 하기 때문에 bfs로 접근?
		q = new LinkedList<Node>();

		q.add(new Node(0, 0, 0, 0));
		boolean isVisited[][][] = new boolean[5][5][5];
		isVisited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node t = q.poll();
			int dep = t.dep;
			int ni = t.i, nj = t.j;
			if (dep == 4 && ni == 4 && nj == 4) {
				System.out.println(dep + " " + ni + " " + nj + " " + t.cnt);
				if (t.cnt < ans)
					ans = t.cnt;
				break;
			}

			if (t.cnt >= ans)
				continue;

			if (dep < 4 && map[dep + 1][info[dep + 1]][ni][nj] && !isVisited[dep + 1][ni][nj]) {
				q.add(new Node(dep + 1, ni, nj, t.cnt + 1));
				isVisited[dep + 1][ni][nj] = true;
			}
			for (int x = 0; x < step.length; ++x) {
				int ti = ni + step[x][0], tj = nj + step[x][1];
				if (ti >= 0 && ti <= 4 && tj >= 0 && tj <= 4 && map[dep][info[dep]][ti][tj]
						&& !isVisited[dep][ti][tj]) {
					q.add(new Node(dep, ti, tj, t.cnt + 1));
					isVisited[dep][ti][tj] = true;
				}
			}
		}

	}

	private static void displayMap() {
		for (int x = 0; x <= 3; ++x) {
			System.out.println("rotate : " + x);
			for (int k = 0; k <= 4; ++k) {
				for (int i = 0; i <= 4; ++i) {
					for (int j = 0; j <= 4; ++j) {
						if (map[k][x][i][j]) {
							System.out.print("1 ");
						} else {
							System.out.print("0 ");
						}
					}
					System.out.println();
				}
				System.out.println();
			}

		}
	}

	private static void input() {
		map = new boolean[5][4][5][5];

		for (int i = 0; i <= 4; ++i) {
			for (int j = 0; j <= 4; ++j) {
				try {
					String str = br.readLine();
					// System.out.println(str);
					String in[] = str.split(" ");
					for (int k = 0; k <= 4; ++k) {
						if (Integer.parseInt(in[k]) == 1) {
							map[i][0][j][k] = true;
							// rotate
							/**
							 * i > j swap (i, j) --> 4-j i < j swap (i, j) --> 4-j
							 */
							int ti = j, tj = k;
							for (int x = 1; x <= 3; ++x) {
								map[i][x][tj][4 - ti] = true;
								int t = tj;
								tj = 4 - ti;
								ti = t;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
