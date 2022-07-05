public class EditDistnceProblem {

    public static int editDistanceTabulation(String first, String second, int m, int n) {
        int matrix[][] = new int[m + 1][n + 1];
        // filling the first row...
        for (int i = 0; i <= n; i++) {
            matrix[0][i] = i;
        }
        // filling the firts column
        for (int i = 0; i <= m; i++) {
            matrix[i][0] = i;
        }
        // now perform operation
        int a=0;
        int b=0;
        int c=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i-1) != second.charAt(j-1)) {
                    a = matrix[i - 1][j - 1];
                    b = matrix[i - 1][j];
                    c = matrix[i][j - 1];
                    matrix[i][j] = Math.min(Math.min(a, b), c)+1;
                }
                else{
                    a = matrix[i - 1][j - 1];
                    b = matrix[i - 1][j];
                    c = matrix[i][j - 1];
                    matrix[i][j] = Math.min(Math.min(a, b), c);
                }
            }
        }

        for (int[] is : matrix) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int findOperations(String first, String second, int m, int n) {

        // termination case..........
        if (m == 0) {// if m gets exhausted just return n as the steps that will be required now are
                     // m.....
            return n;
        }
        if (n == 0) {// if n gets replaced then return m as the steps that will be required now
                     // are....
            return m;
        }

        // if the given current character matches.....
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            return findOperations(first, second, m - 1, n - 1);
        }
        // if the current characters do not get matched
        int a = findOperations(first, second, m - 1, n);// insert
        int b = findOperations(first, second, m, n - 1);// remove
        int c = findOperations(first, second, m - 1, n - 1);// replace

        int min = Math.min(Math.min(a, b), c);
        return 1 + min;

    }

    public static void main(String[] args) {

     //   dbb fdfaccddfac
        String first = "dbb";
        String second = "fdfaccddfac";
        System.out.println(findOperations(first, second, first.length(), second.length()));
        editDistanceTabulation(first, second, first.length(), second.length());

    }
}
