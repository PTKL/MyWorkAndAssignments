/**
 Steganos Library Example
 
 This example attempts to retrieve hidden text from a 
 stegan stored in a file. The same stegan has been 
 saved in both PNG and JPG formats.
 
 Because JPG uses a lossy algorithm the looks unchanged
 but the burden image is corrupted.
 
 The moral of the srory is that if you want to save 
 do not use a lossy file format.
 
 created by Peter Lager 2015
 */

import org.quark.stegnos.*;

// Pass phrase used to embed the burden
String s1 = "mary had a little lamb it's fleece as white as snow";

PImage stegan;
String extracted;

void setup() {
  size(670, 500);
  background(200, 200, 240);
  noStroke();
  fill(255);
  rect(10, 30, 320, height);
  rect(10, 340, 320, height);
  fill(0);
  textSize(16);
  text("Retrieved from PNG file", 20, 20);
  text("Retrieved from JPG file", 350, 20);
  textSize(12);
  // Get the hidden image from a PNG file
  stegan = loadImage("textburden.png");
  extracted = Steganos.extractText(s1, stegan);
  text(extracted, 20, 30, 320, height);
  // Get the hidden image from a JPEG file
  stegan = loadImage("textburden.jpg");
  extracted = Steganos.extractText(s1, stegan);
  if (extracted != null)
    text(extracted, 350, 30, 320, height);
  else
    text("Unable to retrieve burden", 350, 100);
}

