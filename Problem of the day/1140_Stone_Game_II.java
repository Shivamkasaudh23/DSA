

// Recurrsion code 

class Solution {
    int n =0;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        return solveForAlice(piles, 1, 0, 1);
    }

// i indicates the index
    int solveForAlice(int [] piles, int person, int i, int M){
        if( i >= n) return 0;

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1; x<= Math.min(2*M,n-i); x++){
            stones += piles[i+x-1];

            if(person == 1){
                result = Math.max(result, stones+solveForAlice(piles,0,i+x,Math.max(M,x)));
            }
            else{
                result = Math.min(result, solveForAlice(piles,1,i+x,Math.max(M,x)));
            }
        }
        return result;
    }
}



// Memoization Code 

class Solution {
    int n =0;
    int arr [][][];
    public int stoneGameII(int[] piles) {
        n = piles.length;
        arr = new int[2][n+1][n+1];
        for(int[][] matrix : arr){
            for(int[] row : matrix){
                Arrays.fill(row,-1);
            }
        }
        return solveForAlice(piles, 1, 0, 1);
    }

// i indicates the index
    int solveForAlice(int [] piles, int person, int i, int M){
        if( i >= n) return 0;

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        if(arr[person][i][M] != -1){
            return arr[person][i][M];
        }

        for(int x=1; x<= Math.min(2*M,n-i); x++){
            stones += piles[i+x-1];

            if(person == 1){
                result = Math.max(result, stones+solveForAlice(piles,0,i+x,Math.max(M,x)));
            }
            else{
                result = Math.min(result, solveForAlice(piles,1,i+x,Math.max(M,x)));
            }
        }
        return arr[person][i][M] = result;
    }
}

