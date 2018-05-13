------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Image Project
PURPOSE OF PROJECT: Modify and manipulate images using Java
VERSION or DATE: 05-05-2018
DEPENDENCIES: /resources/BookClasses
HOW TO START THIS PROJECT: Complie and run "Project.java"
AUTHORS: Matias Bonta


For the Image Project, I used five different methods to manipulate and tile the base image.
The base image is a picture of the Chicago river from the Lake Michigan side,
with some boats, namely a yellow water taxi. Two of the bridges in the picture are raised, on is not.
For one of the tiles, I used a method to recursively scale the image down and copy
it onto itself. Another of the tiles contains the image, greyscaled and mirrored both
vertically and horizontally. Another of the tiles is simply the image greyscaled.
The next row of tiles contains the image mirrored vertically, the original image, and
the image filtered to either pure black or pure white based on a cutoff color value.