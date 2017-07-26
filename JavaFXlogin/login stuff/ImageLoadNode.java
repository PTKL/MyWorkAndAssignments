import javafx.ui.canvas.*;
import javafx.ui.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

class ImageLoadNode extends CompositeNode {
    attribute url: String;
}

function ImageLoadNode.composeNode() = 
Group {
    content:
    [View {
        content: Button {
            cursor: DEFAULT
            text: "Browse"
            action: operation() {
                var fc = new JFileChooser();
                var filter = new FileNameExtensionFilter("Images", ["jpg", "gif", "png"]);
                fc.setFileFilter(filter);
                var returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    url = fc.getSelectedFile().toURL().toString();
                }
            }
        }
    },
    View {
        transform: translate(68, 2)
        content: TextField {
            columns: 30
            value: bind url
        }
    },
    ImageView {
        transform: translate(0, 25)
        image: Image { url: bind url }
    }]
};

Canvas {
    content: ImageLoadNode { url: "http://blogs.sun.com/chrisoliver/resource/tesla.PNG" }
}
