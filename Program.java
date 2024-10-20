import java.util.*;
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program p = new Program();
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String[] put = a.split(" ");
		int snakes = Integer.parseInt(put[0]);
		int width = Integer.parseInt(put[1]);
		int height = Integer.parseInt(put[2]);
		int [][] output = new int[width][height];
		for(int b=0; b<width;++b) {
			for(int d=0; d<height;++d) {
				output[b][d] = 0;
			}
		}
		String s;
		int j =1;
		for(int u =0;u< snakes; ++u) {
			s = in.nextLine();
			p.drawSnake(s,j,output);
			j=j+1;
		}
		
		for(int r =0; r< output.length;++r) {
			for(int q =0; q< output[r].length;++q) {
				System.out.print(output[r][q] + " ");
			}
			System.out.println();
		}
		

	}
	
	public void drawSnake(String s, int no, int [][] arr) {
		String[] out = s.split(" ");
		for(int i = 0; i< out.length;++i) {
			if (i+1 != out.length) {
			   drawLine(arr,out[i],out[i+1],no);
			}
			
		}
		
	}
	
	public void drawLine(int [][] arr, String one,String two, int no) {
		String [] a = one.split(",");
		String [] b = two.split(",");
		
		// if the y values are equal

		if(Integer.parseInt(a[1]) == Integer.parseInt(b[1])) {
			int min_x = 0;
			int max_x = 0;
			if(Integer.parseInt(a[0]) < Integer.parseInt(b[0])) {
				min_x = Integer.parseInt(a[0]);
				max_x = Integer.parseInt(b[0]);
			}
			else if (Integer.parseInt(a[0]) > Integer.parseInt(b[0])){
				min_x = Integer.parseInt(b[0]);
				max_x = Integer.parseInt(a[0]);
			}
			for(int i =0;i<arr.length;++i) {
				for(int j = 0; j < arr[i].length;++j) {
					int n = Integer.parseInt(a[1]);
					if(i == n && j<= max_x && j >= min_x) {
						arr[n][j] = no;					
					}
				}
				
			}
			
		}
		
		// if the x values are equal
		else if(Integer.parseInt(a[0]) == Integer.parseInt(b[0])) {
			int min_y = 0;
			int max_y = 0;
			if(Integer.parseInt(a[1]) < Integer.parseInt(b[1])) {
				min_y = Integer.parseInt(a[1]);
				max_y = Integer.parseInt(b[1]);
			}
			else if(Integer.parseInt(a[1]) > Integer.parseInt(b[1])) {
				min_y = Integer.parseInt(b[1]);
				max_y = Integer.parseInt(a[1]);
			}
			for(int i =0;i<arr.length;++i) {
				int n = Integer.parseInt(a[0]);
				if(i<= max_y && i >= min_y) {
					arr[i][n] = no;					
				}
			}
		}
		
	}

}
