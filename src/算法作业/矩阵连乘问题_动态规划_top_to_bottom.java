package 算法作业;

public class 矩阵连乘问题_动态规划_top_to_bottom {

	public static void main(String[] args) {
		int[] p = { 5,10,15,20 };
		int n = p.length - 1;

		int[][] m = new int[n + 1][n + 1];
		int[][] s = new int[n + 1][n + 1];
		System.out.println("最小计算量为"+MatrixChain(1, 3, m, s,p));
		Traceback(s,1,3);
	}



	private static int MatrixChain(int i, int j, int[][] m, int[][] s, int[] p) {
		//如果二维数组中已经存在我们要找的值则返回
		if (m[i][j] != 0) {
			return m[i][j];
		} else {
			if (i == j) {
				m[i][j] = 0;
			}
			if (j > i) {
				//取第一个断开位置时计算量为初始值
				m[i][j]=MatrixChain(i, i, m, s,p)+MatrixChain(i+1, j, m, s, p)+p[i-1]*
						p[i]*p[j];
				s[i][j]=i;
                for (int k = i+1; k < j; k++) {
					int t=MatrixChain(i, k, m, s,p)+MatrixChain(k+1, j, m, s, p)+p[i-1]*
							p[k]*p[j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
		}
		return m[i][j];
	}
	private static void Traceback(int[][] s, int i, int j) {
		if(i==j) {
			System.out.print("A"+i);
		}
		else {
        System.out.print("(");
        Traceback(s, i, s[i][j]);
		Traceback(s,s[i][j]+1,j);
		System.out.print(")");
		}
	}

}
