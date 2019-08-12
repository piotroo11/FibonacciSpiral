package libapp;

import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Dane {

    protected static double delay, spiraltmp;
    protected static int spiralnum;
    protected static long radius1 = 1597, radius2 = 987, radius3 = 0;
    protected static boolean net;

    protected static int count = 0;
    protected static long l = 610;
    protected static int po = 1;
    protected static int pi = -1;
    protected static long x1 = 0;
    protected static long y1 = 610;
    protected static long x2 = 0;
    protected static long y2 = 610;
    protected static int w = 0;
    protected static int h = 0;
    protected static int fi = 90;
    protected static boolean f = false;
    protected static boolean g = false;

    protected static List<Rectangle2D> nets = new ArrayList<Rectangle2D>();
    protected static List<Arc2D> arcs = new ArrayList<Arc2D>();
    protected static List<Rectangle2D> curnets = new ArrayList<Rectangle2D>();
    protected static List<Arc2D> curarcs = new ArrayList<Arc2D>();

    protected static long fibo() {

        radius3 = radius1 - radius2;
        radius1 = radius2;
        radius2 = radius3;
        return radius3;
    }

    protected static void setDefault() {
        radius1 = 1597;
        radius2 = 987;
        radius3 = 0;
        count = 0;
        l = 610;
        po = 1;
        pi = -1;
        x1 = 0;
        y1 = 610;
        x2 = 0;
        y2 = 610;
        w = 0;
        h = 0;
        fi = 90;
        nets.clear();
        arcs.clear();
        curnets.clear();
        curarcs.clear();
    }
}
