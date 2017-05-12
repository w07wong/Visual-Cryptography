PROJECT TITLE: Visual Encryption
PURPOSE OF PROJECT: Visually Encrypt Black and White images
VERSION: 1.0.0
HOW TO START THIS PROJECT: Run the Main method
AUTHORS: William Wong

For this project, I used the process of visually encrypting an image by creating two layers of random pixels.  With this method it is impossible to decrypt what the image is with just one layer.  To view the complete picture, both transparencies will have to be on top of each other. 

To generate the first layer, I created a random assortment of 2x2 squares.  Each 2x2 square contained 4 rectangles with widths and heights of 1.  A random sequence determined how each 2x2 square was filled in: either one of the two diagonals of the square are shaded in.  For example, if the sequence selected color scheme 0 (actually 1), then the top left and bottom right squares would be shaded in.

Creating the second layer was a bit different.  To make sure the image appears when both layers are on top of each other, I needed to make sure where there is black on the original image, a 2x2 square is filled in completely to represent that black pixel.  To do this, I read the original image, getting the RGB value for each pixel.  If the pixel was black, I went to the second layer, determined the color scheme used in the first layer, and created a square opposite to that first layer square.  By doing so, someone with both layers can put them on top of each other and create a black square with those 8 pixels (4 from each layer). 
