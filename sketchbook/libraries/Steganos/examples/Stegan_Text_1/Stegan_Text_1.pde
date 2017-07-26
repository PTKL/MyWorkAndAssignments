/**
 Steganos Library Example
 
 This example shows how to create a stegan with a text 
 burden. It also shows how to use the analize method to
 confirm the carrier / burden combination.
 
 When extracting the burden from a stegan even very small 
 mistakes in entering the pass phrase will leave the
 extracted burden text corrupted.
 
 created by Peter Lager 2015
 
 */

import org.quark.stegnos.*;

// Pass phrase used to embed the burden
String s0 = "mary had a little lamb it's fleece as white as snow";
// Pass phrase to extract the burden
String s1 = "mary had a little lamb it's fleece as white as snow";

PImage carrier, stegan;
String burden, extracted;

void setup() {
  size(850, 630);
  background(200, 200, 240);
  noStroke();
  fill(255);
  rect(10, 360, 480, 240);
  fill(0);
  // Get the carrier and burden images
  carrier = loadImage("crr_rgb.jpg");
  String[] lines = loadStrings("ampoem.txt");
  burden = join(lines, "\n");
  // Perform analysis and display results
  Analysis a = Steganos.analyze(carrier, burden);
  text(a.text, 60, 360, 300, 240);
  // Make and display the stegan if approved
  if (a.approved) {
    fill(255);
    rect(500, 30, 320, height);
    stegan = Steganos.embedText(s0, carrier, burden);
    fill(0);
    textSize(16);
    text("STEGAN", 20, 20);
    image(stegan, 10, 30);
    extracted = Steganos.extractText(s1, stegan);
    // Display the burden if successfully extracted
    if (extracted != null) {
      text("Text extracted from stegan", 520, 20);
      textSize(12);
      text(extracted, 520, 60);
    }
  }
  stegan.save(savePath("textburden.png"));
  stegan.save(savePath("textburden.jpg")); 
}


