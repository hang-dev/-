package 算法作业;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex7_最近点对问题 {

	public static void main(String[] args) {
		
		Point[] points = new Point[7];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 9);
		points[2] = new Point(2, 5);
		points[3] = new Point(3, 1);
		points[4] = new Point(4, 4);
		points[5] = new Point(5, 8);
		points[6] = new Point(6, 2);

		// 预处理，基于x轴坐标排序，便于分治法实施
		Arrays.sort(points, new Comparator<Point>() {
			
			@Override
			public int compare(Point p1, Point p2) {
		
				return (p1.x > p2.x) ? 1 : (p1.x == p2.x) ? 0 : -1;
			}
		});

		System.out.println(divide(0, points.length - 1, points));
	}

	private static double divide(int left, int right, Point[] points) {
		// 当前最小两点距离，初始值设置为无穷大
		double curMinDis = 1e20;
		// 如果只有一个点
		if (left == right) {
			return curMinDis;
		}
		if (left + 1 == right) {
			return distance(points[left], points[right]);
		}
		// 分治法：第一步：分区，并求取左右分区最小两点距离
		// 通过右移运算除2，对区域进行合理的划分，使得左右两边保持大致相等个点数
		int middle = (left + right) >> 1;
		double leftMinDis = divide(left, middle, points);
		double rightMinDis = divide(middle, right, points);
		curMinDis = (leftMinDis < rightMinDis) ? leftMinDis : rightMinDis;
		// 分治法第二步，假设距离最近的两点分别在左右居中
		// 关键代码，距离最近的两个点，一个位于左边区域，一个位于右边区域,x轴搜索范围[middle-curMinDis, middle+curMinDis]
		// 记录搜索区间内的点的索引，便于进一步计算最小距离
		List<Integer> validPointIndex = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (Math.abs(points[middle].x - points[i].x) <= curMinDis) {
				validPointIndex.add(i);
			}
		}
		// 基于索引，进一步计算区间最小两点距离
		for (int i = 0; i < validPointIndex.size() - 1; i++) {
			for (int j = i + 1; j < validPointIndex.size(); j++) {
				// 如果区间内两点y轴距离大于curMinDis，则无需计算
				if (Math.abs(points[validPointIndex.get(i)].y - points[validPointIndex.get(j)].y) > curMinDis) {
					continue;
				}
				double tempDis = distance(points[validPointIndex.get(i)], points[validPointIndex.get(j)]);
				curMinDis = (tempDis < curMinDis) ? tempDis : curMinDis;
			}
		}
		return curMinDis;
	}

	private static double distance(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
	}

}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

}
