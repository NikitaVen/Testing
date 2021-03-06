import java.util.Arrays;


public class Triangle {
    private int[] sides;

    public int getMaxSide() {
        return sides[2];
    }

    public int getMidSide() {
        return sides[1];
    }

    public int getMinSide() {
        return sides[0];
    }

    public int[] gesSides() {
        return sides.clone();
    }

    public boolean IsIsosceles() {
        return sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2];
    }

    public boolean IsEquilateral() {
        return sides[0] == sides[1] && sides[1] == sides[2];
    }

    public boolean IsVersatile() {
        return !IsIsosceles();
    }

    public int Perimeter() throws Exception
    {
        long res =  (long)sides[0] + sides[1] + sides[2];
        if(res > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Perimeter is out of Integer type");
        }
        return (int)res;
    }

    public float Square() throws Exception
    {
        double res = 0.0;
        if (IsEquilateral()){
            res = (double)sides[0] * (double)sides[0]* Math.sqrt(3) / 4;
        }else{
            res = Math.sqrt((double)Perimeter() * (double)(Perimeter() - 2 * sides[0]) * (Perimeter() - 2 * sides[1]) * (Perimeter() - 2 * sides[2])) / 4;
        }
        if(res > Float.MAX_VALUE){
            throw new IllegalArgumentException("Square is out of Float type");
        }
        return (float)res;
    }

    public Triangle(int side_1, int side_2, int side_3) throws Exception {
        if (side_1 <= 0 || side_2 <= 0 || side_3 <= 0){
            throw new IllegalArgumentException("Sides should be positive");
        }
        int res[] = new int[3];
        res[0] = side_1;
        res[1] = side_2;
        res[2] = side_3;
        Arrays.sort(res);
        if (res[2] >= res[1] + res[0])
            throw new IllegalArgumentException("Such a triangle does not exist");
        sides = res;
    }

    @Override
    public String toString() {
        String type;
        if (IsEquilateral()){
            type = "Equilateral";
        }else if (IsIsosceles()){
            type = "Isosceles";
        }else{
            type = "Versatile";
        }
        try {
            return "Triangle{" +
                    "\nsides= " + Arrays.toString(sides) +
                    "\nsquare= " + Square() +
                    "\ntype= " + type +
                    "\nperimeter= " + Perimeter() +
                    "\n}";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
