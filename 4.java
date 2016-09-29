import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/7448216 */
public class HTMLFractions extends JPanel {

    private static int N = 8;

    public HTMLFractions() {
        this.setLayout(new GridLayout(N, N, N, N));
        this.setBorder(BorderFactory.createEmptyBorder(N, N, N, N));
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                this.add(create(r + N, r + 1, c + 2));
            }
        }
    }

    private JLabel create(int w, int n, int d) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append(w);
        sb.append("<sup>");
        sb.append(n);
        sb.append("</sup>");
        sb.append("<font size=+1>/<font size=-1>");
        sb.append("<sub>");
        sb.append(d);
        sb.append("</sub>");
        sb.append("</html></body>");
        JLabel label = new JLabel(sb.toString(), JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        return label;
    }

    private void display() {
        JFrame f = new JFrame("HTMLFractions");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new HTMLFractions().display();
            }
        });
    }
}
