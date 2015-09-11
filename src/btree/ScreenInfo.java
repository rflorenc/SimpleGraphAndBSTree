package btree;

import graph.Point;


public class ScreenInfo implements Comparable {

    private char division;
    private Point point;

    public ScreenInfo(char division, Point point) {
        this.division = division;
        this.point = point;
    }

    public int compareTo(Object o) {
        if (o instanceof ScreenInfo) {
            ScreenInfo info = (ScreenInfo) o;
            System.out.println(""+info);
            System.out.println("InfoPainel - compareTo(): this = " + this + " & info = " + info);
            division= info.getDivision();
            System.out.println(""+division);
        

            if (division == 'H') {
                // Compare y
                double r = point.distanceY(info.getPoint());
                System.out.println("ScreenInfo - compareTo(): r = " + r);
                if (r < 0) {
                    return -1;
                } else if (r > 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (division == 'V') {
                // Compare x
                double r = point.distanceX(info.getPoint());
                System.out.println("ScreenInfo - compareTo(): r = " + r);
                if (r < 0) {
                    return -1;
                } else if (r > 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                System.out.println();
                System.out.println("Info Exception - not able to compare leaf node!!");
                return -999;
            }
        }
        System.out.println();
        System.out.println("Info Exception - not able to compare non ScreenInfo objects!!");
        return -999;
    }

    public char getDivision() {
        return division;
    }

    public void setDivision(char division) {
        this.division = division;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "ScreenInfo@(" + this.division + ", " + this.point.toString() + ")";
    }
}
