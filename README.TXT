PROJECT TITLE: Visual Encryption
PURPOSE OF PROJECT: Visualy Encrypt Black and White images
VERSION or DATE: 1.0.0
HOW TO START THIS PROJECT: Run the Main method
AUTHORS: William Wong
USER INSTRUCTIONS:
For this project, I used the process of visually encrypting an image by creating two layers of random pixels.
With this method it is impossible to decrypt what the image is with just one layer.  To view the complete
picture, both transparencies will have to be on top of each other. 

To generate the first layer, I created a random assortment of 2x2 squares.  Each 2x2 square contained
4 rectangles with widths and heights of 1.  The way each 2x2 square was colored in was determined by a random
squence where either one of the two diagonals of the square would be shaded in.  For example, if the squence
selected color scheme 0 (actually 1), then the top left and bottom right squares would be shaded in.  This 
process was applied to all the squares created.

Creating the second layer was a bit different.  To make sure the image appears when both layers are on top 
of each other, I needed to make sure where there is black on the original image, a 2x2 square is filled in 
completely to represent that black pixel.  To do this, I read the original image, getting the rgb value for 
each pixel.  If the pixel was black, I went to the second layer, determined the color scheme used in the 
first layer, and created a square opposite to that first layer square.  By doing so, someone with both 
layers can put them on top of each other and create a black square with those 8 pixels (4 from each layer). 

While it was recommended to output both layers separately then display the final layer, I had trouble doing
so.  I was able to remove the components from the frame but after doing so, I was not able to redraw the
component back onto the frame.  I tried using two instances of the DrawerComponent class but that did not
work either.
