package libapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel implements ActionListener {

    public DrawPanel() {
        while (Dane.count < Dane.spiralnum & Dane.l > 0) {
            Dane.l = Dane.fibo();
            Dane.count++;
            if (Dane.count % 4 == 1) {
                Dane.po = 1;
                Dane.pi = -1;
                Dane.w = 0;
                Dane.h = 0;
                Dane.fi = 90;
            }
            if (Dane.count % 4 == 2) {
                Dane.po = 1;
                Dane.pi = 1;
                Dane.w = -1;
                Dane.h = 0;
                Dane.fi = 0;
            }
            if (Dane.count % 4 == 3) {
                Dane.po = -1;
                Dane.pi = 1;
                Dane.w = -1;
                Dane.h = -1;
                Dane.fi = 270;
            }
            if (Dane.count % 4 == 0) {
                Dane.po = -1;
                Dane.pi = -1;
                Dane.w = 0;
                Dane.h = -1;
                Dane.fi = 180;
            }

            Dane.x1 = Dane.po * Dane.l + Dane.x2;
            Dane.y1 = Dane.pi * Dane.l + Dane.y2;

            Rectangle2D rectangle = new Rectangle2D.Double();
            rectangle.setFrameFromDiagonal(Dane.x1, Dane.y1, Dane.x2, Dane.y2);
            Dane.nets.add(rectangle);
            Arc2D arc = new Arc2D.Double(rectangle.getMinX() + Dane.w * rectangle.getWidth(), rectangle.getMinY() + Dane.h * rectangle.getHeight(), rectangle.getWidth() * 2, rectangle.getHeight() * 2, Dane.fi, 90, Arc2D.OPEN);
            Dane.arcs.add(arc);

            Dane.x2 = Dane.x1;
            Dane.y2 = Dane.y1;

        }

        if (Dane.delay == 0) {
            repaint();
        }

        Timer timer;

        timer = new Timer((int) (Dane.delay * 1000), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dane.f = true;
                if (Dane.count <= Dane.spiralnum & Dane.count > 0) {
                    repaint();
                    Dane.count--;
                } else {
                    ((Timer) (e.getSource())).stop();
                    Dane.f = false;
                    Dane.setDefault();
                    Dane.g = false;
                }
                if (Dane.g == true) {
                    ((Timer) (e.getSource())).stop();
                    Dane.f = false;
                    Dane.setDefault();
                    Dane.g = false;
                }

            }
        });
        timer.setInitialDelay((int) (Dane.delay * 1000));
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.WHITE);
        if (Dane.net) {
            for (Rectangle2D sp : Dane.nets) {
                if (Dane.count > 0 & Dane.delay != 0) {
                    if (sp == Dane.nets.get(Dane.count - 1)) {
                        Dane.curnets.add(sp);
                    }
                }
                if (Dane.delay == 0) {
                    g2d.draw(sp);
                }
                for (Rectangle2D cursp : Dane.curnets) {
                    g2d.draw(cursp);
                }
            }
        }
        for (Arc2D sp : Dane.arcs) {
            if (Dane.count > 0 & Dane.delay != 0) {
                if (sp == Dane.arcs.get(Dane.count - 1)) {
                    Dane.curarcs.add(sp);
                }
            }
            if (Dane.delay == 0) {
                g2d.draw(sp);
            }
            for (Arc2D cursp : Dane.curarcs) {
                g2d.draw(cursp);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
