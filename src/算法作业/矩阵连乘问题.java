package 算法作业;

public class 矩阵连乘问题 {
	
	public static void main(String[] args) {
		//定义了一个储存矩阵维度的数组
		int []p= {1,2,3,4,5,6,7};
		int n=p.length-1;
		//定义一个储存断点的位置
		int [][]s=new int[n+1][n+1];
		//求A1...A6连乘的最小次数
        System.out.println("A1...A6的最小计算量为"+RecurMatrixChain(1,6,p,s));
        Traceback(s,1,6);
	}

	private static int  RecurMatrixChain(int i, int j, int[] p, int[][] s) {
		// TODO Auto-generated method stub
		if(i==j) {
			return 0;
		}
		//取第一个断开位置时计算量为初始值
		int m=RecurMatrixChain(i, i, p,s)+RecurMatrixChain(i+1, j, p,s)+p[i-1]*
				p[i]*p[j];
		//计断点为i
		s[i][j]=i;
		for (int k = i+1; k < j; k++) {
			int temp=RecurMatrixChain(i, k, p,s)+RecurMatrixChain(k+1,j, p,s)+p[i-1]*
					p[k]*p[j];
			//取最小的计算量和当前的断点位置k
			if(temp<m) {
				m=temp;
				s[i][j]=k;
			}
			
		}
		return m;
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