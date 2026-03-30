package EDSxADS_Final_Project;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class WeeklyColumnChart extends JPanel {

    private int[] values = {281, 159, 238, 300, 167, 227, 67}; //sample values
    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public WeeklyColumnChart() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int barWidth = width / values.length;

        int max = 0;
        for (int v : values) {
            if (v > max) max = v;
        }

        for (int i = 0; i < values.length; i++) {
            int barHeight = (int) ((double) values[i] / max * (height - 50));

            int x = i * barWidth + 10;
            int y = height - barHeight - 30;

            g.setColor(new Color(34, 139, 34));
            g.fillRect(x, y, barWidth - 20, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(days[i], x + 10, height - 10);
            g.drawString(String.valueOf(values[i]), x + 10, y - 5);
        }
    }

    // Optional: update data later
    public void setValues(int[] newValues) {
        this.values = newValues;
        repaint();
    }
}
