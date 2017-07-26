package multiplescreens.controller;

import multiplescreens.ScreensController;

/**
 *
 * @author emil
 */
public abstract class AbstractController {
    
    protected ScreensController screensControler;
//    
//    protected Stage parentStage;
//    
//    public void setParentStage(Stage stage){
//        parentStage = stage;
//    }
//
    public void setScreenController(ScreensController service){
        screensControler =service;
    }
}
