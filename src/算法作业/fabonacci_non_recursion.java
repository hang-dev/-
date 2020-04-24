package 算法作业;

public class fabonacci_non_recursion {
	static int[] f;

	public static void main(String[] args) {
	
      System.out.println("fabonacci数列的第一项："+fabonacci(1) );  
      System.out.println("fabonacci数列的第一项："+fabonacci2(3) );  
	}

	private static int fabonacci2(int n) {
		f=new int[1000];
		int t = 0;
		if(f[n]!=0) {
			return f[n];
		}
		if(n==0){
			t=0;
			}
		if(n==1) {
			t=1;
		}
        if(n>1) {
        	t=fabonacci2(n-1)+fabonacci2(n-2);
        }
        f[n]=t;
		return f[n];
	}

	private static int fabonacci(int n) {
		// TODO Auto-generated method stub
		if(n==1||n==2) {
			return 1;
		}
		int f0,f1,f2 = 0;
		
		f0=f1=1;
		for (int i = 1; i < n; i++) {
			f2=f0+f1;
			f0=f1;
			f1=f2;	
		}
		return f2;
		
	}
}
