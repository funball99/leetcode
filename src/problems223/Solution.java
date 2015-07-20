package problems223;

public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().computeArea(-5, -2, 5, 1, -3, -3, 3, 3));
	}
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int horizon = 0;
        int vertical = 0;
        
        boolean horizonOut = false;
        boolean verticalOut = false;
        
        int bigger = 1;
        boolean sameBigger = false;
        int doubleIn = 0;
        
        //横向
        
        //不相交
        if(C <= E){
        	horizonOut = true;
        }
        
        if(A >= G){
        	horizonOut = true;
        }
        
        //相交
        if(A <= E  && C <= G){
        	
        	horizon = C - E;
        	
        }else if(A >= E && C >= G){
        	
        	horizon = G - A;
        	
        }
        
        
        //包含
        if(E > A  && C > G ){
        	horizon = G - E;
        	doubleIn ++;
        	bigger = 1;
        }else if(E < A  && G > C){
        	horizon = C - A;
        	doubleIn ++;
        	bigger = 2;
        }
    	
    	
    	//纵向
        
        //不相交
        if(D <= F){
        	verticalOut = true;
        }
        
        if(B >= H){
        	verticalOut = true;
        }
        
        //相交
        if(H <= D  && F <= B){
        	
        	vertical = H - B;
        	
        }else if(H >= D && F >= B){
        	
        	vertical = D - F;
        	
        }
        
        
        //包含
        if(D < H  && B > F ){
        	if(bigger == 2){
        		sameBigger = true;
        	}
        	vertical = D - B;
        	doubleIn ++;
        	
        }else if(H < D  && F > B){
        	if(bigger == 1){
        		sameBigger = true;
        	}
        	vertical = H - F;
        	doubleIn ++;
        	
        }
        
        int areaOne = (C-A)*(D-B);
        int areaTwo = (G-E)*(H-F);
        
        
        
        if(doubleIn == 2 && sameBigger){
        	//双向包含
        	return Math.max(areaTwo, areaOne);
        }else if(verticalOut || horizonOut){
        	//不相交
        	return areaTwo + areaOne;
        }else{
        	//相交
        	return areaTwo + areaOne - Math.abs(vertical * horizon);
        }
        
    }
}
