package com.wufuqiang.others;

public class Demo3 {
	public static void main(String[] args) {
		double[][] s2i = {
				{10,14,22,18},
				{22,31,18,36},
				{9,24,14,14},
				{0,0,0,0}};
		double[][] i2i = {
				{1,0.9669,0.9081,0.9992},
				{0.9669,1,0.9113,0.9605},
				{0.9081,0.9113,1,0.9183},
				{0.992,0.9605,0.9183,1}
		};
		double sum = 0;
		double[][] res = new double[4][4];
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				for(int k = 0;k<4;k++){
					res[i][j] += s2i[i][k]*i2i[k][j];
				}

			}
		}

		for(int i = 0;i<4;i++){
			for(int j =0;j<4;j++){
				System.out.print(res[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
