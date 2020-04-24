package 算法作业;

public class 矩阵乘法 {

	public static void main(String[] args) {
		int a[][]={{1,2,3},{1,2,3}};
        int b[][]= {{1,1},{1,1},{1,1}};
        int ar=a.length;
        int ac=a[0].length;
        int bc=b[0].length;
        int c[][]=new int[ar][bc];
        for (int i = 0; i <ar; i++) {
        	for (int j = 0; j < bc; j++) {
				for (int k= 0; k < ac; k++) {
					c[i][j]+=a[i][k]*b[k][j];
					
				}
			}
			
		}
        for (int i = 0; i <ar; i++) {
        	for (int j = 0; j < bc; j++) {
        		System.out.print(c[i][j]+" ");
        	}
        	System.out.println();
        }
     }


}
