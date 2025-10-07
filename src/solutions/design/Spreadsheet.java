package solutions.design;


/*
3484: Design Spreadsheet [MEDIUM]
 */

public class Spreadsheet {
    int rows = 0;
    int COLS = 26;
    int[][] spreadsheet;

    private int[] getInp(String strInp) {
        int[] inp = new int[2];
        char[] charInp = strInp.toCharArray();
        inp[0] = Integer.parseInt(strInp.substring(1)) - 1;
        inp[1] = (int) charInp[0] - 65;
        return inp;
    }

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.spreadsheet = new int[rows][COLS];
    }

    public void setCell(String cell, int value) {
        int[] inp = this.getInp(cell);
        this.spreadsheet[inp[0]][inp[1]] = value;
    }

    public void resetCell(String cell) {
        int[] inp = this.getInp(cell);
        this.spreadsheet[inp[0]][inp[1]] = 0;
    }

    public int getValue(String formula) {
        String expression = formula.substring(1);
        String[] formulaArray= expression.split("\\+");
        String firstVar = formulaArray[0], secondVar = formulaArray[1];
        int firstValue, secondValue;
        if (Character.isAlphabetic(firstVar.toCharArray()[0])) {
            int[] cellIdx = getInp(firstVar);
           firstValue = this.spreadsheet[cellIdx[0]][cellIdx[1]];
        } else {
            firstValue = Integer.parseInt(firstVar);
        }
        if (Character.isAlphabetic(secondVar.toCharArray()[0])) {
            int[] cellIdx = getInp(secondVar);
            secondValue = this.spreadsheet[cellIdx[0]][cellIdx[1]];
        } else {
            secondValue = Integer.parseInt(secondVar);
        }
        return firstValue + secondValue;
    }

    public static void main(String[] args) {
        Spreadsheet s = new Spreadsheet(530);
        System.out.println(s.getValue("=29483+15079"));
        System.out.println(s.getValue("=A333+A135"));
        System.out.println(s.getValue("=J215+P337"));
        s.resetCell("F241");
        s.setCell("Y104", 2018);
        s.setCell("O71", 2353);
        System.out.println(s.getValue("=Y104+O71"));
        System.out.println(s.getValue("=73100+39834"));
        s.setCell("Y118", 58058);
        System.out.println(s.getValue("=O71+Y104"));
        s.resetCell("O71");
        s.resetCell("Y118");
        System.out.println(s.getValue("=F254+J85"));
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
