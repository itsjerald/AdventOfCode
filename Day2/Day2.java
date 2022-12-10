package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
    private static final int win = 6;
    private static final int draw = 3;
    private static final int lose = 0;

    private static final int rock = 1;
    private static final int paper = 2;
    private static final int scissors = 3;



    public static void main(String[] args) throws Exception {
        HashMap shapes = new HashMap();

        shapes.put("A",rock);
        shapes.put("B",paper);
        shapes.put("C",scissors);

        shapes.put("X",rock);
        shapes.put("Y",paper);
        shapes.put("Z",scissors);


        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("D:\\mypmp\\scr\\java\\AdventOfCode\\Day2\\Input.txt"));
            String line = null;
            ArrayList<String> P2 = new ArrayList<String>();

            int scorePartA = 0;
            int scorePartB = 0;
            while ((line = reader.readLine()) != null)
            {
                String[] str = line.split(" ");

                scorePartA += (int)shapes.get(str[1]); // Adding my shape score.
                if(shapes.get(str[0]) == shapes.get(str[1]))
                {
                    scorePartA += draw;//draw
                } else if (rock == (int)shapes.get(str[0]) && paper == (int)shapes.get(str[1]) ) { // win cases.
                    scorePartA+=win;//win
                }
                else if (paper == (int)shapes.get(str[0]) && scissors == (int)shapes.get(str[1]) ) { // win cases.
                    scorePartA+=win;//win
                }
                else if (scissors == (int)shapes.get(str[0]) && rock == (int)shapes.get(str[1]) ) { // win cases.
                    scorePartA+=win;//win
                }
                else if (scissors == (int)shapes.get(str[0]) && paper == (int)shapes.get(str[1]) ) { // lose cases.
                    scorePartA+= lose;//lose
                }
                else if (rock == (int)shapes.get(str[0]) && scissors == (int)shapes.get(str[1]) ) { // lose cases.
                    scorePartA+= lose;//lose
                }
                else if (paper == (int)shapes.get(str[0]) && rock == (int)shapes.get(str[1]) ) { // lose cases.
                    scorePartA+= lose;//lose
                }

                // Adding my shape score, to win, draw or lose expected shape score is added here.
                if("X".equals(str[1])) //to lose
                {
                    scorePartB += lose;
                    if (rock == (int)shapes.get(str[0]))
                    {
                        scorePartB += scissors;
                    } else if (paper == (int) shapes.get(str[0])) {
                        scorePartB += rock;
                    }
                    else if (scissors == (int) shapes.get(str[0])) {
                        scorePartB += paper;
                    }
                } else if ("Y".equals(str[1])) { //to draw
                    scorePartB += draw;
                    scorePartB += (int)shapes.get(str[0]);
                }
                else if ("Z".equals(str[1])) { //to win
                    scorePartB += win;
                    if (rock == (int)shapes.get(str[0]))
                    {
                        scorePartB += paper;
                    } else if (paper == (int) shapes.get(str[0])) {
                        scorePartB += scissors;
                    }
                    else if (scissors == (int) shapes.get(str[0])) {
                        scorePartB += rock;
                    }
                }
            }
            System.out.println("Total Score Part A: "+scorePartA);
            System.out.println("Total Score Part B: "+scorePartB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
