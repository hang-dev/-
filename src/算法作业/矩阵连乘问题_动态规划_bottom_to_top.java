package 算法作业;

public class 矩阵连乘问题_动态规划_bottom_to_top {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] p = { 1, 2, 3, 4, 5, 6, 7 };
		int n = p.length - 1;
		int m[][] = new int[n + 1][n + 1];
		int s[][] = new int[n + 1][n + 1];
		MatrixChain(m, n, s, p);
		Traceback(s, 1, 2);
	}

	private static void MatrixChain(int m[][], int n, int s[][], int p[]) {
		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;// 对角线上的值均为0
		}
		// 依次从链长为[2:n]递增分别计算不同链长的矩阵连乘最优值
		for (int l = 2; l <= n; l++) {
			// 当计算链长为r时，i的取值范围
			for (int i = 1; i <= n - l + 1; i++) {
				// j与i的关系
				int j = i + l - 1;
				// 先令m[i][j]最优值为矩阵链首元素划分下的值，后再进行对比
				m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				// 3计算k∈[i+1:j-1]递增划分下最优值,并和之前已保存的最优值对比，取小者
				for (int k = i + 1; k < j; k++) {
					int temp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (temp < m[i][j]) {
						m[i][j] = temp;
						s[i][j] = k;
					}
				}
			}

		}
		System.out.println(m[1][n]);
	}

//通过递归的方法找到断点 并加括号
	private static void Traceback(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print("(");
			Traceback(s, i, s[i][j]);
			Traceback(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
}
