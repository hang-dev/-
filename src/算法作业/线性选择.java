package 算法作业;

public class 线性选择 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 2, 8, 4, 6 };
		System.out.println(randomizedSelect(a, 0, a.length - 1, 5));

	}

	private static int randomizedSelect(int[] a, int left, int right, int k) {
		// TODO Auto-generated method stub
		if (left == right) {
			return a[left];
		}
		// 获取为基准的随机元素的下标
		int i = randomizedPartition(a, left, right);
		// j为划分后左序列到基准（包含基准）的元素个数
		int j = i - left + 1;
		if (k < j)
			return randomizedSelect(a, left, i - 1, k);
		else if (k == j)
			return a[i];
		else // k大于j说明在i的右边序列
			return randomizedSelect(a, i+1, right, k - j);

	}

	private static int randomizedPartition(int[] a, int left, int right) {
		int i=left,j=right;
		int tmp=a[i];
		while(i<j) {
			while(j>=tmp&&i<j) {
				j--;
			}
			while(i<=tmp&&i<j) {
				i++;
			}
			if (i < j) {
				swap(a, i, j);
			}
		}
		//最后将基准为与i和j相等位置的数字交换
		swap(a,left,i);
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
