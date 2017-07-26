/**
 Steganos Library Example
 
 This example shows how to create a stegan with an image 
 burden. It also shows how to use the analize method to
 confirm the carrier / burden.
 
 When extracting the burden from a stegan even very small 
 mistakes in entering the pass phrase will leave the
 extracted burden imgae corrupted.
 
 created by Peter Lager 2015
 
 */

import org.quark.stegnos.*;

// Pass phrase used to embed the burden
String s0 = "mary had a little lamb it's fleece as white as snow";
// Pass phrase to extract the burden
String s1 = "mary had a little lamb it's fleece as white as snow";

PImage carrier, burden, stegan, extracted;

void setup() {
  size(850, 630);
  background(200, 200, 240);
  noStroke();
  fill(255);
  rect(10, 360, 480, 240);
  fill(0);
  // Get the carrier and burden images
  carrier = loadImage("crr_rgb.jpg");
  burden = loadImage("bdn_rgb_l.jpg"); 
  // Perform analysis and display results
  Analysis a = Steganos.analyze(carrier, burden);
  text(a.text, 30, 360, 300, 240);
  // Make and display the stegan if approved
  if (a.approved) {
    stegan = Steganos.embedImage(s0, carrier, burden);
    textSize(16);
    text("STEGAN", 20, 20);
    image(stegan, 10, 30);
    extracted = Steganos.extractImage(s1, stegan);
    // Display the burden if successfully extracted
    if (extracted != null) {
      text("Image extracted from stegan", 520, 20);
      image(extracted, 500, 30);
    }
    stegan.save(savePath("imageburden.png"));
    stegan.save(savePath("imagetextburden.jpg"));
  }
} 
