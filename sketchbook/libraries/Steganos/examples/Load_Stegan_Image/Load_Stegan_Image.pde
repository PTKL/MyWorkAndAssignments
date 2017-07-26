/**
 Steganos Library Example
 
 This example attempts to retrieve an image from a 
 stegan stored in a file. The same stegan has been 
 saved in both PNG and JPG formats.
 
 Because JPG uses a lossy algorithm the looks unchanged
 but the burden image is corrupted.
 
 The moral of the srory is that if you want to save the
 stegan do not use a lossy file format.
 
 created by Peter Lager 2015
 */

import org.quark.stegnos.*;

// Pass phrase used to embed the burden
String s1 = "mary had a little lamb it's fleece as white as snow";

PImage stegan, extracted;

void setup() {
  size(670, 200);
  background(200, 200, 240);
  fill(0);
  textSize(16);
  text("Retrieved from PNG file", 20, 20);
  text("Retrieved from JPG file", 350, 20);
  textSize(14);
  // Get the hidden image from a PNG file
  stegan = loadImage("imageburden.png");
  extracted = Steganos.extractImage(s1, stegan);
  image(extracted, 10, 30);
  // Get the hidden image from a JPEG file
  stegan = loadImage("imageburden.jpg");
  extracted = Steganos.extractImage(s1, stegan);
  if (extracted != null)
    image(extracted, 340, 30);
  else
    text("Unable to retrieve burden", 350, 100);
}

