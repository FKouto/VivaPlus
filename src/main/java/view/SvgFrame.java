package view;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

public class SvgFrame extends JLabel {
    private FlatSVGIcon svgIcon;
    public void setBackgroundFrame(String image, int width, int height){
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
}
