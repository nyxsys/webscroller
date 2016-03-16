TICKER V1 by me

So you want a customizable ticker? Here it is!

To customize use your prefered text editor to open the config.xml file. There's only a few things in there, but nothing is checked
for correctness so be careful when changing it, consider saving a backup.

What each element does and additional instructions are as follows:


base-color : the color of the "split" element in your ticker, this will come in between each other element
color : each of these is a color that has a random chance of being selected as one of the colors in the ticker elements
you can add or remove them but I reccomend including around four to six depending on how long your ticker is.

All colors are in hex strings ONLY. Capitilization does not matter.

img : the image to be placed after the first message, whatever that may be

img-offset : allows minor user adjustment of image after loading

target : the target size of the image in the ticker

font : the name of the font you want to use. This font MUST be in .ttf format, any other type will not work.
 Include the font in the same folder as the ticker itself. Most fonts should be just fine but no gauruntees all will look the best.
 
 speed : the speed at which the ticker scrolls, decimals are allowed and encouraged, as most speeds past 2 will look very fast.
 
 
 
 default-message : the string that appears in the entry box when you first open the program.
 
 split : the string which will split the message after entry.