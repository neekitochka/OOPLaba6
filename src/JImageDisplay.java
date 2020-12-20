import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;


public class JImageDisplay extends  JComponent{

    private BufferedImage displayImage;

    public BufferedImage getImage() {
        return displayImage;
    }

    public JImageDisplay(int width, int height){
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Dimension dimImage = new Dimension(width, height);
        this.setPreferredSize(dimImage);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);
    }

    public void clearImage(){
        int[] blankArray = new int[getWidth() * getHeight()];
        displayImage.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }

    public void drawPixel (int x, int y, int rgbColor){
        displayImage.setRGB(x, y, rgbColor);
    }
}
