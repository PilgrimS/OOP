package newcoder;

class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}

public class Solution0003 {
	public static int maxPoints(Point[] points) {
        int len = points.length;
        int max = 0;
        if(len == 0) return 0;
        if(len == 1) return 1;
        if(len == 2) return 2;
		for(int i = 0 ; i <len ; i++){
			for(int j = i+1 ; j < len ;j++){
		        int count = 0;
				float xCompare = points[i].x - points[j].x;
				float yCompare = points[i].y - points[j].y;
				if(yCompare == 0 ){
					for(Point p : points){
						if(p.y == points[i].y) count++;
					}
					if(count > max ) max =count;
				}else if(xCompare == 0){
					for(Point p : points){
						if(p.x == points[i].x) count++;
					}
					if (count > max) max = count;
				}else if(xCompare != 0 && yCompare != 0){
					/*k = yCompare / xCompare;
					b = points[i].y - k * points[i].x;*/
					for(Point p : points){
						if(points[j].x == p.x && points[j].y-p.y == 0 ) count++;
						else if(points[j].x == p.x && points[j].y-p.y != 0){}
						else if((float)(points[i].y - points[j].y)/(points[i].x -points[j].x) == (float)(points[j].y-p.y)/(points[j].x-p.x)) count++;
					}
					if (count > max) max = count;
				}
			}
		}
		
		return max;
    }
	public static void main(String[] args) {
		Point[] points = {new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
		System.out.println(maxPoints(points));
		
		float x = 1/3*3;
		int i = 1;
		float y = 4/3-1;
		System.out.println(x == i);
	}
}
