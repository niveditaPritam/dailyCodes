class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr=new int[m][n];
        for(int[] l:walls)arr[l[0]][l[1]]=-1;
        for(int[] l:guards)arr[l[0]][l[1]]=-1;
        for(int[] l:guards)populate(l[0],l[1],arr);
        int ans=0;
        for(int[] k:arr){
            for(int a:k)if(a==0)ans++;
        } 
        return ans;
    }
    private void populate(int a, int b, int[][] arr){
        for(int i=a-1; i>=0; i--){
            if(arr[i][b]<0 && i!=a)break;
            else arr[i][b]=1;
        }
        for(int i=a+1; i<arr.length; i++){
            if(arr[i][b]<0 && i!=a)break;
            else arr[i][b]=1;
        }
        for(int i=b-1; i>=0; i--){
            if(arr[a][i]<0 && i!=b)break;
            else arr[a][i]=1;
        }
        for(int i=b+1; i<arr[0].length; i++){
            if(arr[a][i]<0 && i!=b)break;
            else arr[a][i]=1;
        }
    }
}
