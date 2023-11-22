import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Simple2DGame extends JFrame {

    private int playerX = 50;
    private int playerY = 50;

    public Simple2DGame() {
        setTitle("Simple 2D Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up a game loop using a Timer
        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();

        // Set up key listener for player movement
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Handle key released events if needed
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Handle key typed events if needed
            }
        });

        setFocusable(true);
    }

    private void update() {
        // Update game logic here
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                playerX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 5;
                break;
            case KeyEvent.VK_UP:
                playerY -= 5;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 5;
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the player
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 20, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Simple2DGame game = new Simple2DGame();
                game.setVisible(true);
            }
        });
    }
}
